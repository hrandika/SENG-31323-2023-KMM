package com.hrandika.seng31323_2023_kmm.android.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseInstanceIDService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("FirebaseInstanceID",token)
    }
}