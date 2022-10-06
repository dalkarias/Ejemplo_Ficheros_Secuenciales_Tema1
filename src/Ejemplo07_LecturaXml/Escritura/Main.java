package Ejemplo07_LecturaXml.Escritura;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document documento = db.newDocument();

        //creo un elemento
        Element raiz  = documento.createElement("estudiantes");
        //que se lo enchufamos al padre
        documento.appendChild(raiz);


        //creamos estudiante  1
        Element estudiante1 = documento.createElement("estudiante");
        raiz.appendChild(estudiante1);



        Attr dni1 = documento.createAttribute("dni");
        dni1.setValue("1234569870");
        estudiante1.setAttributeNode(dni1);


        Element nombre1 = documento.createElement("nombre");
        estudiante1.appendChild(nombre1);
        nombre1.setTextContent("Paco");


        Element nota1 = documento.createElement("nota");
        estudiante1.appendChild(nota1);
        nota1.setTextContent("4.5");



        //creamos estudiante  2
        Element estudiante2 = documento.createElement("estudiante");
        raiz.appendChild(estudiante2);



        Attr dni2 = documento.createAttribute("dni");
        dni2.setValue("165237498");
        estudiante2.setAttributeNode(dni2);


        Element nombre2 = documento.createElement("nombre");
        estudiante2.appendChild(nombre2);
        nombre2.setTextContent("Pepe");


        Element nota2 = documento.createElement("nota");
        estudiante2.appendChild(nota2);
        nota2.setTextContent("5.5");


        //creamos estudiante  3
        Element estudiante3 = documento.createElement("estudiante");
        raiz.appendChild(estudiante3);



        Attr dni3 = documento.createAttribute("dni");
        dni3.setValue("3487298374");
        estudiante3.setAttributeNode(dni3);


        Element nombre3 = documento.createElement("nombre");
        estudiante3.appendChild(nombre3);
        nombre1.setTextContent("York");


        Element nota3 = documento.createElement("nota");
        estudiante3.appendChild(nota3);
        nota3.setTextContent("9.5");


        //coger el documento y transformarlo en un formato DOM
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer optimus = tf.newTransformer();

        DOMSource ds = new DOMSource(documento);

        optimus.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new File("estudiante.xml"));

        optimus.transform(ds,result);


    }
}
