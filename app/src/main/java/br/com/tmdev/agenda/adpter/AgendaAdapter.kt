package br.com.tmdev.agenda.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User

class AgendaAdapter : RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private var mAgendaItem: MutableList<User> = mutableListOf()

    constructor(agendaItem: MutableList<User>) : super() {
        this.mAgendaItem = agendaItem
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTextName: AppCompatTextView? = itemView.findViewById(R.id.text_view_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mAgendaItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mAgendaItem[position]

        holder.mTextName?.text = item.name
    }

    fun updateListUsers(userList: MutableList<User>?) {
       if (userList != null && userList.isNotEmpty()) {
           mAgendaItem = userList
           notifyDataSetChanged()
       }
    }

}