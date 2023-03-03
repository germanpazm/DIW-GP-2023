package quizzbaseOneToMany.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
	private String nombre;

	@OneToMany(mappedBy="usuario",
	cascade=CascadeType.ALL,
	orphanRemoval = true)
	
    private Set<Clasificacion> clasificaciones = new HashSet<>();
	private int victorias;
	private String nombrepiloto;
	private String circuito;
	private int podios;
	private String pais;
	private int anio;
	private String mundial;
	
	public Usuario(String nombre,int victorias, String nombrepiloto, String circuito, int podios, String pais, int anio, String mundial) {
		super();
		this.nombre=nombre;
		this.victorias = victorias;
		this.nombrepiloto = nombrepiloto;
		this.circuito = circuito;
		this.podios = podios;
		this.pais = pais;
		this.anio = anio;
		this.mundial = mundial;
	}
	
	public Usuario asignar(Usuario usuario,List<String>messages) {
		for (int i=0;i<messages.size();i++ ) {
			switch(i) {
			case 0:
				usuario.setNombre(messages.get(i));
				break;
			
			case 1:
				usuario.setVictorias(Integer.parseInt(messages.get(i)));
				System.out.println("a"+Integer.parseInt(messages.get(i)));
				break;
			
			case 2:
				usuario.setNombrepiloto(messages.get(i));
				break;
			
			case 3:
				usuario.setCircuito(messages.get(i));
				break;
				
			case 4:
				usuario.setPodios(Integer.parseInt(messages.get(i)));
				break;
				
			case 5:
				usuario.setPais(messages.get(i));
				break;
			
			case 6:
				usuario.setAnio(Integer.parseInt(messages.get(i)));
				break;
				
			case 7:
				usuario.setMundial(messages.get(i));
				break;
			
			
			default:
				break;
			
			
		}
		}
		return usuario;
		
	}

	public Usuario() {
		
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrepiloto() {
		return nombrepiloto;
	}

	public void setNombrepiloto(String nombrepiloto) {
		this.nombrepiloto = nombrepiloto;
	}

	public String getCircuito() {
		return circuito;
	}
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	public int getPodios() {
		return podios;
	}
	public void setPodios(int podios) {
		this.podios = podios;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getMundial() {
		return mundial;
	}
	public void setMundial(String mundial) {
		this.mundial = mundial;
	}

	public Set<Clasificacion> getClasificaciones() {
		return clasificaciones;
	}

	public void setClasificaciones(Set<Clasificacion> clasificaciones) {
		this.clasificaciones = clasificaciones;
	}
	public void anadirClasificaciones(Clasificacion clasificacion) {
		if(null== clasificaciones) {
			clasificaciones = new HashSet<>();
		}
		clasificaciones.add(clasificacion);
		clasificacion.setUsuario(this);
	}

	
	public void eliminarClasificaciones(Clasificacion clasificacion) {
		clasificaciones.remove(clasificacion);
		clasificacion.setUsuario(null);
	}
	

}