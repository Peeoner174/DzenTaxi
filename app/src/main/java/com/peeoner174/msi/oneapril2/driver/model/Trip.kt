package com.peeoner174.msi.oneapril2.driver.model


/**Формируем список требуемого типа, который будет хранить данные, переданные с сервера**/

data class Trip  (val id: String,
                  val photo: String,
                  val title: String,
                  val date: String,
                  val place: String,
                    val user_image: String
){
    class List: ArrayList<Trip>()

}

