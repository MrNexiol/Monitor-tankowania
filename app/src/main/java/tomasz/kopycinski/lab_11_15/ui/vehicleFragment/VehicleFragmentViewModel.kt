package tomasz.kopycinski.lab_11_15.ui.vehicleFragment

import androidx.lifecycle.ViewModel
import tomasz.kopycinski.lab_11_15.AppContainer

class VehicleFragmentViewModel : ViewModel() {
    val vehicleList = AppContainer.repository.getVehicles()
}