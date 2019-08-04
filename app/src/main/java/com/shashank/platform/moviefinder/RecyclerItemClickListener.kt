package com.shashank.platform.moviefinder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

open class RecyclerItemClickListener(context: Context, val listener: OnItemClickListener) : RecyclerView.OnItemTouchListener{

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    var mGestureDetector =  GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            return true
        }
    })

    override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
        val childView = view.findChildViewUnder(e.x, e.y)
        if (childView != null && listener != null && mGestureDetector.onTouchEvent(e)) {
            listener!!.onItemClick(childView, view.getChildAdapterPosition(childView))
        }

        Log.i("INFO", e.toString())
        return false
    }

    override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}