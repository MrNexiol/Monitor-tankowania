package tomasz.kopycinski.lab_11_15.ui.vehicleDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class VehicleDetailsViewModelFactory(private val vehicleId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VehicleDetailsViewModel::class.java)) {
            return VehicleDetailsViewModel(vehicleId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}