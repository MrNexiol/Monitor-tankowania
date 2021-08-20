package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

@Dao
interface VehicleDAO {
    @Query("SELECT * FROM Vehicle")
    fun getAll(): LiveData<List<Vehicle>>

    @Insert
    suspend fun insert(vehicle: Vehicle)
}