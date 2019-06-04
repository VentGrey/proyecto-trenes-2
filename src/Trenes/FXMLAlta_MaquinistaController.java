package Trenes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import MisClases.Maquinistas;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class FXMLAlta_MaquinistaController implements Initializable {

    private ArrayList<Maquinistas> maquinistas = null;
    private FXMLSistemaController padre;
    
    @FXML
    private Button btnAceptar;
   
    @FXML
    private TextField txtApPaterno;
    
    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtCedula;
    
    @FXML
    private TextField txtApMaterno;
    
    @FXML
    private TextField txtAntiguedad;
    
    @FXML
    private Pane Border;
    
    @FXML
    private Button btnCancelar;

    public void setPadre(FXMLSistemaController padre) {
        this.padre = padre;
    }

    // AQUÍ TERMINAN LOS "ESTILOS" DEL XML
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    // La neta no se que hace esto lejos del handle, créditos a StackOverflow y
    // a Smith por explicarme cómo demonios hacer esto.
    public void setMaquinistas(ArrayList<Maquinistas> maquinistas) {
        this.maquinistas = maquinistas;
        txtNombre.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtApPaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtApMaterno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isLetter(key)) {
                    event.consume();
                }
            }
        });
        
        txtCedula.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char key = event.getCharacter().charAt(0);

                if (!Character.isDigit(key)) {
                    event.consume();
                }
                
                    
            }
        });
        txtAntiguedad.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);

                if (!Character.isDigit(car)) {
                    event.consume();
                }
            }
        });
    }

    public ArrayList<Maquinistas> getMaquinistas() {
        return maquinistas;
    }

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    @FXML
    private void alta_maquinistas() {
        
        try {
            
            for (int i = 0; i < maquinistas.size(); i++) {
                
                        int get = maquinistas.get(i).getCedula();
                        
                        if (get == Integer.valueOf(txtCedula.getText())) {
                            
                            txtCedula.setText("");
                             Alert msgE = new Alert(Alert.AlertType.ERROR);
                             
                             msgE.setTitle("Error al registrar la cédula");
                             
                             msgE.setHeaderText("El numero de cedula no está "
                                     + "disponible."
                                     + "\nIntente con otro");
                             
                             msgE.show();                        
                        }
                    }
            // Con el método substring le vamos a mochar cualquier cosa
            // que pase de los 15 carácteres y así nos ahorramos validar
            // pues el nombre SIEMPRE será válido bwaaahahahaha
            String nombre = txtNombre.getText().substring(0,15);   
            String apPaterno = txtApPaterno.getText().substring(0, 15);
            
            int cedula = Integer.valueOf(txtCedula.getText());
            String apMaterno = txtApMaterno.getText().substring(0, 15);
            int antiguedad = Integer.valueOf(txtAntiguedad.getText());

            Maquinistas temporal = new Maquinistas(nombre, apPaterno, cedula, apMaterno, antiguedad);
            this.maquinistas.add(temporal);

            txtNombre.setText("");
            txtApPaterno.setText("");
            txtCedula.setText("");
            txtApMaterno.setText("");
            txtAntiguedad.setText("");

            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("¡Exito!");
            msgC.setHeaderText("Se agregó un maquinista al registro actual");
            msgC.show();

        } catch (Exception ex) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("Ocurrió un error al agregar un maquinista "
                    + "revise sus datos e inténtelo de nuevo.");
            msgE.show();
        }
    }

    @FXML
    private void cerrar_ventana() {
        this.Border.setVisible(false);
    }
}
