package com.example.pocketplaner.ui.theme


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class SubEl(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var title: String,
    var cost: Float,
    var date: Date
)
fun getFakeSub(): List<SubEl>{
    return listOf<SubEl>(
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
        SubEl(1,"Witam",34.53F,Date.from(Instant.now())),
    )
}