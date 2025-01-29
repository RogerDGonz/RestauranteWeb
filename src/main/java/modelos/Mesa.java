package modelos;

public class Mesa {
    
    private int id;
    private int capacidad;

    public Mesa() {
    }

    public Mesa(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
