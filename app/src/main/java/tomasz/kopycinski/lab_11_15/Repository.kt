package tomasz.kopycinski.lab_11_15

import androidx.lifecycle.LiveData
import tomasz.kopycinski.lab_11_15.persistence.dao.VehicleDAO
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class Repository(private val vehicleDAO: VehicleDAO) {
    fun getVehicles(): LiveData<List<Vehicle>> {
        return vehicleDAO.getAll()
    }

    suspend fun insertVehicle(vehicle: Vehicle) {
        vehicleDAO.insert(vehicle)
    }
}