package com.peeoner174.msi.oneapril2.driver.model


/**Формируем список требуемого типа, который будет хранить данные, переданные с сервера**/

data class Driver(val id: Int,
                  val name: String,
                  val car: String,
                  val rating: String,
                  val price: String,

                  val image: String
){
    class List: ArrayList<Driver>()

}

