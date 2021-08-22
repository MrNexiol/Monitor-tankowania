package tomasz.kopycinski.lab_11_15.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Refueling(
    @ColumnInfo(name = "vehicle_id") val vehicleId: Int,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "consumption") val consumption: Double,
    @ColumnInfo(name = "price_per_liter") val pricePerLiter: Double?,
    @ColumnInfo(name = "place") val place: String?,
    @ColumnInfo(name = "mileage") val mileage: Int?,
    @ColumnInfo(name = "distance_since_refuelled") val distanceSinceRefuelled: Int?,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
