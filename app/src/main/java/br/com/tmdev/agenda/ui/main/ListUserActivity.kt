package br.com.tmdev.agenda.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.constants.BundleConstants
import br.com.tmdev.agenda.databinding.ActivityMainBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository
import br.com.tmdev.agenda.ui.adapter.AgendaAdapter
import br.com.tmdev.agenda.ui.base.BaseActivity
import br.com.tmdev.agenda.ui.form.FormActivity
import br.com.tmdev.agenda.util.OpenActivity
import br.com.tmdev.agenda.util.RecyclerItemTouchHelper
import br.com.tmdev.agenda.util.RecyclerItemTouchHelperListener
import br.com.tmdev.agenda.viewmodel.ListViewModel
import com.google.android.material.snackbar.Snackbar

class ListUserActivity : BaseActivity(), ContractList.View,
    AgendaAdapter.OnClickListener, RecyclerItemTouchHelperListener {

    private var mListViewModel: ListViewModel? = null
    private var mListPresenter: ContractList.Presenter? = null
    private var mAgendaAdapter: AgendaAdapter? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListPresenter = ListPresenter(this, AgendaRepository(this))

        mAgendaAdapter = AgendaAdapter(ArrayList(), this)

        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewId.setHasFixedSize(true)
        binding.recyclerViewId.itemAnimator = DefaultItemAnimator()
        binding.recyclerViewId.adapter = mAgendaAdapter

        val iteCall: ItemTouchHelper.SimpleCallback =
            RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(iteCall).attachToRecyclerView(binding.recyclerViewId)

        mListViewModel?.getAllUsers()?.observe(this, Observer {
            mListPresenter?.setListUsers(it)
        })

        binding.btnAdd.setOnClickListener {
            OpenActivity.start(this, FormActivity::class.java, false, null)
        }

    }

    override fun onBackPressed() {
        finish()
    }

    override fun showRecycler(show: Boolean) {
        if (show) {
            binding.recyclerViewId.visibility = View.VISIBLE
        } else {
            binding.recyclerViewId.visibility = View.INVISIBLE
        }
    }

    override fun updatedList(userList: MutableList<User>?) {
        mAgendaAdapter?.updateListUsers(userList)
    }

    override fun showProgress(show: Boolean) {}

    override fun editData(id: Int) {

        val bundle = Bundle()
        bundle.putInt(BundleConstants.KEY.ID_USER, id)

        OpenActivity.start(this, FormActivity::class.java, false, bundle)
    }

    override fun edit(view: View, position: Int) {
        mListPresenter?.setPositionEdit(position)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        if (viewHolder is AgendaAdapter.ViewHolder) {
            mListPresenter?.removeItem(viewHolder.adapterPosition)
        }
    }

    override fun updateUiRemovedItem(name: String) {
        val snackBar = Snackbar.make(binding.btnAdd, "$name removido", Snackbar.LENGTH_LONG)
        snackBar.setAction("Desfazer", View.OnClickListener {
            mListPresenter?.restoreItem()
        })
        snackBar.show()
    }
}