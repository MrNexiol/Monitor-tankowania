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

    @Query("SELECT * FROM vehicle WHERE uid = :id LIMIT 1")
    fun get(id: Int): LiveData<Vehicle>

    @Insert
    suspend fun insert(vehicle: Vehicle)
}