package tomasz.kopycinski.lab_11_15.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling

@Dao
interface RefuellingDAO {
    @Insert
    suspend fun insert(refueling: Refueling)
}