import java.io.RandomAccessFile


fun main() {

    val f = RandomAccessFile("Rutes.dat", "r")
    var mida = f.length()
    f.seek(0)


    while (f.filePointer < mida) {
        println("Ruta: " + f.readUTF())
        println("Desnivell: " + f.readInt())
        println("Desnivell acumulat: " + f.readInt())
        val numPunts = f.readInt()
        println("Te " + numPunts + " punts")
        for (i in 1..numPunts) {
            println("Punt $i: " + f.readUTF() + " (" + f.readDouble() + "," + f.readDouble() + ") ")

        }
        println("---------------------------------------------------------------------")
    }
    f.close()
}