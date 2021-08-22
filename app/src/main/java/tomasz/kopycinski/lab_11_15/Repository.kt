package tomasz.kopycinski.lab_11_15

import androidx.lifecycle.LiveData
import tomasz.kopycinski.lab_11_15.persistence.dao.VehicleDAO
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle
import tomasz.kopycinski.lab_11_15.persistence.entity.VehicleWithRefuellings

class Repository(private val vehicleDAO: VehicleDAO) {
    fun getVehicles(): LiveData<List<Vehicle>> {
        return vehicleDAO.getAll()
    }

    fun getVehicle(id: Int): LiveData<Vehicle> {
        return vehicleDAO.get(id)
    }

    fun getVehicleWithRefuellings(id: Int): LiveData<VehicleWithRefuellings> {
        return vehicleDAO.getVehicleWithRefuellings(id)
    }

    suspend fun updateVehicle(vehicle: Vehicle) {
        vehicleDAO.update(vehicle)
    }

    suspend fun insertVehicle(vehicle: Vehicle) {
        vehicleDAO.insert(vehicle)
    }

    suspend fun deleteVehicle(vehicle: Vehicle) {
        vehicleDAO.delete(vehicle)
    }
}