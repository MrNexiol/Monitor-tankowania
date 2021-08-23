package tomasz.kopycinski.lab_11_15

import android.content.Context
import tomasz.kopycinski.lab_11_15.persistence.AppDatabase

object AppContainer {
    lateinit var database: AppDatabase
    lateinit var repository: Repository

    fun init(context: Context) {
        database = AppDatabase.getDatabase(context)
        repository = Repository(database.vehicleDao(), database.refuellingDao())
    }
}