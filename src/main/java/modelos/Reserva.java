package modelos;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
    
    private int id;
    private Date fecha;
    private Time hora;

    public Reserva() {
    }

    public Reserva(int id, Date fecha, Time hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public Time getHora(){
        return hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setHora(Time hora){
        this.hora = hora;
    }
    
}
