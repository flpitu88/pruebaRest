/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Recomendacion;

/**
 *
 * @author Flavio L. Pietrolati
 */
public interface RecomendacionesDAO {
    
    public List<Recomendacion> getRecomendacionesPorId(List<Integer> recomendaciones);
    
    public Recomendacion getRecomendacionPorId(Integer id);
    
}
