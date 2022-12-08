package com.example.capstonepesaing.data

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserPreference @Inject constructor(@ApplicationContext val context: Context) {

    companion object{
        private val NAME_KEY = stringPreferencesKey("name")
        private val EMAIL = stringPreferencesKey("email")
        private val PASSWORD = stringPreferencesKey("password")
        private val USER_ID = stringPreferencesKey("userid")
        private val LOGIN_STATE = stringPreferencesKey("state")
    }
}