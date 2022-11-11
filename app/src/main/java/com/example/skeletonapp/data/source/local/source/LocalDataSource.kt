package com.example.skeletonapp.data.source.local.source

import com.example.skeletonapp.data.source.local.dao.AppDao
import com.example.skeletonapp.data.source.local.entity.BaseEntity

open class LocalDataSource<T : BaseEntity>(private val dao: AppDao<T>) {

    open suspend fun delete(obj: T) {
        dao.delete(obj)
    }

    open suspend fun delete(vararg obj: T) {
        dao.delete(obj.toList())
    }

    open suspend fun delete(obj: List<T>) {
        dao.delete(obj)
    }

    open suspend fun deleteAll() {
        dao.deleteAll()
    }

    open suspend fun deleteAllExcept(id: String) {
        dao.deleteAllExcept(id)
    }

    open suspend fun softDelete(id: String) {
        dao.softDelete(id)
    }

    open suspend fun softDelete(vararg ids: String) {
        ids.forEach { dao.softDelete(it) }
    }

    open suspend fun update(obj: T) {
        dao.update(obj)
    }

    open suspend fun update(vararg obj: T) {
        dao.update(obj.toList())
    }

    open suspend fun update(obj: List<T>) {
        dao.update(obj)
    }

    open suspend fun insert(obj: T) {
        dao.insert(obj)
    }

    open suspend fun insert(vararg obj: T) {
        dao.insert(obj.toList())
    }

    open suspend fun insert(obj: List<T>) {
        dao.insert(obj)
    }

    open suspend fun insertOrUpdate(obj: T) {
        dao.insertOrUpdate(obj)
    }

    open suspend fun insertOrUpdate(vararg obj: T) {
        dao.insertOrUpdate(obj.toList())
    }

    open suspend fun insertOrUpdate(obj: List<T>) {
        dao.insertOrUpdate(obj)
    }

    open suspend fun getAll(): List<T> {
        return dao.getAll()
    }

    open suspend fun getById(id: String): List<T> {
        return dao.getById(id)
    }

    open suspend fun count(): Int? {
        return dao.count()
    }

    open suspend fun exist(id: String): T? {
        return dao.exist(id)
    }

}