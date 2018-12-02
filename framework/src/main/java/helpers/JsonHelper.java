package helpers;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import context.Objects;
import context.Usuario;
import log.Log;

public class JsonHelper {

	public static Objects object;
	public static ObjectMapper mapper;

	public static void generarJson() {
		try {
			Usuario usuario = new Usuario("Prueba", "LALALALA2");
			Objects obj = new Objects(usuario,"TipoPrueba","Prioridad", "Referencia", "Asignado",
					"TiempoInicio", "TiempoFinal", "Estado", "Sprint", "version", "nombrePrueba");
			File file = new File("src/main/java/context/Usuario.json");
			mapper = new ObjectMapper();
			mapper.writeValue(file, obj);
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}

	}

	public static void leerJson(String testName) {
		try {
			File file = new File("src/main/java/context/" + testName + ".json");
			mapper = new ObjectMapper();
			Objects tmp = mapper.readValue(file, Objects.class);
			object = tmp;
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}
	}

	public static void guardarJson(String testName) {
		try {
			File file = new File("src/main/java/context/" + testName + ".json");
			mapper = new ObjectMapper();
			mapper.writeValue(file, object);

		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}

	}

}
