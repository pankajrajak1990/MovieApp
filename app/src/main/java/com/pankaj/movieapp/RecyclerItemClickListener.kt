package com.pankaj.movieapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView


class RecyclerItemClickListener(
    private val mRecycler: RecyclerView, private val clickListener: OnClickListener? = null,
    private val longClickListener: OnLongClickListener? = null
) : RecyclerView.OnChildAttachStateChangeListener {

    override fun onChildViewDetachedFromWindow(view: View) {
        view.setOnClickListener(null)
        view.setOnLongClickListener(null)
    }


    override fun onChildViewAttachedToWindow(view: View) {
        view.setOnClickListener { v ->

            val position = getViewLayoutPosition(view)
            if (position.inValid()) return@setOnClickListener

            clickListener?.onItemClick(position, v)
        }

        view.setOnLongClickListener { v ->

            val position = getViewLayoutPosition(v)
            if (position.inValid()) return@setOnLongClickListener false

            longClickListener?.onLongItemClick(position, v)
            true
        }

    }
    /*             view.findViewById<MathView>(R.id.mathView).getChildAt(0).setOnTouchListener({ v,e ->
    */

    private fun getViewLayoutPosition(v: View?) =
        v?.let { mRecycler.getChildLayoutPosition(it) } ?: 0

    interface OnClickListener {
        fun onItemClick(position: Int, view: View)
    }

    interface OnLongClickListener {
        fun onLongItemClick(position: Int, view: View?)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, id: String)
    }
}