package modelos;

public class Valoracion {
    
    private int id;
    private int puntuacion;
    private String comentario;
    
    public Valoracion(){
    
    }
    
    public int getId(){
        return id;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
}
