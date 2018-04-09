package com.peeoner174.msi.oneapril2.dzen.data.model

data class Note  (val id: String,
                  val title: String,
                  val note_text: String
){
    class List: ArrayList<Note>()



}