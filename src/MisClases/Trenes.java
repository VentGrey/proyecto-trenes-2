package MisClases;

/**
 *
 * @author Omar
 */
public class Trenes {
    private String Modelo;
    private int Potencia;
    private int Vagones;
    private String Ciudad;
    private String ID;

    public Trenes() {
    }

    
    public Trenes(String Modelo, int Potencia, int Vagones, String Ciudad, 
            String ID) {
        this.Modelo = Modelo;
        this.Potencia = Potencia;
        this.Vagones = Vagones;
        this.Ciudad = Ciudad;
        this.ID = ID;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getPotencia() {
        return Potencia;
    }

    public void setPotencia(int Potencia) {
        this.Potencia = Potencia;
    }

    public int getVagones() {
        return Vagones;
    }

    public void setVagones(int Vagones) {
        this.Vagones = Vagones;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Trenes->" + "\nModelo de locomotora: " + Modelo
                + "\nPotencia: " + Potencia + " HP." + "\nNúmero de vagones: " 
                + Vagones + "\nCiudad de asignación: " + Ciudad 
                + "\nID: " + ID;
    }
}
