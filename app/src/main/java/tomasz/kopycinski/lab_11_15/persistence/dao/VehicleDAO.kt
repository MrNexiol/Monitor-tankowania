package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle
import tomasz.kopycinski.lab_11_15.persistence.entity.VehicleWithRefuellings

@Dao
interface VehicleDAO {
    @Query("SELECT * FROM Vehicle")
    fun getAll(): LiveData<List<Vehicle>>

    @Transaction
    @Query("SELECT * FROM Vehicle WHERE uid = :id LIMIT 1")
    fun getVehicleWithRefuellings(id: Int): LiveData<VehicleWithRefuellings>

    @Query("SELECT * FROM vehicle WHERE uid = :id LIMIT 1")
    fun get(id: Int): LiveData<Vehicle>

    @Update
    suspend fun update(vehicle: Vehicle)

    @Insert
    suspend fun insert(vehicle: Vehicle)

    @Delete
    suspend fun delete(vehicle: Vehicle)
}