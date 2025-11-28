package com.example.activity7.repositori

import android.content.Context
import kotlin.getValue
import android.app.Application
import com.example.activity7.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

// 2. Concrete Implementation of the Container
class ContainerDataApp(private val context: Context):
    ContainerApp {

    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            siswaDao = DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk men[dapatkan dependensi].
     * (AppContainer instance is used by other classes to get dependencies.)
     */

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}