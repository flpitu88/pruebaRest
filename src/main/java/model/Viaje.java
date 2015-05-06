package model;

import java.util.Date;
import java.util.List;

public class Viaje {

    private Pasajero viajante;
    private List<Trayecto> itinerario;
    private int idViaje;

    public Viaje() {
    }

    public Viaje(Pasajero viajante, List<Trayecto> itinerario) {
        this.viajante = viajante;
        this.itinerario = itinerario;
    }

    public Pasajero getViajante() {
        return viajante;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setViajante(Pasajero viajante) {
        this.viajante = viajante;
    }

    public List<Trayecto> getItinerario() {
        return itinerario;
    }

    public void setItinerario(List<Trayecto> itinerario) {
        this.itinerario = itinerario;
    }

    public Date getFechaSalidaViaje() {
        return getItinerario()
                .get(0).getFechaSalida();
    }

    public Date getFechaArriboViaje() {
        return getItinerario()
                .get(itinerario.size() - 1).getFechaArribo();
    }

    public void agregarTrayecto(Trayecto tray) {
        getItinerario().add(tray);
    }

}
