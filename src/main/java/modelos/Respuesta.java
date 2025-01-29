package modelos;

public class Respuesta {
    
    private int id;
    private String respuesta;
    
    public Respuesta(){
    
    }
    
    public int getId(){
        return id;
    }
    
    public String getRespuesta(){
        return respuesta;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setRespuesta(String respuesta){
        this.respuesta=respuesta;
    }
}
