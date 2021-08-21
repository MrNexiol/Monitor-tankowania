package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import androidx.lifecycle.ViewModel
import tomasz.kopycinski.lab_11_15.AppContainer

class VehicleDetailsViewModel(vehicleId: Int) : ViewModel() {
    val vehicle = AppContainer.repository.getVehicle(vehicleId)
}