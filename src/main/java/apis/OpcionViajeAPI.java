/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apis;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import java.util.List;
import model.OpcionDeViaje;

/**
 *
 * @author flavio
 */
public interface OpcionViajeAPI {

    // agregar excepciones --> refactor
    public List<OpcionDeViaje> findOpcionesDeViaje(
            String aeroOrigen,
            String aeroDestino,
            DateTime fechaIda,
            DateTime fechaVuelta);
}
