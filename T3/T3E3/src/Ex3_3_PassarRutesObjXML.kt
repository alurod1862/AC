import java.io.ObjectInputStream
import java.io.FileInputStream
import javax.xml.parsers.DocumentBuilderFactory
import java.io.EOFException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main(args: Array<String>) {
    val f = ObjectInputStream(FileInputStream ("Rutes.obj"))

    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    val arrel = doc.createElement ("rutes")
    doc.appendChild(arrel)

    try {
        while (true) {
            val e = f.readObject () as Ruta
            val emp = doc.createElement ("ruta")
            emp.setAttribute("ruta", (e.nom))

            val nom = doc.createElement ("nom")
            nom.appendChild(doc.createTextNode(e.nom)) // forma llarga: afegim un fill que és un node de text
            emp.appendChild(nom)

            val desnivell = doc.createElement("desnivell")
            desnivell.setTextContent(e.desnivell.toString()) // forma curta: amb setTextContent() li posem contingut
            emp.appendChild(desnivell)

            val desnivellA = doc.createElement("desnivellAcumulat")
            desnivellA.setTextContent(e.desnivellAcumulat.toString())
            emp.appendChild(desnivellA)

            val punts = doc.createElement("Punts")


            for (i in 0..e.llistaDePunts.size-1){
                val punt = doc.createElement("punt")

                    val nomPunt = doc.createElement("nom")
                    nomPunt.setTextContent(e.getPuntNom(i))
                    nomPunt.setAttribute("num", i.toString())
                    punt.appendChild(nomPunt)

                    val longitudPunt = doc.createElement("longitud")
                    longitudPunt.setTextContent(e.getPuntLongitud(i).toString())
                    punt.appendChild(longitudPunt)

                    val latitudPunt = doc.createElement("latitud")
                    latitudPunt.setTextContent(e.getPuntLatitud(i).toString())
                    punt.appendChild(latitudPunt)

                punts.appendChild(punt)
            }
            emp.appendChild(punts)

            arrel.appendChild(emp)
        }

    } catch (eof: EOFException) {
        f.close();
    }
    val trans = TransformerFactory.newInstance().newTransformer()

    trans.transform(DOMSource(doc), StreamResult("Rutes.xml"))
}

