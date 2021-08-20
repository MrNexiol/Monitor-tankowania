package tomasz.kopycinski.lab_11_15.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "model") val model: String?,
    @ColumnInfo(name = "licensePlate") val licensePlate: String?,
    @ColumnInfo(name = "date") val date: Long?,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
