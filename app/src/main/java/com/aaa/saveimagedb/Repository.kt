package com.aaa.saveimagedb

import androidx.lifecycle.LiveData
import com.aaa.saveimagedb.dao.MyDao
import com.aaa.saveimagedb.data.Person

class Repository(private val myDao: MyDao) {
    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person) {
        myDao.insertPerson(person)
    }
}