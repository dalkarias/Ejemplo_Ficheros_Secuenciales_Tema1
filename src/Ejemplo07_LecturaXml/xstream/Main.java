package Ejemplo07_LecturaXml.xstream;

import Ejemplo07_LecturaXml.Modelos.Empleado;
import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) {
        Empleado em1 = new Empleado(1,"Garcia",20,2458);

        XStream xStream = new XStream();
        // tenemos que darle acceso a las clases que vallamos a usar ene el
        xStream.allowTypesByWildcard(new String[]{
                "Ejemplo07_LecturaXml.Modelos.*"
        });

        String xml = xStream.toXML(em1);
        System.out.println(xml);

        Empleado em2 = new Empleado();
        xStream.fromXML(xml,em2);
        System.out.println(em2);

    }
}
