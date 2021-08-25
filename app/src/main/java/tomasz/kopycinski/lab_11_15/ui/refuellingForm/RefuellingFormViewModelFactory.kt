package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class RefuellingFormViewModelFactory(private val refuellingId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RefuellingFormViewModel::class.java)) {
            return RefuellingFormViewModel(refuellingId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}