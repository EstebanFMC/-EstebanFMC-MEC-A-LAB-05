
public class Edad {
private Double edad;
private int repeticiones;

    public Edad(Double edad, int repeticiones) {
        this.edad = edad;
        this.repeticiones = repeticiones;
    }

    
    public Double getEdad() {
        return edad;
    }
    
    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString(){
    return ("La edad: "+ edad + " se repite " + repeticiones+ " veces.");
    }


}
