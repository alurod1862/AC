package BBDDIntelliJ

fun main() {
    menuPostrgeSQL()
}

fun menuPostrgeSQL(){

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
        println("Introduce una opcion(1-7): ")


        elecion = readln()!!.toInt()

        if (elecion == 1) {
            createTableMP()
        } else if (elecion == 2) {
            deleteTableMP()
        } else if (elecion == 3) {
            updateTableMP()
        } else if (elecion == 4) {
            insertarDatosTablaMP()
        } else if (elecion == 5) {
            dropTableMP()
        } else if (elecion == 6) {
            consultaTableMP()
        } else if (elecion == 7) {
            sige = false
        } else {
            "Opcion no valida"
        }
    }

}
