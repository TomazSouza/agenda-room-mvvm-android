package br.com.tmdev.agenda.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.adpter.AgendaAdapter
import br.com.tmdev.agenda.constants.BundleConstants
import br.com.tmdev.agenda.ui.base.BaseActivity
import br.com.tmdev.agenda.ui.form.FormActivity
import br.com.tmdev.agenda.viewmodel.ListViewModel
import br.com.tmdev.agenda.util.OpenActivity
import kotlinx.android.synthetic.main.activity_main.*

class ListUserActivity : BaseActivity(),
    ContractList.View,
    AgendaAdapter.OnClickListener {

    private var mListViewModel: ListViewModel? = null
    private var mListPresenter: ContractList.Presenter? = null
    private var mAgendaAdapter: AgendaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListPresenter = ListPresenter(this)

        mAgendaAdapter = AgendaAdapter(ArrayList(), this)

        recyclerViewId.layoutManager = LinearLayoutManager(this)
        recyclerViewId.setHasFixedSize(true)
        recyclerViewId.adapter = mAgendaAdapter

        mListViewModel?.getAllUsers()?.observe(this, Observer {
            mListPresenter?.setListUsers(it)
        })

        btnAdd.setOnClickListener {
            OpenActivity.start(this, FormActivity::class.java, true, null)
        }

    }

    override fun updateListEmpty() {}

    override fun updateList(userList: MutableList<User>?) {
        mAgendaAdapter?.updateListUsers(userList)
    }

    override fun showProgress(show: Boolean) {}

    override fun editData(id: Int) {

        val bundle = Bundle()
        bundle.putInt(BundleConstants.KEY.ID_USER, id)

        OpenActivity.start(this, FormActivity::class.java, true, bundle)
    }

    override fun edit(view: View, position: Int) {
        mListPresenter?.setPositionEdit(position)
    }

}