package exemples


import PuntGeo
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.Serializable
    class Ruta(
        var nom: String,
        var desnivell: Int,
        var desnivellAcumulat: Int,
        var llistaDePunts: MutableList<PuntGeo>
    ) : Serializable {
        companion object {
            private const val serialVersionUID: Long = 1
        }

        fun addPunt(p: PuntGeo) {
            llistaDePunts.add(p)
        }

        fun getPunt(i: Int): PuntGeo {
            return llistaDePunts.get(i)
        }

        fun getPuntNom(i: Int): String {
            return llistaDePunts.get(i).nom
        }

        fun getPuntLatitud(i: Int): Double {
            return llistaDePunts.get(i).coord.latitud
        }

        fun getPuntLongitud(i: Int): Double {
            return llistaDePunts.get(i).coord.longitud
        }

        fun size(): Int {
            return llistaDePunts.size
        }

        fun mostrarRuta() {
            val r = ObjectInputStream(FileInputStream("Rutes.obj"))

            try {
                while (true){
                    val e = r.readObject() as Ruta
                    println("Ruta: " + e.nom)
                    println("Desnivell: " + e.desnivell)
                    println("Desnivell acumulat: " + e.desnivell)
                    println("Te " + e.llistaDePunts.size + " punts")
                    for (i in 0..e.size()-1) {
                        println("Punt ${i+1}: " + e.llistaDePunts[i].nom + " (" + e.llistaDePunts[i].coord.longitud + "," + e.llistaDePunts[i].coord.latitud  + ") ")

                    }
                    println("---------------------------------------------------------------------")
                }
                r.close()

            }catch (eof: EOFException){
                r.close()
            }


            }

        }