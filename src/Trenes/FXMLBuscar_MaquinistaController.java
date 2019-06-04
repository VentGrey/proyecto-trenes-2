package Trenes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import MisClases.Maquinistas;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class FXMLBuscar_MaquinistaController implements Initializable {

    ArrayList<Maquinistas> maquinistas = null;
    ArrayList<Maquinistas> tmp = new ArrayList<Maquinistas>();
    int count = 0;
    
    @FXML
    private TextField txtBuscar;
    
    @FXML
    private Label lblNombre;
    
    @FXML
    private Label lblApPaterno;
    
    @FXML
    private Label lblCedula;
    
    @FXML
    private Label lblEspecialidad;
    
    @FXML
    private Label lblAntiguedad;
    
    @FXML
    private Label lblIndice;
    
    @FXML
    private Button btnInicio;
    
    @FXML
    private Button btnAtras;
    
    @FXML
    private Button btnAdelante;
    
    @FXML
    private Button btnUltimo;
    
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        limpiar();

    }

    public void setMaquinistas(ArrayList<Maquinistas> maquinistas) {
        this.maquinistas = maquinistas;
        if(maquinistas.isEmpty()==true){
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("¡ERROR!");
            msg.setHeaderText("No se han encontrado maquinistas registrados. "
                    + "registre uno o salga de aquí :) ");
            msg.showAndWait();
            this.pane.setVisible(false);
        }

        txtBuscar.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char car = event.getCharacter().charAt(0);

                if (!Character.isLetter(car)) {
                    event.consume();
                }
            }
        });

    }

    @FXML
    private void Buscar() {
        try {
            limpiar();
            String Buscar = txtBuscar.getText();
            for (int i = 0; i < maquinistas.size(); i++) {
                String comparar = maquinistas.get(i).getNombre();
                if (Buscar.equals(comparar)) {
                    String nom = maquinistas.get(i).getNombre();
                    String apPa = maquinistas.get(i).getApPaterno();
                    int ced = maquinistas.get(i).getCedula();
                    String esp = maquinistas.get(i).getApMaterno();
                    int ant = maquinistas.get(i).getAntiguedad();

                    Maquinistas Busqueda = new Maquinistas(nom, apPa, ced, esp, ant);
                    tmp.add(Busqueda);
                }
            }
            
            for (int j = 0; j < tmp.size(); j++) {
                lblNombre.setText(tmp.get(j).getNombre());
                lblApPaterno.setText(tmp.get(j).getApPaterno());
                lblCedula.setText(String.valueOf(tmp.get(j).getCedula()));
                lblEspecialidad.setText(tmp.get(j).getApMaterno());
                lblAntiguedad.setText(String.valueOf(tmp.get(j).getAntiguedad()));
                lblIndice.setText((count + 1) + "/" + tmp.size());
            }
            if(tmp.size() == 0){                
                Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("No hay Registro");
            msg.setHeaderText("No existe el Registro");
            msg.showAndWait();
            }

        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Error");
            msg.setHeaderText("Error en la aplicación");
            msg.setContentText(ex.getMessage());
            msg.show();
        }

    }

    @FXML
    private void moverRegistro(ActionEvent event) {
        try {
            Maquinistas temp;
            if (event.getSource() == btnInicio) {
                count = 0;
                temp = tmp.get(count);
                this.lblNombre.setText(temp.getNombre());
                this.lblApPaterno.setText(temp.getApPaterno());
                this.lblCedula.setText(String.valueOf(temp.getCedula()));
                this.lblEspecialidad.setText(temp.getApMaterno());
                this.lblAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
                this.lblIndice.setText((count + 1) + "/" + tmp.size());
            }
            if (event.getSource() == btnAtras) {
                if ((count - 1) >= 0) {
                    count--;

                    temp = tmp.get(count);
                    this.lblNombre.setText(temp.getNombre());
                    this.lblApPaterno.setText(temp.getApPaterno());
                    this.lblCedula.setText(String.valueOf(temp.getCedula()));
                    this.lblEspecialidad.setText(temp.getApMaterno());
                    this.lblAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
                    this.lblIndice.setText((count + 1) + "/" + tmp.size());
                }
            }
            if (event.getSource() == btnAdelante) {
                if ((count + 1) < tmp.size()) {
                    count++;

                    temp = tmp.get(count);
                    this.lblNombre.setText(temp.getNombre());
                    this.lblApPaterno.setText(temp.getApPaterno());
                    this.lblCedula.setText(String.valueOf(temp.getCedula()));
                    this.lblEspecialidad.setText(temp.getApMaterno());
                    this.lblAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
                    this.lblIndice.setText((count + 1) + "/" + tmp.size());
                }
            }
            if (event.getSource() == btnUltimo) {
                count = tmp.size() - 1;
                temp = tmp.get(count);
                this.lblNombre.setText(temp.getNombre());
                this.lblApPaterno.setText(temp.getApPaterno());
                this.lblCedula.setText(String.valueOf(temp.getCedula()));
                this.lblEspecialidad.setText(temp.getApMaterno());
                this.lblAntiguedad.setText(String.valueOf(temp.getAntiguedad()));
                this.lblIndice.setText((count + 1) + "/" + tmp.size());
            }

        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Error");
            msg.setHeaderText("Error en la aplicación");
            msg.setContentText(ex.getMessage());
            msg.show();
        }
    }

    public void limpiar() {
        lblNombre.setText("");
        lblApPaterno.setText("");
        lblCedula.setText("");
        lblEspecialidad.setText("");
        lblAntiguedad.setText("");
        lblIndice.setText("0/0");
        tmp.clear();

    }
}
