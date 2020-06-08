package br.com.tmdev.agenda.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import com.google.android.flexbox.FlexboxLayout

class AgendaAdapter(agendaItem: MutableList<User>, onClickListener: OnClickListener) : RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    private var mAgendaItem: MutableList<User> = agendaItem
    private var mOnClickListener: OnClickListener =  onClickListener

    class ViewHolder : RecyclerView.ViewHolder {

        var mTextName: AppCompatTextView? = null
        var mTextEmail: AppCompatTextView? = null
        var mTextContact: AppCompatTextView? = null
        var mItemView: View? = null

        var mViewBackground: RelativeLayout? = null
        var mViewForeground: RelativeLayout? = null

        constructor(itemView: View) : super(itemView) {

            mItemView = itemView;

            mTextName = itemView.findViewById(R.id.text_view_name)
            mTextEmail = itemView.findViewById(R.id.text_view_email)
            mTextContact = itemView.findViewById(R.id.text_view_contact)

            mViewBackground = itemView.findViewById(R.id.viewBackground)
            mViewForeground = itemView.findViewById(R.id.viewForegroundId)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mAgendaItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mAgendaItem[position]

        holder.mTextName?.text = item.name
        holder.mTextEmail?.text = item.email
        holder.mTextContact?.text = item.contact

        holder.mItemView?.setOnClickListener { v -> mOnClickListener.edit(v, position) }
    }

    fun updateListUsers(userList: MutableList<User>?) {
       if (userList != null && userList.isNotEmpty()) {
           mAgendaItem = userList
           notifyDataSetChanged()
       }
    }

    fun removeItem(position: Int) {
        mAgendaItem?.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: User, position: Int) {
        mAgendaItem?.add(position, item)
        notifyItemInserted(position)
    }

    interface OnClickListener {
        fun edit(view: View, position: Int)
    }

}