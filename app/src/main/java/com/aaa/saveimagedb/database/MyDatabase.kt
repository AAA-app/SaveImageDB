package com.aaa.saveimagedb.database

import android.content.Context
import androidx.room.*
import com.aaa.saveimagedb.Converters
import com.aaa.saveimagedb.dao.MyDao
import com.aaa.saveimagedb.data.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
 abstract  class MyDatabase : RoomDatabase() {

    abstract fun myDao(): MyDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context):
                MyDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDataBase(context).also { INSTANCE = it}
        }
        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                MyDatabase::class.java, "my_database")
            .build()
    }

}


