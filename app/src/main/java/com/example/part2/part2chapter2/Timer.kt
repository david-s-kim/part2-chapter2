package com.example.part2.part2chapter2

import android.os.Looper

// 복습
class Timer(listener: OnTimerTickListener) {
    private var duration = 0L
    private val handler = android.os.Handler(Looper.getMainLooper())
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            duration += 40L
            handler.postDelayed(this, 40L)
            listener.onTick(duration)
        }

    }

    fun start() {
        handler.postDelayed(runnable, 40L)
    }

    fun stop() {
        handler.removeCallbacks(runnable)
    }
}

interface OnTimerTickListener {
    fun onTick(duration: Long) {

    }
}