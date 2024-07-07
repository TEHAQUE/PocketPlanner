package com.example.pocketplaner.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class NotiEl(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var title: String,
    var cost: Float,
    var date: Date
)

//fun getFakeNoti(): List<NotiEl>{
//    return listOf<NotiEl>(
//        NotiEl(1,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(2,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(3,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(1,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(2,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(3,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(1,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(2,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(3,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(1,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(2,"Witam",34.53F,Date.from(Instant.now())),
//        NotiEl(3,"Witam",34.53F,Date.from(Instant.now()))
//    )
//}