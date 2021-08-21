package tomasz.kopycinski.lab_11_15.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Refueling(
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "consumption") val consumption: Double,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
