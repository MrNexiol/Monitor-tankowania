package tomasz.kopycinski.lab_11_15

import androidx.lifecycle.LiveData
import tomasz.kopycinski.lab_11_15.persistence.dao.RefuellingDAO
import tomasz.kopycinski.lab_11_15.persistence.dao.VehicleDAO
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle
import tomasz.kopycinski.lab_11_15.persistence.entity.VehicleWithRefuellings
import java.time.LocalDate

class Repository(private val vehicleDAO: VehicleDAO,
                 private val refuellingDAO: RefuellingDAO) {
    fun getVehicle(id: Int): LiveData<Vehicle> {
        return vehicleDAO.get(id)
    }

    fun getVehicles(): LiveData<List<Vehicle>> {
        return vehicleDAO.getAll()
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

    fun getRefuelling(id: Int): LiveData<Refueling> {
        return refuellingDAO.get(id)
    }

    fun getRefuellingPrices(): LiveData<List<Refueling>> {
        return refuellingDAO.getAllPrices()
    }

    fun getMinRefuellingConsumption(): LiveData<Double> {
        return refuellingDAO.getMinConsumption()
    }

    fun getAvgRefuellingConsumptionFromDate(localDate: LocalDate): LiveData<Double> {
        return refuellingDAO.getAverageConsumption(localDate)
    }

    fun getMaxRefuellingConsumption(): LiveData<Double> {
        return refuellingDAO.getMaxConsumption()
    }

    fun getFavouriteRefuellingPlace(): LiveData<String> {
        return refuellingDAO.getFavouritePlace()
    }

    suspend fun insertRefuelling(refueling: Refueling) {
        refuellingDAO.insert(refueling)
    }

    suspend fun updateRefuelling(refueling: Refueling) {
        refuellingDAO.update(refueling)
    }

    suspend fun removeRefuelling(refueling: Refueling) {
        refuellingDAO.delete(refueling)
    }
}