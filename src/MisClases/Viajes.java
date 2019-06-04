package MisClases;

/**
 *
 * @author Omar
 */
public class Viajes {
    
    private String NombreMaquinista;
    private String ModeloTren;

    public Viajes() {
    }

    public Viajes(String NombreMaquinista, String ModeloTren) {
        this.NombreMaquinista = NombreMaquinista;
        this.ModeloTren = ModeloTren;
    }
    
    public String getNombreMaquinista() {
        return NombreMaquinista;
    }

    public void setNombreMaquinista(String NombreMaquinista) {
        this.NombreMaquinista = NombreMaquinista;
    }

    public String getModeloTren() {
        return ModeloTren;
    }

    public void setModeloTren(String ModeloTren) {
        this.ModeloTren = ModeloTren;
    }
        
    @Override
    public String toString() {
        return "---Viajes---" + "\nNombre del maquinista: " + NombreMaquinista + "\nTren asignado: " + ModeloTren;
    }
}
