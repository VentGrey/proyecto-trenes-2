/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trenes;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import MisClases.Trenes;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class FXMLBuscar_TrenesController implements Initializable {

    ArrayList<Trenes> trenes = null;
    ArrayList<Trenes> Modelotmp = new ArrayList<Trenes>();
    ArrayList<Trenes> IDtmp = new ArrayList<Trenes>();
    int pointer = 0;

    @FXML
    private AnchorPane Pane;
    
    @FXML
    private Label lblIndice;
    
    @FXML
    private Button btnInicio;
    
    @FXML
    private Button btnAtras;
    
    @FXML
    private Button btnFin;
    
    @FXML
    private Button btnAdelante;
    
    @FXML
    private Label lblModelo;
    
    @FXML
    private Label lblPotencia;
    
    @FXML
    private Label lblVagones;
    
    @FXML
    private Label lblCiudad;
    
    @FXML
    private Label lblID;
    
    @FXML
    private TextField txtModelo;
    
    @FXML
    private TextField txtID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        limpiar();
    }

    public void setTrenes(ArrayList<Trenes> trenes) {
        this.trenes = trenes;
        
        if(trenes.isEmpty() == true){
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("No se ha registrado ninguna locomotora");
            msg.setHeaderText("Por favor registre al menos una locomotora"
                    + "\n o en su defecto salga de aquí :)");
            msg.showAndWait();
            this.Pane.setVisible(false);
        }

        txtModelo.setOnKeyTyped(new EventHandler<KeyEvent>() {
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
    }

    @FXML
    private void buscar_tren() {
        try {
            
            limpiar();
            txtID.setText("");
            String Buscar = txtModelo.getText();
            
            for (int i = 0; i < trenes.size(); i++) {
                
                if (Buscar.equals(trenes.get(i).getModelo())) {
                    
                    String nom = trenes.get(i).getModelo();
                    int max = trenes.get(i).getPotencia();
                    int min = trenes.get(i).getVagones();
                    String ori = trenes.get(i).getCiudad();
                    String dest = trenes.get(i).getID();
                    Trenes Busqueda = new Trenes(nom, max, min, ori, dest);
                    Modelotmp.add(Busqueda);
                }
            }
            
            for (int j = 0; j < Modelotmp.size(); j++) {
                
                lblModelo.setText(Modelotmp.get(j).getModelo());
                
                lblPotencia.setText(String.valueOf(Modelotmp.get(j)
                        .getPotencia()));
                
                lblVagones.setText(String.valueOf(Modelotmp.get(j)
                        .getVagones()));
                
                lblCiudad.setText(Modelotmp.get(j)
                        .getCiudad());
                
                lblID.setText(Modelotmp.get(j).getID());
                this.lblIndice.setText((pointer + 1) + "/" + Modelotmp.size());

            }
            if (Modelotmp.isEmpty()) {
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("¡ERROR!");
                msg.setHeaderText("No se encontró ningún tren con ese nombre");
                msg.show();
            }

            // Catch fusilado
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("¡ERROR!");
            msg.setHeaderText("ERROR NO SE QUE PASÓ");
            msg.setContentText(ex.getMessage());
            msg.show();
        }
    }

    @FXML
    private void buscar_Origen() {
        try {
            limpiar();
            txtModelo.setText("");
            String Buscar = txtID.getText();
            for (int i = 0; i < trenes.size(); i++) {
                if (Buscar.equals(trenes.get(i).getCiudad())) {
                    String modelo = trenes.get(i).getModelo();
                    int potencia = trenes.get(i).getPotencia();
                    int vagones = trenes.get(i).getVagones();
                    String ciudad = trenes.get(i).getCiudad();
                    String id = trenes.get(i).getID();
                    Trenes Busqueda = new Trenes(modelo, potencia, vagones, 
                            ciudad, id);
                    
                    IDtmp.add(Busqueda);
                }
            }
            for (int j = 0; j < IDtmp.size(); j++) {
                lblModelo.setText(IDtmp.get(j).getModelo());
                lblPotencia.setText(String.valueOf(IDtmp.get(j).getPotencia()));
                lblVagones.setText(String.valueOf(IDtmp.get(j).getVagones()));
                lblCiudad.setText(IDtmp.get(j).getCiudad());
                lblID.setText(IDtmp.get(j).getID());
                this.lblIndice.setText((pointer + 1) + "/" + IDtmp.size());

            }
            if (IDtmp.isEmpty()) {
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("Error");
                msg.setHeaderText("No existe el registo");
                msg.show();
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
    private void cancelar() {
        this.Pane.setVisible(false);
    }

    private void limpiar() {
        lblModelo.setText("");
        lblPotencia.setText("");
        lblVagones.setText("");
        lblCiudad.setText("");
        lblID.setText("");
        lblIndice.setText("0/0");
        Modelotmp.clear();
        IDtmp.clear();

    }

}
