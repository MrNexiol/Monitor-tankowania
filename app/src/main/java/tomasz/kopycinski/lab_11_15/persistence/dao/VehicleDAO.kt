package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

@Dao
interface VehicleDAO {
    @Query("SELECT * FROM Vehicle")
    fun getAll(): Flow<List<Vehicle>>
}