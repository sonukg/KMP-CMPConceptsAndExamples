package org.sonukg

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val AUTH_TOKEN = stringPreferencesKey("auth_token")
    val IS_AUTHENTICATED = booleanPreferencesKey("is_authenticated")
}