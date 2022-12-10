package com.example.capstonepesaing.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserPreference @Inject constructor(@ApplicationContext val context: Context) {

    private val dataStore = context.dataStore


    companion object{
        private val EMAIL = stringPreferencesKey("email")
        private val USER_ID = stringPreferencesKey("userid")
    }
}