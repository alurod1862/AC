import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class FitxerImatge(fEnt: File) {
    var f: File = File("")

    init {
        val fichero_entrada = FileInputStream("Penyagolosa.bmp")
        val lectura = fichero_entrada.read()
        if (lectura > 1) {
            f = fEnt
        } else {
            println("No se encontro el archivo")
        }
    }


    fun transformaNegativo() {

        // Transformar a negativo
        val fichero_entrada = FileInputStream("Penyagolosa.bmp")
        val fichero_salida = FileOutputStream("imatge1_n.bmp")
        val buffer = ByteArray(1)
        var lectura = fichero_entrada.read(buffer)
        var contador = 0
        while (lectura != -1) {
            if (contador >= 54) {
                fichero_salida.write(255 - lectura)
                lectura = fichero_entrada.read()
                contador++
            } else {
                fichero_salida.write(buffer)
                lectura = fichero_entrada.read(buffer)
                contador++
            }
        }
        fichero_entrada.close()
        fichero_salida.close()
    }

    fun transformaObscur() {
        val fichero_entrada = FileInputStream("Penyagolosa.bmp")
        val fichero_salida = FileOutputStream("imatge1_o.bmp")
        val buffer = ByteArray(1)
        var lectura = fichero_entrada.read(buffer)
        var contador = 0
        while (lectura != -1) {
            if (contador >= 54) {
                fichero_salida.write(lectura/2)
                lectura = fichero_entrada.read()
                contador++
            } else {
                fichero_salida.write(buffer)
                lectura = fichero_entrada.read(buffer)
                contador++
            }
        }
        fichero_entrada.close()
        fichero_salida.close()
    }

    fun transformaBlancNegre() {
        val fichero_entrada = FileInputStream("Penyagolosa.bmp")
        val fichero_salida = FileOutputStream("imatge1_bn.bmp")
        val buffer = ByteArray(1)
        var lectura = fichero_entrada.read(buffer)

        var lectura3 = 0

        var contador = 0

        while (lectura3 != -1) {
            if (contador >= 54) {
                val lectura1 = fichero_entrada.read()
                val lectura2 = fichero_entrada.read()
                lectura3 = fichero_entrada.read()
                val sumabyte = lectura1 + lectura2 + lectura3
                fichero_salida.write(sumabyte / 3)
                fichero_salida.write(sumabyte / 3)
                fichero_salida.write(sumabyte / 3)
                contador++
            } else {
                fichero_salida.write(buffer)
                lectura = fichero_entrada.read(buffer)
                contador++
            }
        }

        fichero_entrada.close()
        fichero_salida.close()

    }

}



fun main(args: Array<String>){
    val f = File("Penyagolosa.bmp")

    val fi = FitxerImatge(f)
    fi.transformaNegativo()
    fi.transformaObscur()
    fi.transformaBlancNegre()
}