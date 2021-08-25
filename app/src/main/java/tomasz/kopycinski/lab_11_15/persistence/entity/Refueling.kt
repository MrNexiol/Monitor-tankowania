package tomasz.kopycinski.lab_11_15.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Refueling(
    @ColumnInfo(name = "vehicle_id") val vehicleId: Int,
    @ColumnInfo(name = "date") var date: LocalDate,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "price_per_liter") var pricePerLiter: Double?,
    @ColumnInfo(name = "place") var place: String?,
    @ColumnInfo(name = "mileage") var mileage: Int?,
    @ColumnInfo(name = "consumption") var consumption: Double? = null,
    @ColumnInfo(name = "distance_since_refuelled") val distanceSinceRefuelled: Int? = null,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
)
