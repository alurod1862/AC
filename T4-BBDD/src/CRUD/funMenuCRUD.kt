package CRUD

fun main() {
        menu()
}

fun menu(){

    var elecion:Int =0
    var sige = true

    while (sige) {


    println("Bienvenido al menu ")
    println("1.CREATE")
    println("2.DELETE")
    println("3.UPDATE")
    println("4.INSERT")
    println("5.DROP")
    println("6.CONSULT")
    println("7.SALIR")
    println("Introduce una opcion(1-6): ")


    elecion = readln()!!.toInt()
    var tabla = ""

        if (elecion == 1) {
            createTableM()
        } else if (elecion == 2) {
            deleteTableM()
        } else if (elecion == 3) {
            updateTableM()
        } else if (elecion == 4) {
            insertarDatosTablaM()
        } else if (elecion == 5) {
            dropTableM()
        } else if (elecion == 6) {
            consultaTableM()
        } else if (elecion == 7) {
            sige = false
        } else {
            "Opcion no valida"
        }
    }

}


fun queTablaEs(var tabla :String){
    println("Introduce la tabla sobre la que vas a trabajar ")
    tabla = readln()!!.toString()
}