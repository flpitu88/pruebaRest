/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.Pasajero;
import org.springframework.stereotype.Service;
import apis.PasajerosAPI;
import apis.ViajesAPI;
import model.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PasajeroDAO;
import repository.ViajesDAO;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Service
public class PersistenciaService implements PasajerosAPI, ViajesAPI {

    @Autowired
    private PasajeroDAO psjDao;
    
    @Autowired
    private ViajesDAO viajeDao;

    public PersistenciaService() {
    }
    
    @Override
    public List<Pasajero> getListado() {
        return psjDao.getTodosLosPasajeros();
    }

    @Override
    public void crearPasajero(Pasajero p) {
        psjDao.guardarPasajero(p);
    }

    @Override
    public List<Pasajero> getAmigosDePasajero(int idPsj) {
        return psjDao.getAmigos(idPsj);
    }

    @Override
    public List<Viaje> getViajesDePasajero(int id) {
        return viajeDao.getViajesDePasajero(id);
    }

    @Override
    public void guardarViaje(Viaje v) {
        viajeDao.guardarViaje(v);
    }

    @Override
    public Pasajero getPasajeroPorId(int id) {
        return psjDao.getPasajeroById(id);
    }

}
