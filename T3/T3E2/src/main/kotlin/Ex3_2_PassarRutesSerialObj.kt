import java.io.DataInput
import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.RandomAccessFile

fun main()  {
    val f = DataInputStream(FileInputStream("Rutes.dat"))
    val i = ObjectOutputStream(FileOutputStream("Rutes.obj"))

    while (f.available() > 0) {
        var nom = f.readUTF()
        var desnivell = f.readInt()
        var desnivellAcumulat = f.readInt()
        var numPunts = f.readInt()
        var NPunts = mutableListOf<PuntGeo>()
        for (i in 1..numPunts) {
            var nom = f.readUTF()
            var coordenades = Coordenades(f.readDouble(),f.readDouble())
            var punto = PuntGeo(nom,coordenades)
            NPunts.add(punto)
        }

        val ruta = Ruta(nom,desnivell,desnivellAcumulat,NPunts)
        i.writeObject(ruta)
        ruta.mostrarRuta()


    }
    f.close()
    i.close()

}