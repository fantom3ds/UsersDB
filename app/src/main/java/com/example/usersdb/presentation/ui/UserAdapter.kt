package com.example.usersdb.presentation.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersdb.R
import com.example.usersdb.data.model.UserDb
import kotlinx.android.synthetic.main.rv_user_item.view.*
import java.text.SimpleDateFormat


class UserAdapter(private var userDbs: MutableList<UserDb>) : RecyclerView.Adapter<UserAdapter.Holder>() {

    //Определяем переменную типа функции
    var onItemClickFunction: ((user: UserDb) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.rv_user_item, parent, false))
    }

    override fun getItemCount(): Int {
        return userDbs.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        userDbs[position].apply {
            holder.itemView.apply {
                user_name.text = name
                user_activity.text = SimpleDateFormat("dd.MM.yy HH:mm:ss").format(lastActivity * 1000)
                user_status.text = status
                if (online == 1) {
                    list_item.setBackgroundColor(Color.GREEN)
                }
            }
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClickFunction?.invoke(userDbs[adapterPosition])
            }
        }
    }

    fun setUsers(list: List<UserDb>) {
        userDbs.clear()
        userDbs.addAll(list)
        notifyDataSetChanged()
    }

    fun getUser(pos: Int): UserDb {
        return userDbs[pos]
    }
}