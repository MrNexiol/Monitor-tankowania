package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.time.LocalDate

@Dao
interface RefuellingDAO {
    @Query("SELECT price, date, uid, vehicle_id FROM Refueling ORDER BY date DESC")
    fun getAllPrices(): LiveData<List<Refueling>>

    @Query("SELECT MIN(consumption) FROM Refueling")
    fun getMinConsumption(): LiveData<Double>

    @Query("SELECT AVG(consumption) FROM Refueling WHERE date>:fromDate")
    fun getAverageConsumption(fromDate: LocalDate): LiveData<Double>

    @Query("SELECT MAX(consumption) FROM Refueling")
    fun getMaxConsumption(): LiveData<Double>

    @Query("SELECT place FROM refueling GROUP BY place ORDER BY COUNT(*) DESC LIMIT 1")
    fun getFavouritePlace(): LiveData<String>

    @Query("SELECT * FROM Refueling WHERE uid=:uid LIMIT 1")
    fun get(uid: Int): LiveData<Refueling>

    @Insert
    suspend fun insert(refueling: Refueling)

    @Update
    suspend fun update(refueling: Refueling)

    @Delete
    suspend fun delete(refueling: Refueling)
}