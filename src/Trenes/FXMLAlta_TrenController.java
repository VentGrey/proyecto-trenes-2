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
import MisClases.Trenes;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class FXMLAlta_TrenController implements Initializable {

    ArrayList<Trenes> trenes = null; // Lista vacía
    private FXMLSistemaController father;

    @FXML
    private TextField txtModelo;
    
    @FXML
    private TextField txtPotencia;
    
    @FXML
    private TextField txtVagones;
    
    @FXML
    private TextField txtCiudad;
    
    @FXML
    private TextField txtID;
    
    @FXML
    private Button btnAceptar;
    
    @FXML
    private Pane Border;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setTrenes(ArrayList<Trenes> trenes) {
        this.trenes = trenes;

        txtModelo.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isLetter(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtCiudad.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isLetter(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtID.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isLetter(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtPotencia.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isDigit(tmp)) {
                    event.consume();
                }
            }
        });
        
        txtVagones.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char tmp = event.getCharacter().charAt(0);

                if (!Character.isDigit(tmp)) {
                    event.consume();
                }
            }
        });
    }

    public void setFather(FXMLSistemaController father) {
        this.father = father;
    }

    @FXML
    private void agregar_tren() {
        try {
            
            boolean validar = false;

            do {                
                String modelo = txtModelo.getText();
                int potencia = Integer.valueOf(txtPotencia.getText());
                int vagones = Integer.valueOf(txtVagones.getText());
                String ciudad = txtCiudad.getText();
                String ID = txtID.getText();
                
                if (modelo != null && potencia != 0) { // terminar validaciones
                    validar = true;
                    Trenes temporal = new Trenes(modelo, potencia, vagones, ciudad, ID);
                    this.trenes.add(temporal);

                    txtModelo.setText("");
                    txtPotencia.setText("");
                    txtVagones.setText("");
                    txtCiudad.setText("");
                    txtID.setText("");

                    Alert msgC = new Alert(Alert.AlertType.INFORMATION);
                    msgC.setTitle("¡ÉXITO!");
                    msgC.setHeaderText("Se registró una locomotora");
                    msgC.showAndWait();
                    
                    // Gracias Guadian :V
                } else {
                    validar = false;
                    Alert msgE = new Alert(Alert.AlertType.ERROR);
                    msgE.setTitle("¡ERROR!");
                    msgE.setHeaderText("Hay un valor incorrecto en los datos "
                            + "ingresados, revíselos.");
                    txtPotencia.setText("");
                    txtVagones.setText("");
                    msgE.showAndWait();
                }
                
            } while (validar == false);
            
        } catch (Exception ex) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
            msgE.setTitle("¡ERROR!");
            msgE.setHeaderText("Ocurrió un error al agregar una locomotora.");
            msgE.show();
        }
    }

    @FXML
    private void cerrar_ventana() {
        this.Border.setVisible(false);
    }

}
