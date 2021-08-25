package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling

@Dao
interface RefuellingDAO {
    @Query("SELECT price, place, date, uid, vehicle_id FROM Refueling WHERE vehicle_id=:vehicleId ORDER BY date DESC")
    fun getAllByVehicleId(vehicleId: Int): LiveData<List<Refueling>>

    @Query("SELECT * FROM Refueling WHERE uid=:uid LIMIT 1")
    fun get(uid: Int): LiveData<Refueling>

    @Insert
    suspend fun insert(refueling: Refueling)
}