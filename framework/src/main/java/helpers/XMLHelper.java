package helpers;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import context.ContextManager;
import context.Objects;
import context.PreObjects;
import context.Usuario;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLHelper {

    public static Objects object;
    public static ArrayList<PreObjects> preObjects = new ArrayList<>();

    public static void guardarXml(String testName) {
        try {
            File file = new File("src/main/java/context/" + testName + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Convierto mi archivo en salida y en xml
            jaxbMarshaller.marshal(object, file);
            timer.Timers.endTimer();
            object.setTiempoFinal(timer.Timers.getTimer());
            ContextManager.putObject();
            //jaxbMarshaller.marshal(object, System.out);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void leerXml(String testName) {
        try {
            File file = new File("src/main/java/context/" + testName + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
            Objects obj = (Objects) jaxbMarshaller.unmarshal(file);
            object = obj;
            timer.Timers.startTimer();
            object.setTiempoInicio(String.valueOf(timer.Timers.start / 100));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void generarXml() {
        Usuario usuario = new Usuario("cmotest1@cmo.com", "CMOTEST1");
		Objects obj = new Objects(usuario,"TipoPrueba","Prioridad", "Referencia", "Asignado",
				"TiempoInicio", "TiempoFinal", "Estado", "Sprint", "version", "nombrePrueba");

        try {
            File file = new File("src/main/java/context/Objects.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Objects.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Convierto mi archivo en salida y en xml
            jaxbMarshaller.marshal(obj, file);
            jaxbMarshaller.marshal(obj, System.out);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
