package br.com.tmdev.agenda.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.adpter.AgendaAdapter
import br.com.tmdev.agenda.ui.base.BaseActivity
import br.com.tmdev.agenda.ui.form.FormActivity
import br.com.tmdev.agenda.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ListUserActivity : BaseActivity(), ContractList.View {

    companion object {
        private val TAG: String? = ListUserActivity::class.simpleName
    }

    private var mListViewModel: ListViewModel? = null
    private var mListPresenter: ContractList.Presenter? = null
    private var mRecycler: RecyclerView? = null
    private var mAgendaAdapter: AgendaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListPresenter = ListPresenter(this)

        mAgendaAdapter = AgendaAdapter(ArrayList())

        mRecycler = findViewById(R.id.recycler_view_id)
        mRecycler?.layoutManager = LinearLayoutManager(this)
        mRecycler?.setHasFixedSize(true)
        mRecycler?.adapter = mAgendaAdapter

        mListViewModel?.getAllUsers()?.observe(this, Observer {
            mListPresenter?.setListUsers(it)
        })

        floatingActionButton.setOnClickListener {
            openActivity(this, FormActivity::class.java, false, null)
        }

    }

    override fun updateListEmpty() {
    }

    override fun updateList(userList: MutableList<User>?) {
        mAgendaAdapter?.updateListUsers(userList)
    }

    override fun showProgress(show: Boolean) {

    }

}