package context;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invitaciones {

	protected String nroSocio;
	protected String especialidad;
	protected String detalleConsulta;
	protected String nroCaso;

	public String getNroSocio() {
		return nroSocio;
	}

	@XmlElement
	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	@XmlElement
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDetalleConsulta() {
		return detalleConsulta;
	}

	@XmlElement
	public void setDetalleConsulta(String detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	public String getNroCaso() {
		return nroCaso;
	}

	@XmlElement
	public void setNroCaso(String nroCaso) {
		this.nroCaso = nroCaso;
	}

}
