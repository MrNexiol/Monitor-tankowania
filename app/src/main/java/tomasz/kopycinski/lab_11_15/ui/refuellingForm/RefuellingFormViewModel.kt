package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tomasz.kopycinski.lab_11_15.AppContainer
import tomasz.kopycinski.lab_11_15.persistence.entity.Refueling
import java.time.LocalDate

class RefuellingFormViewModel : ViewModel() {
    var localDate: LocalDate = LocalDate.now()

    fun insertRefuelling(refueling: Refueling) = viewModelScope.launch {
        AppContainer.repository.insertRefuelling(refueling)
    }
}