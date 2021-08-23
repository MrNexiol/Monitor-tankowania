package tomasz.kopycinski.lab_11_15.ui.refuellingForm

import androidx.lifecycle.ViewModel
import java.util.*

class RefuellingFormViewModel : ViewModel() {
    var year: Int = 0
    var month: Int = 0
    var day: Int = 0

    init {
        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
    }
}