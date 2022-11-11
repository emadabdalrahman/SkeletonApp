package com.example.skeletonapp.data.source.cache

import java.util.concurrent.ConcurrentHashMap

class MemCache : Cache {

    companion object {
        private val map = ConcurrentHashMap<String, Any>()
    }

    override suspend fun putBoolean(key: String, value: Boolean) {
        map.run { put(key, value) }
    }

    override suspend fun putFloat(key: String, value: Float) {
        map.run { put(key, value) }
    }

    override suspend fun putLong(key: String, value: Long) {
        map.run { put(key, value) }
    }

    override suspend fun putInt(key: String, value: Int) {
        map.run { put(key, value) }
    }

    override suspend fun putString(key: String, value: String) {
        map.run { put(key, value) }
    }

    override suspend fun putChar(key: String, value: Char) {
        map.run { put(key, value) }
    }

    override suspend fun putByte(key: String, value: Byte) {
        map.run { put(key, value) }
    }

    override suspend fun putShort(key: String, value: Short) {
        map.run { put(key, value) }
    }

    override suspend fun putDouble(key: String, value: Double) {
        map.run { put(key, value) }
    }

    override suspend fun getBoolean(key: String, default: Boolean): Boolean {
        return map.getOrDefault(key, default) as Boolean
    }

    override suspend fun getFloat(key: String, default: Float): Float {
        return map.getOrDefault(key, default) as Float
    }

    override suspend fun getLong(key: String, default: Long): Long {
        return map.getOrDefault(key, default) as Long
    }

    override suspend fun getInt(key: String, default: Int): Int {
        return map.getOrDefault(key, default) as Int
    }

    override suspend fun getString(key: String, default: String): String {
        return map.getOrDefault(key, default) as String
    }

    override suspend fun getChar(key: String, default: Char): Char {
        return map.getOrDefault(key, default) as Char
    }

    override suspend fun getByte(key: String, default: Byte): Byte {
        return map.getOrDefault(key, default) as Byte
    }

    override suspend fun getShort(key: String, default: Short): Short {
        return map.getOrDefault(key, default) as Short
    }

    override suspend fun getDouble(key: String, default: Double): Double {
        return map.getOrDefault(key, default) as Double
    }

    override suspend fun putObj(key: String, value: Any) {
        map.run { put(key, value) }
    }

    override suspend fun <T> getObj(key: String, default: T, type: Class<T>): T {
        return map.getOrDefault(key, default as Any) as T
    }

    override suspend fun remove(key: String) {
        map.remove(key)
    }

    override suspend fun clear() {
        map.clear()
    }

}