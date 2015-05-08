/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Recomendacion;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Repository
public class RecomendacionesDAOStatic implements RecomendacionesDAO {

    private final List<Recomendacion> listaRecomendaciones;

    public RecomendacionesDAOStatic() {
        listaRecomendaciones = new ArrayList<>();
        listaRecomendaciones.add((Recomendacion) Arrays.asList(
                new Recomendacion(1, "Buenos Aires", "Roma")));
    }

    public List<Recomendacion> getListaRecomendaciones() {
        return listaRecomendaciones;
    }

    @Override
    public List<Recomendacion> getRecomendacionesPorId(List<Integer> recomendaciones) {
        List<Recomendacion> recomend = new ArrayList<>();
        for (Integer rec : recomendaciones){
            for (Recomendacion recom : getListaRecomendaciones()){
                if (recom.getIdRecomendacion() == rec){
                    recomend.add(recom);
                }
            }
        }
        return recomend;
    }

}
