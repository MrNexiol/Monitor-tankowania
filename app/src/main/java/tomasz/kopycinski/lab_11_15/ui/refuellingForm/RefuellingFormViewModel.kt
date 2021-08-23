package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomasz.kopycinski.lab_11_15.AppContainer
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.util.*

class RefuellingFormViewModel : ViewModel() {
    val calendar: Calendar = Calendar.getInstance()

    fun insertRefuelling(refueling: Refueling) = viewModelScope.launch {
        AppContainer.repository.insertRefuelling(refueling)
    }
}