/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Pasajero;
import org.springframework.stereotype.Repository;

/**
 *
 * @author flavio
 */
@Repository
public class PasajeroDAOStatic implements PasajeroDAO {

    private final List<Pasajero> listaPasajeros;

    public PasajeroDAOStatic() {
        Pasajero pasajero1 = new Pasajero("pasajero1", "apellido1", 111111, new ArrayList());
        Pasajero pasajero2 = new Pasajero("pasajero2", "apellido2", 222222, new ArrayList());
        Pasajero pasajero3 = new Pasajero("pasajero3", "apellido3", 333333, new ArrayList());
        Pasajero pasajero4 = new Pasajero("pasajero4", "apellido4", 444444, new ArrayList());
        Pasajero pasajero5 = new Pasajero("pasajero5", "apellido5", 555555, new ArrayList());
        Pasajero pasajero6 = new Pasajero("pasajero6", "apellido6", 666666, new ArrayList());
        Pasajero pasajero7 = new Pasajero("pasajero7", "apellido7", 777777, new ArrayList());

        pasajero1.agregarAmigo(pasajero3);
        pasajero1.setRecomendaciones(Arrays.asList(1));
        pasajero1.agregarAmigo(pasajero5);
        pasajero2.agregarAmigosPorPasajeros(Arrays.asList(pasajero4, pasajero6, pasajero7));

        listaPasajeros = Arrays.asList(pasajero1, pasajero2, pasajero3, pasajero4,
                pasajero5, pasajero6, pasajero7);
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    @Override
    public void guardarPasajero(Pasajero p) {
        getListaPasajeros().add(p);
    }

    @Override
    public Pasajero getPasajeroById(int id) {
        Pasajero buscado = null;
        for (Pasajero p : getListaPasajeros()) {
            if (p.getIdUser() == id) {
                buscado = p;
            }
        }
        return buscado;
    }

    @Override
    public List<Pasajero> getTodosLosPasajeros() {
        return getListaPasajeros();
    }

    @Override
    public List<Pasajero> getAmigos(int id) {
        List<Pasajero> amigos = new ArrayList();
        for (Pasajero psj : getListaPasajeros()) {
            if (psj.getIdUser() == id) {
                for (Integer idPas : psj.getAmigos()) {
                    amigos.add(getPasajeroById(idPas));
                }
                return amigos;
            }
        }
        return null;
    }

    @Override
    public List<Integer> getIdsAmigos(int id) {
        for (Pasajero psj : getListaPasajeros()) {
            if (psj.getIdUser() == id) {
                return psj.getAmigos();
            }
        }
        return null;
    }

    @Override
    public List<Integer> getRecomendacionesDeUsuario(int pas) {
         for (Pasajero psj : getListaPasajeros()) {
            if (psj.getIdUser() == pas) {
                return psj.getRecomendaciones();
            }
        }
        return null;
    }

}
