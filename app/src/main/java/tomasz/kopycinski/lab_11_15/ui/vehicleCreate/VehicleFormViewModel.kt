package tomasz.kopycinski.lab_11_15.ui.vehicleCreate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomasz.kopycinski.lab_11_15.AppContainer
import tomasz.kopycinski.lab_11_15.persistence.entity.Vehicle

class VehicleFormViewModel(vehicleId: Int) : ViewModel() {
    val vehicle = AppContainer.repository.getVehicle(vehicleId)

    fun insertVehicle(vehicle: Vehicle) = viewModelScope.launch {
        AppContainer.repository.insertVehicle(vehicle)
    }

    fun updateVehicle(vehicle: Vehicle) = viewModelScope.launch {
        AppContainer.repository.updateVehicle(vehicle)
    }
}