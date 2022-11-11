package com.example.skeletonapp.data.source.local.dao

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.skeletonapp.data.source.local.db.InstantTypeConverter
import com.example.skeletonapp.data.source.local.entity.BaseEntity
import java.time.Instant

@Dao
abstract class AppDao<T : BaseEntity>(
    private val tableName: String,
    private val idColumnName: String = "id"
) {

    @Update
    abstract suspend fun update(obj: T)

    @Update
    abstract suspend fun update(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertOrUpdate(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertOrUpdate(obj: List<T>)

    @Delete
    abstract suspend fun delete(obj: T)

    @Delete
    abstract suspend fun delete(obj: List<T>)

    @RawQuery
    protected abstract suspend fun deleteAll(query: SupportSQLiteQuery): Int
    suspend fun deleteAll() {
        deleteAll(SimpleSQLiteQuery("delete from $tableName"))
    }

    @RawQuery
    protected abstract suspend fun deleteAllExcept(query: SupportSQLiteQuery): Int
    suspend fun deleteAllExcept(id: String) {
        deleteAllExcept(SimpleSQLiteQuery("DELETE FROM $tableName WHERE id <> '$id'"))
    }

    @RawQuery
    protected abstract suspend fun softDelete(query: SupportSQLiteQuery): Int
    suspend fun softDelete(id: String) {
        val deletedTime = InstantTypeConverter.fromInstant(Instant.now())
        softDelete(
            SimpleSQLiteQuery(
                "Update $tableName " +
                        "SET deletedAt = '$deletedTime', updatedAt = '$deletedTime' " +
                        "WHERE id = '$id'"
            )
        )
    }

    @RawQuery
    protected abstract fun getAll(query: SupportSQLiteQuery): List<T>
    suspend fun getAll(): List<T> {
        return getAll(SimpleSQLiteQuery("select * from $tableName where deleted_at = null"))
    }

    @RawQuery
    protected abstract fun getById(query: SupportSQLiteQuery): List<T>
    suspend fun getById(id: String): List<T> {
        return getById(SimpleSQLiteQuery("select * from $tableName where $idColumnName =  $id and deleted_at = null"))
    }

    @RawQuery
    protected abstract suspend fun count(query: SupportSQLiteQuery): Int?
    suspend fun count(): Int? {
        return count(
            SimpleSQLiteQuery("SELECT COUNT (*) FROM $tableName")
        )
    }

    @RawQuery
    protected abstract suspend fun exist(query: SupportSQLiteQuery): T?
    suspend fun exist(id: String): T? {
        return exist(
            SimpleSQLiteQuery(
                "SELECT EXISTS(SELECT * FROM $tableName WHERE $idColumnName = '$id')"
            )
        )
    }

}