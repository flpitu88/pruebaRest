/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Pasajero;
import org.springframework.stereotype.Service;
import apis.PasajerosAPI;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Service
public class PasajerosService implements PasajerosAPI {

    @Override
    public List<Pasajero> getListado() {
        return new ArrayList<>(Arrays.asList(
                new Pasajero("pasajero1", "apellido1", 111111, null),
                new Pasajero("pasajero2", "apellido2", 222222, null),
                new Pasajero("pasajero3", "apellido3", 333333, null),
                new Pasajero("pasajero4", "apellido4", 444444, null),
                new Pasajero("pasajero5", "apellido5", 555555, null),
                new Pasajero("pasajero6", "apellido6", 666666, null),
                new Pasajero("pasajero7", "apellido7", 777777, null)
        ));
    }

}
