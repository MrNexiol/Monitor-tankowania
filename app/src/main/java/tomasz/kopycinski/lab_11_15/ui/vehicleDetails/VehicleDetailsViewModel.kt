package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomasz.kopycinski.lab_11_15.AppContainer
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleDetailsViewModel(vehicleId: Int) : ViewModel() {
    val vehicle = AppContainer.repository.getVehicle(vehicleId)
    val refuellings = AppContainer.repository.getRefuellingsByVehicleId(vehicleId)

    fun deleteVehicle(vehicle: Vehicle) = viewModelScope.launch {
        AppContainer.repository.deleteVehicle(vehicle)
    }
}