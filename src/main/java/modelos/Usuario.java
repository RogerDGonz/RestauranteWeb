package modelos;

public class Usuario {
    
    private String email; 
    private String nombre; 
    private String contrasena; 
    private boolean tipoUsuario;
    
    public Usuario( ) {
    
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }
    
}
