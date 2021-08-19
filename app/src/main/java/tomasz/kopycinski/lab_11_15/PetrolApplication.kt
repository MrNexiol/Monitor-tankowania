package tomasz.kopycinski.lab_11_15

import android.app.Application
import tomasz.kopycinski.lab_11_15.persistence.AppDatabase

class PetrolApplication : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { Repository(database.vehicleDao()) }
}