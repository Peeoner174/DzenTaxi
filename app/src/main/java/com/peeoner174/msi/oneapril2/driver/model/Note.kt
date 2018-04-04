package com.peeoner174.msi.oneapril2.driver.model
/**Формируем список требуемого типа, который будет хранить данные, переданные с сервера**/

data class Note  (val id: String,
                  val title: String,
                  val note_text: String
){
    class List: ArrayList<Note>()

}