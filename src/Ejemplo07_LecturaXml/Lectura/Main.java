package Ejemplo07_LecturaXml.Lectura;

import Ejemplo07_LecturaXml.Modelos.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File ficheroEmpleadosXml = new File("./src/Ejemplo07_LecturaXml/Empleados.xml");

        //parsear el fichero xml => NO LEO PASO A PASO EL FICHERO
        // lo lee completo y monta el DOM

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // variable que genera documentos

        DocumentBuilder db = dbf.newDocumentBuilder(); // construye documentos

        // Ahora dentro de una variable documento Dom cargara todo el contenido del ficheero

        Document documento = db.parse(ficheroEmpleadosXml);

        documento.getDocumentElement().normalize();// limpio los nodos para una mejor visualización

        System.out.println("Raiz del documento: "+ documento.getDocumentElement().getNodeName()); // accede a la raiz del documento y nos lo mostrara por pantalla

        //LISTAS DE NODOS

        NodeList nodos = documento.getElementsByTagName("empleado");

        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            System.out.println("Elemento: "+nodo.getNodeName());
            //acceder a los hijos que tiene dentro el nodo
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element empleado = (Element) nodo;
                //atributos
                String dni = empleado.getAttribute("dni");
                String apellido = empleado.getElementsByTagName("apellido").item(0).getTextContent();//coge el contenido del apellido
                int id = Integer.parseInt(empleado.getElementsByTagName("id").item(0).getTextContent());
                int dep = Integer.parseInt(empleado.getElementsByTagName("dep").item(0).getTextContent());
                float salario = Float.parseFloat(empleado.getElementsByTagName("salario").item(0).getTextContent());


                Empleado em1 = new Empleado(id,apellido,dep,salario);

                System.out.println(em1.toString());
            }
        }

        // ESCRIBIR

    }
}
