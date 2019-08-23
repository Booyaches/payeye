package com.example.payeyetask.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(it, getAdapterPosition(), getItemViewType())
    }
    return this
}