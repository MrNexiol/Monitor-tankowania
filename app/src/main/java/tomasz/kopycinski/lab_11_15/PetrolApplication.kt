package tomasz.kopycinski.lab_11_15

import android.app.Application

class PetrolApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContainer.init(this)
    }
}