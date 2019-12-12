package br.com.tmdev.agenda.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.recycler.AgendaAdapter
import br.com.tmdev.agenda.ui.form.FormActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = 1

        val list = mutableListOf<User>()

        while (i < 25) {
            val agendaItem = User()
            agendaItem.name = "Agenda $i"
            list.add(agendaItem)
            i++
        }

        val adapter = AgendaAdapter(list)

        val mRecycler: RecyclerView = findViewById(R.id.recycler_view_id)
        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.setHasFixedSize(true)
        mRecycler.adapter = adapter

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

    }

}