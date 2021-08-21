package tomasz.kopycinski.lab_11_15.ui.vehicleForm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class VehicleFormViewModelFactory(private val vehicleId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VehicleFormViewModel::class.java)) {
            return VehicleFormViewModel(vehicleId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}