import java.io.File

var directoriActual = File("/")

fun llistarFitxersIDirectorios(directori: File) {
    println("Directori actual: " + directori.absolutePath)
    println("---------------------------------------------------")
    println("0.- Directori Pare")

    val fitxersIDirectoris = directori.listFiles()
    for (i in fitxersIDirectoris.indices) {
        val fitxer = fitxersIDirectoris[i]
        val tipus = if (fitxer.isDirectory) "<Directori>" else "Fitxer"
        println((i + 1).toString() + ".- " + fitxer.name + "\t" + tipus)
    }
}

fun main() {
    while (true) {
        llistarFitxersIDirectorios(directoriActual)
        println("Introdueix un número (-1 per sortir, 0 per al directori pare): ")
        val entrada = readLine()

        if (entrada == "-1") {
            break
        } else if (entrada == "0") {
            val parePath = directoriActual.parent
            if (parePath != null && File(parePath).canRead()) {
                directoriActual = File(parePath)
            } else {
                println("No es pot accedir al directori pare.")
            }
        } else {
            try {
                val numeroEntrada = entrada?.toInt()
                if (numeroEntrada != null && numeroEntrada > 0) {
                    val fitxersIDirectoris = directoriActual.listFiles()
                    if (numeroEntrada <= fitxersIDirectoris.size) {
                        val fitxerSeleccionat = fitxersIDirectoris[numeroEntrada - 1]
                        if (fitxerSeleccionat.isDirectory && fitxerSeleccionat.canRead()) {
                            directoriActual = fitxerSeleccionat
                        } else {
                            println("No es pot accedir al directori seleccionat.")
                        }
                    } else {
                        println("Número fora de rang. Introdueix un número vàlid.")
                    }
                } else {
                    println("Número no vàlid. Introdueix -1, 0 o un número vàlid.")
                }
            } catch (e: NumberFormatException) {
                println("Entrada no vàlida. Introdueix un número vàlid.")
            }
        }
    }

    println("Fi del programa.")
}
