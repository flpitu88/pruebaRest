/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Pasajero;

/**
 *
 * @author flavio
 */
public interface PasajeroDAO {
    
    public void guardarPasajero(Pasajero p);
    
    public Pasajero getPasajeroById(int id);
    
    public List<Pasajero> getTodosLosPasajeros();
    
    public List<Pasajero> getAmigos(int id);
    
    public List<Integer> getIdsAmigos(int id);
    
//    public List<Recomendacion> getRecomendacionesDeUsuario(Pasajero p);
    
}
