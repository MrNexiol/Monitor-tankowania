package tomasz.kopycinski.lab_11_15.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tomasz.kopycinski.lab_11_15.persistence.dao.RefuellingDAO
import tomasz.kopycinski.lab_11_15.persistence.dao.VehicleDAO
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

@Database(entities = [Vehicle::class, Refueling::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDAO
    abstract fun refuellingDao(): RefuellingDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "petrol_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}