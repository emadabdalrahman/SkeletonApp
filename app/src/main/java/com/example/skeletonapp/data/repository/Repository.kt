package com.example.skeletonapp.data.repository

import com.example.skeletonapp.data.source.local.entity.BaseEntity
import com.example.skeletonapp.data.source.local.source.LocalDataSource
import kotlinx.coroutines.flow.Flow

open class Repository<T : BaseEntity>(private val local: LocalDataSource<T>) {

    open suspend fun delete(obj: T) {
        local.delete(obj)
    }

    open suspend fun delete(vararg obj: T) {
        local.delete(obj.toList())
    }

    open suspend fun delete(obj: List<T>) {
        local.delete(obj)
    }

    open suspend fun deleteAll() {
        local.deleteAll()
    }

    open suspend fun softDelete(obj: T) {
        local.softDelete(obj.id)
    }

    open suspend fun softDelete(vararg obj: T) {
        local.delete(obj.toList())
    }

    open suspend fun update(obj: T) {
        local.update(obj)
    }

    open suspend fun update(vararg obj: T) {
        local.update(obj.toList())
    }

    open suspend fun update(obj: List<T>) {
        local.update(obj)
    }

    open suspend fun insert(obj: T) {
        local.insert(obj)
    }

    open suspend fun insert(vararg obj: T) {
        local.insert(obj.toList())
    }

    open suspend fun insert(obj: List<T>) {
        local.insert(obj)
    }

    open suspend fun insertOrUpdate(obj: T) {
        local.insertOrUpdate(obj)
    }

    open suspend fun insertOrUpdate(vararg obj: T) {
        local.insertOrUpdate(obj.toList())
    }

    open suspend fun insertOrUpdate(obj: List<T>) {
        local.insertOrUpdate(obj)
    }

    open suspend fun getAll(): List<T> {
        return local.getAll()
    }

    open suspend fun getById(id: String): List<T> {
        return local.getById(id)
    }

    open suspend fun count(): Int? {
        return local.count()
    }

    open suspend fun exist(id: String): T? {
        return local.exist(id)
    }
}