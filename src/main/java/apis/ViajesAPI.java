/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis;

import java.util.List;
import model.Viaje;

/**
 *
 * @author Flavio L. Pietrolati
 */
public interface ViajesAPI {
    
    public List<Viaje> getViajesDePasajero(int id);
    
    public void guardarViaje(Viaje v);
    
}
