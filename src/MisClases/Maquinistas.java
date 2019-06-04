package MisClases;

/**
 *
 * @author Omar
 */
public class Maquinistas {
    private String Nombre;
    private String ApPaterno;
    private int Cedula;
    private String ApMaterno;
    private int Antiguedad;
    

    public Maquinistas() {
    }
    
    public Maquinistas(String Nombre, String ApPaterno, int Cedula, 
            String ApMaterno, int Antiguedad) {
        this.Nombre = Nombre;
        this.ApPaterno = ApPaterno;
        this.Cedula = Cedula;
        this.ApMaterno = ApMaterno;
        this.Antiguedad = Antiguedad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String ApPaterno) {
        this.ApPaterno = ApPaterno;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String ApMaterno) {
        this.ApMaterno = ApMaterno;
    }

    public int getAntiguedad() {
        return Antiguedad;
    }

    public void setAntiguedad(int Antiguedad) {
        this.Antiguedad = Antiguedad;
    }

    // NO TE PASES DE LA COLUMNA 80
    @Override
    public String toString() {
        return "\n" + "Maquinista-> " + "Nombre: " + Nombre + "\nApPaterno: "
                + ApPaterno + "\nCedula: " + Cedula + "\nEspecialidad: " + 
                ApMaterno + "\nAntiguedad: " + Antiguedad;
    }

    
    
}
