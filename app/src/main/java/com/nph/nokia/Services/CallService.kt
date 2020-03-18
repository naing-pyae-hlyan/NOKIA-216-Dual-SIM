package com.nph.nokia.Services

import android.telecom.Call
import android.telecom.InCallService
import com.nph.nokia.Helpers.OngoingCallHelper

class CallService: InCallService() {

    override fun onCallAdded(call: Call){
        OngoingCallHelper.call = call

        // TODO NEW CALLING ACTIVITY
        // CallActivity.start(this, call)
    }

    override fun onCallRemoved(call: Call?) {
        OngoingCallHelper.call = null
    }
}