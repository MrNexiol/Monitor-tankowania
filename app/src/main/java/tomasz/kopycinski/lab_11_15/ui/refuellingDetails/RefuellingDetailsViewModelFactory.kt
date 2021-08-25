package tomasz.kopycinski.lab_11_15.ui.refuellingDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class RefuellingDetailsViewModelFactory(private val refuellingId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RefuellingDetailsViewModel::class.java)) {
            return RefuellingDetailsViewModel(refuellingId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}