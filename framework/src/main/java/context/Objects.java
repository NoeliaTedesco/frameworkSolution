package context;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Objects {
	
	private Usuario usuario;
	private String tipoDePrueba;
	private String prioridad;
	private String referencia;
	private String asignado;
	private String tiempoInicio;
	private String tiempoFinal;
	private String estado;
	private String sprint;
	private String version;
	private HashMap<String, String> pasos = new HashMap<>();
	private String nombreDePrueba;
	
	
	public Objects() {
	}
	
    public Objects(Usuario usuario, String tipoDePrueba, String prioridad, String referencia, String asignado,
			String tiempoInicio, String tiempoFinal, String estado, String sprint, String version, String nombreDePrueba) {
		super();
		this.usuario = usuario;
		this.tipoDePrueba = tipoDePrueba;
		this.prioridad = prioridad;
		this.referencia = referencia;
		this.asignado = asignado;
		this.tiempoInicio = tiempoInicio;
		this.tiempoFinal = tiempoFinal;
		this.estado = estado;
		this.sprint = sprint;
		this.version = version;
		this.nombreDePrueba = nombreDePrueba;
	}

	public String getNombreDePrueba() {
		return nombreDePrueba;
	}
	@XmlElement
	public void setNombreDePrueba(String nombreDePrueba) {
		this.nombreDePrueba = nombreDePrueba;
	}

	public String getTipoDePrueba() {
		return tipoDePrueba;
	}

	@XmlElement
	public void setTipoDePrueba(String tipoDePrueba) {
		this.tipoDePrueba = tipoDePrueba;
	}

	public String getPrioridad() {
		return prioridad;
	}

	@XmlElement
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getReferencia() {
		return referencia;
	}

	@XmlElement
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getAsignado() {
		return asignado;
	}

	@XmlElement
	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}

	public String getTiempoInicio() {
		return tiempoInicio;
	}

	@XmlElement
	public void setTiempoInicio(String tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public String getTiempoFinal() {
		return tiempoFinal;
	}

	@XmlElement
	public void setTiempoFinal(String tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}

	public String getEstado() {
		return estado;
	}

	@XmlElement
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSprint() {
		return sprint;
	}

	@XmlElement
	public void setSprint(String sprint) {
		this.sprint = sprint;
	}

	public String getVersion() {
		return version;
	}

	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}

	public HashMap<String, String> getPasos() {
		return pasos;
	}

	@XmlElement
	public void setPasos(HashMap<String, String> pasos) {
		this.pasos = pasos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	@XmlElement
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
