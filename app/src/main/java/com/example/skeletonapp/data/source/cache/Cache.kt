package com.example.skeletonapp.data.source.cache

interface Cache {
    suspend fun putBoolean(key: String, value: Boolean)
    suspend fun putFloat(key: String, value: Float)
    suspend fun putLong(key: String, value: Long)
    suspend fun putInt(key: String, value: Int)
    suspend fun putString(key: String, value: String)
    suspend fun putChar(key: String, value: Char)
    suspend fun putByte(key: String, value: Byte)
    suspend fun putShort(key: String, value: Short)
    suspend fun putDouble(key: String, value: Double)
    suspend fun getBoolean(key: String, default: Boolean = false): Boolean
    suspend fun getFloat(key: String, default: Float = 0F): Float
    suspend fun getLong(key: String, default: Long = 0L): Long
    suspend fun getInt(key: String, default: Int = 0): Int
    suspend fun getString(key: String, default: String = ""): String
    suspend fun getChar(key: String, default: Char = ' '): Char
    suspend fun getByte(key: String, default: Byte = 0): Byte
    suspend fun getShort(key: String, default: Short = 0): Short
    suspend fun getDouble(key: String, default: Double = 0.0): Double
    suspend fun remove(key: String)
    suspend fun clear()
    suspend fun putObj(key: String, value: Any)
    suspend fun <T> getObj(key: String, default: T, type: Class<T>): T
}