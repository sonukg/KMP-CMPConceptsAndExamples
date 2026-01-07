package org.sonukg

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

actual object AppDataStore {
    actual val dataStore: DataStore<Preferences> by lazy {
        createDataStore()
    }

    actual fun createDataStore(): DataStore<Preferences> {
        return createDataStore(producePath = {
            //val file = File(System.getProperty("user.home"), dataStoreFileName)
            val file = File(System.getProperty("java.io.tmpdir"), dataStoreFileName)
            file.absolutePath
        })
    }
}