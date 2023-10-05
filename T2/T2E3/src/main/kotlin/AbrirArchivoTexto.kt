import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.BufferedReader
import java.io.FileReader
import javax.swing.*
import javax.swing.plaf.nimbus.NimbusLookAndFeel

class AbrirArchivoTexto : JFrame(), ActionListener {
    //------------------------------Action Performed-------------------------------//
    override fun actionPerformed(e: ActionEvent) {
        val btn = e.source as JButton
        if (btn.text == "Abrir") {
            if (abrirArchivo == null) abrirArchivo = JFileChooser()
            //Con esto solamente podamos abrir archivos
            abrirArchivo!!.fileSelectionMode = JFileChooser.FILES_ONLY
            val seleccion = abrirArchivo!!.showOpenDialog(this)
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                val f = abrirArchivo!!.selectedFile
                try {
                    val nombre = f.name
                    val path = f.absolutePath
                    val contenido = getArchivo(path)
                    //Colocamos en el titulo de la aplicacion el
                    //nombre del archivo
                    title = nombre

                    //En el editor de texto colocamos su contenido
                    txp.text = contenido
                } catch (exp: Exception) {
                }
            }
        }
    }

    //-----------------------------------------------------------------------------//
    //-------------------------Se obtiene el contenido del Archivo----------------//
    fun getArchivo(ruta: String?): String {
        var fr: FileReader? = null
        var br: BufferedReader? = null
        //Cadena de texto donde se guardara el contenido del archivo
        var contenido = ""
        try {
            //ruta puede ser de tipo String o tipo File
            fr = FileReader(ruta)
            br = BufferedReader(fr)
            var linea: String
            //Obtenemos el contenido del archivo linea por linea
            while (br.readLine().also { linea = it } != null) {
                contenido += linea + "\n"
            }
        } catch (e: Exception) {
        } //finally se utiliza para que si todo ocurre correctamente o si ocurre
        //algun error se cierre el archivo que anteriormente abrimos
        finally {
            try {
                br!!.close()
            } catch (ex: Exception) {
            }
        }
        return contenido
    }

    var txp: JTextPane
    var abrirArchivo: JFileChooser? = null

    init {
        //Para poder cerrar la ventana
        defaultCloseOperation = EXIT_ON_CLOSE

        //Se agrega un layout
        layout = BorderLayout()

        //Se crea el editor de texto y se agrega a un scroll
        txp = JTextPane()
        val jsp = JScrollPane()
        jsp.setViewportView(txp)
        add(jsp, BorderLayout.CENTER)

        //Se crea un boton para abrir el archivo
        val btn = JButton("Abrir")
        btn.addActionListener(this)
        add(btn, BorderLayout.NORTH)

        //Tamaño de la ventana
        setSize(500, 500)

        //Esto sirve para centrar la ventana
        setLocationRelativeTo(null)

        //Hacemos visible la ventana
        isVisible = true
    }


}


fun main(arg: Array<String>) {
    AbrirArchivoTexto()
}