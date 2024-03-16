package com.example.sortby.models.empty

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.sortby.models.data.Contact
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
val contact = listOf(
    Contact("Volnei", LocalDate.of(2018, 11, 15)),
    Contact("Pedro", LocalDate.of(2017, 12, 24)),
    Contact("Mariah", LocalDate.of(2017, 10, 1)),
    Contact("Duda", LocalDate.of(2016, 1, 19)),
        Contact("Jose", LocalDate.of(2015, 2, 1)),
    Contact("Volnei", LocalDate.of(20144, 5, 7)),
    )