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
import org.springframework.beans.factory.annotation.Autowired;
import repository.PasajeroDAO;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Service
public class PasajerosService implements PasajerosAPI {

    @Autowired
    private PasajeroDAO psjDao;
    
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

}
