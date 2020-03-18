package com.nph.nokia.Helpers

import android.telecom.Call
import android.telecom.VideoProfile
import android.util.Log

object OngoingCallHelper {

    private val callback = object : Call.Callback(){
        override fun onStateChanged(call: Call?, state: Int) {
            Log.d("MYCALL",call.toString())
        }
    }

    var call: Call? = null
    set(value) {
        field?.unregisterCallback(callback)
        value?.let {
            it.registerCallback(callback)
        }
        field = value
    }

    fun answer(){
        call!!.answer(VideoProfile.STATE_AUDIO_ONLY)
    }

    fun hangup(){
        call!!.disconnect()
    }
}