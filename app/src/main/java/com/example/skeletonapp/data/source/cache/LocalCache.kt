package com.example.skeletonapp.data.source.cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class LocalCache(context: Context) : Cache {

    private val sharedPref = context.getSharedPreferences(
        LocalCache::class.java.simpleName,
        Context.MODE_PRIVATE
    )

    override suspend fun putBoolean(key: String, value: Boolean) = edit {
        putBoolean(key, value)
    }

    override suspend fun putFloat(key: String, value: Float) = edit {
        putFloat(key, value)
    }

    override suspend fun putLong(key: String, value: Long) = edit {
        putLong(key, value)
    }

    override suspend fun putInt(key: String, value: Int) = edit {
        putInt(key, value)
    }

    override suspend fun putString(key: String, value: String) = edit {
        putString(key, value)
    }

    override suspend fun putChar(key: String, value: Char) = edit {
        putString(key, value.toString())
    }

    override suspend fun putByte(key: String, value: Byte) = edit {
        putString(key, value.toString())
    }

    override suspend fun putShort(key: String, value: Short) = edit {
        putString(key, value.toString())
    }

    override suspend fun putDouble(key: String, value: Double) = edit {
        putString(key, value.toString())
    }

    override suspend fun getBoolean(key: String, default: Boolean): Boolean = get {
        getBoolean(key, default)
    }

    override suspend fun getFloat(key: String, default: Float): Float = get {
        getFloat(key, default)
    }

    override suspend fun getLong(key: String, default: Long): Long = get {
        getLong(key, default)
    }

    override suspend fun getInt(key: String, default: Int): Int = get {
        getInt(key, default)
    }

    override suspend fun getString(key: String, default: String): String = get {
        getString(key, default)
    }

    override suspend fun getChar(key: String, default: Char): Char = get {
        getString(key, default.toString())
    }.first()

    override suspend fun getByte(key: String, default: Byte): Byte = get {
        getString(key, default.toString())
    }.toByte()

    override suspend fun getShort(key: String, default: Short): Short = get {
        getString(key, default.toString())
    }.toShort()

    override suspend fun getDouble(key: String, default: Double): Double = get {
        getString(key, default.toString())
    }.toDouble()

    override suspend fun putObj(key: String, value: Any) = edit {
        putString(key, Gson().toJson(value))
    }

    override suspend fun <T> getObj(key: String, default: T, type: Class<T>): T = get {
        val data = this.getString(key, "")
        if (data == null || data.isBlank() || data.isEmpty()) {
            return@get default
        }
        Gson().fromJson(data, type) as T
    }

    override suspend fun remove(key: String) = edit {
        remove(key)
    }

    override suspend fun clear() = edit {
        clear()
    }

    private fun edit(action: SharedPreferences.Editor.() -> Unit) {
        val edit = sharedPref.edit()
        action(edit)
        edit.apply()
    }

    private fun <T> get(action: SharedPreferences.() -> T?): T {
        return action(sharedPref)!!
    }

}