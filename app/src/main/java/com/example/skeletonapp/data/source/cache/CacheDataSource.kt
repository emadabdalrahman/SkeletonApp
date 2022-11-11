package com.example.skeletonapp.data.source.cache

import android.content.Context
import com.example.skeletonapp.data.source.cache.MemCache

class CacheDataSource(
    private val context: Context,
    private val mem: MemCache = MemCache(),
    private val local: LocalCache = LocalCache(context)
) : Cache {

    var cachingStrategy: CachingStrategy = CachingStrategy.Local

    override suspend fun putBoolean(key: String, value: Boolean) =
        strategy(mem = { putBoolean(key, value) }, local = { putBoolean(key, value) })

    override suspend fun putFloat(key: String, value: Float) =
        strategy(mem = { putFloat(key, value) }, local = { putFloat(key, value) })

    override suspend fun putLong(key: String, value: Long) =
        strategy(mem = { putLong(key, value) }, local = { putLong(key, value) })

    override suspend fun putInt(key: String, value: Int) =
        strategy(mem = { putInt(key, value) }, local = { putInt(key, value) })

    override suspend fun putString(key: String, value: String) =
        strategy(mem = { putString(key, value) }, local = { putString(key, value) })

    override suspend fun putChar(key: String, value: Char) =
        strategy(mem = { putChar(key, value) }, local = { putChar(key, value) })

    override suspend fun putByte(key: String, value: Byte) =
        strategy(mem = { putByte(key, value) }, local = { putByte(key, value) })

    override suspend fun putShort(key: String, value: Short) =
        strategy(mem = { putShort(key, value) }, local = { putShort(key, value) })

    override suspend fun putDouble(key: String, value: Double) =
        strategy(mem = { putDouble(key, value) }, local = { putDouble(key, value) })

    override suspend fun getBoolean(key: String, default: Boolean): Boolean =
        strategy(mem = { getBoolean(key, default) }, local = { getBoolean(key, default) })

    override suspend fun getFloat(key: String, default: Float): Float =
        strategy(mem = { getFloat(key, default) }, local = { getFloat(key, default) })

    override suspend fun getLong(key: String, default: Long): Long =
        strategy(mem = { getLong(key, default) }, local = { getLong(key, default) })

    override suspend fun getInt(key: String, default: Int): Int =
        strategy(mem = { getInt(key, default) }, local = { getInt(key, default) })

    override suspend fun getString(key: String, default: String): String =
        strategy(mem = { getString(key, default) }, local = { getString(key, default) })

    override suspend fun getChar(key: String, default: Char): Char =
        strategy(mem = { getChar(key, default) }, local = { getChar(key, default) })

    override suspend fun getByte(key: String, default: Byte): Byte =
        strategy(mem = { getByte(key, default) }, local = { getByte(key, default) })

    override suspend fun getShort(key: String, default: Short): Short =
        strategy(mem = { getShort(key, default) }, local = { getShort(key, default) })

    override suspend fun getDouble(key: String, default: Double): Double =
        strategy(mem = { getDouble(key, default) }, local = { getDouble(key, default) })

    override suspend fun remove(key: String) =
        strategy(mem = { remove(key) }, local = { remove(key) })

    override suspend fun clear() =
        strategy(mem = { clear() }, local = { clear() })

    override suspend fun putObj(key: String, value: Any) =
        strategy(mem = { putObj(key, value) }, local = { putObj(key, value) })

    override suspend fun <T> getObj(key: String, default: T, type: Class<T>): T =
        strategy(mem = { getObj(key, default, type) }, local = { getObj(key, default, type) })

    private suspend fun <T> strategy(
        mem: suspend MemCache.() -> T,
        local: suspend LocalCache.() -> T
    ): T {
        return when (cachingStrategy) {
            CachingStrategy.Local -> local(this.local)
            CachingStrategy.Memory -> mem(this.mem)
        }
    }
}