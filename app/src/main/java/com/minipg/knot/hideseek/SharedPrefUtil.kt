package com.minipg.knot.hideseek

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by User on 19/9/2560.
 */
class SharedPrefUtil(private val mContext: Context) {
    internal var sharedPreferences: SharedPreferences
    internal var editor: SharedPreferences.Editor

    private val PREF_SHARE = "prefShared"
    private val PREF_MODE = Context.MODE_PRIVATE
    private val NAME = "name"
    private val USERID = "userId"

    init {
        this.sharedPreferences = mContext.getSharedPreferences(PREF_SHARE, PREF_MODE)
        this.editor = sharedPreferences.edit()
    }


    fun saveUserId(userId: String) {
        if (sharedPreferences.contains(USERID)) {
            editor.remove(USERID)
        }
        editor.putString(USERID, userId)
        editor.commit()
    }

    fun saveName(name: String) {
        if (sharedPreferences.contains(NAME)) {
            editor.remove(NAME)
        }
        editor.putString(NAME, name)
        editor.commit()
    }

    val userId: String
        get() = sharedPreferences.getString(USERID, "")

    val name: String
        get() = sharedPreferences.getString(NAME, "")


    fun clearSharedPref() {
        editor.clear()
        editor.commit()
    }
}
