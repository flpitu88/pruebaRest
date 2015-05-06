
package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pasajero {
    
        private static int contadorId = 0;
	
        @JsonProperty("nombre")
	private String nombre;
	
        @JsonProperty("apellido")
	private String apellido;
	
        @JsonProperty("dni")
	private long dni;
        
        @JsonProperty("id")
        private int idUser;
	
        @JsonProperty("amigos")
	private List<Pasajero> amigos;        
	
	public Pasajero(String nombre, String apellido, long dni,
	    List<Pasajero> amigos) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.amigos = amigos;
                this.idUser = contadorId++;
	}
	
	public Pasajero() {
                this.idUser = contadorId++;
	}

        public int getIdUser() {
                return idUser;
        }

        public void setIdUser(int idUser) {
                this.idUser = idUser;
        }

	public String getNombre() {
	
		return nombre;
	}
	
	public void setNombre(String nombre) {
	
		this.nombre = nombre;
	}
	
	public String getApellido() {
	
		return apellido;
	}
	
	public void setApellido(String apellido) {
	
		this.apellido = apellido;
	}
	
	public long getDni() {
	
		return dni;
	}
	
	public void setDni(long dni) {
	
		this.dni = dni;
	}
	
	public List<Pasajero> getAmigos() {
	
		return amigos;
	}
	
	public void setAmigos(List<Pasajero> amigos) {
	
		this.amigos = amigos;
	}
	
	public boolean esAmigo(Pasajero pj) {
	
		boolean resul = false;
		for (Pasajero p : getAmigos()) {
			if (p.equals(pj)) {
				resul = true;
			}
		}
		return resul;
	}

}
