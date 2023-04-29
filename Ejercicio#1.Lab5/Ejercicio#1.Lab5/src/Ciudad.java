public class Ciudad {
    private String nombre;
    private int contagios;

    public Ciudad(String nombre, int contagios) {
        this.nombre = nombre;
        this.contagios = contagios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContagios() {
        return contagios;
    }

    public void setContagios(int contagios) {
        this.contagios = contagios;
    }
    
    
    @Override
    public String toString(){
        return "La ciudad es: " + nombre + ". Y tuvo " + contagios + " contagios.";
    }

    
    
    
    
}

