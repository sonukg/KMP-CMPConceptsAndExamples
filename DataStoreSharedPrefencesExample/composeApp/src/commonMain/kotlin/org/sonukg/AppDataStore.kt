package org.sonukg

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

expect object AppDataStore {
    val dataStore: DataStore<Preferences>
    fun createDataStore(): DataStore<Preferences>
}

fun createDataStore(producePath:()-> String): DataStore<Preferences>{
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = {
            producePath().toPath()
        }
    )
}

internal const val dataStoreFileName = "kmpapp.preferences_pb"