package tomasz.kopycinski.lab_11_15.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Vehicle(
    @ColumnInfo(name = "brand") var brand: String,
    @ColumnInfo(name = "model") var model: String,
    @ColumnInfo(name = "licensePlate") var licensePlate: String,
    @ColumnInfo(name = "date") var date: Date,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
