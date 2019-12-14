package br.com.tmdev.agenda.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.presenters.list.ContractList
import br.com.tmdev.agenda.presenters.list.ListPresenter
import br.com.tmdev.agenda.recycler.AgendaAdapter
import br.com.tmdev.agenda.repository.AgendaRepository
import br.com.tmdev.agenda.ui.form.FormActivity
import br.com.tmdev.agenda.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ListUserActivity : AppCompatActivity(), ContractList.View {

    private val TAG = "script"

    private var mListViewModel: ListViewModel? = null
    private var mListPresenter: ContractList.Presenter? = null
    private var mRecycler: RecyclerView? = null
    private var mAgendaAdapter: AgendaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mListPresenter = ListPresenter(this)

        mListViewModel?.getAllUsers()?.observe(this, Observer {
            Log.w("script", "users: $it")
            mListPresenter?.setListUsers(it)
        })

        mAgendaAdapter = AgendaAdapter(ArrayList())

        mRecycler = findViewById(R.id.recycler_view_id)
        mRecycler?.layoutManager = LinearLayoutManager(this)
        mRecycler?.setHasFixedSize(true)
        mRecycler?.adapter = mAgendaAdapter

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

//        val repository = AgendaRepository(this)
//
//        repository.getAllUsers()?.observe(this, Observer {
//            Log.w("script", "users: $it")
//            mListPresenter?.setListUsers(it)
//        })

    }

    override fun updateListEmpty() {

    }

    override fun updateList(userList: MutableList<User>?) {
        mAgendaAdapter?.updateListUsers(userList)
    }

    override fun showProgress(show: Boolean) {

    }

}