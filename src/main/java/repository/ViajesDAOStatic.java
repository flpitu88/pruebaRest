/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Pasajero;
import model.Viaje;
import org.springframework.stereotype.Repository;

/**
 *
 * @author flavio
 */
@Repository
public class ViajesDAOStatic implements ViajesDAO {

    private List<Viaje> listaViajes;

    public List<Viaje> getListaViajes() {
        return listaViajes;
    }

    @Override
    public void guardarViaje(Viaje v) {
        getListaViajes().add(v);
    }

    @Override
    public Viaje buscarViajePorId(int id) {
        Viaje buscado = null;
        for (Viaje v : getListaViajes()) {
            if (v.getIdViaje() == id) {
                buscado = v;
            }
        }
        return buscado;
    }

    @Override
    public List<Viaje> getViajesDeUsuario(Pasajero p) {
        List<Viaje> lista = null;
        for (Viaje v : getListaViajes()) {
            if (v.getViajante() == p) {
                lista.add(v);
            }
        }
        return lista;
    }

}
