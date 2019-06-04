package Trenes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import MisClases.Maquinistas;
import MisClases.Trenes;
import MisClases.Viajes;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class FXMLViajesController implements Initializable {
    private ArrayList <Maquinistas> maquinistas = null;
    private ArrayList <Trenes> trenes = null;
    
    
    private ArrayList <Viajes> viajes = null;
    
    @FXML
    private ComboBox<String> cmbMaquinista;
    
    @FXML
    private ComboBox<String> cmbTrenes;
    
    @FXML
    private AnchorPane Pane;

    
    public void setMaquinistas(ArrayList<Maquinistas> maquinistas) {
        this.maquinistas = maquinistas;
        
        if(maquinistas.isEmpty()==true) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("No existen elementos registrados");
            msg.setHeaderText("Por favor, dame algo con que trabajar :( ");
            msg.showAndWait();
            this.Pane.setVisible(false);
        }
        
        // Lista de JavaFX 8
        //https://docs.oracle.com/javase/8/javafx/api/javafx/collections/ObservableList.html
        /*
        respectivamente, esto con el objetivo de proporcionarle a las 
        colecciones el soporte para la notificación de cambios e invalidación 
        como lo hacen las Propiedades JavaFX.
        */
        
        ObservableList <String> nombresGuias = FXCollections
                .observableArrayList();
        
        for (int i = 0; i < maquinistas.size(); i++) {
            Maquinistas temp = maquinistas.get(i);
            nombresGuias.add(temp.getNombre() +" "+temp.getApPaterno());
            cmbMaquinista.setItems(nombresGuias);    
            
        }
    }

    public void setTrenes(ArrayList<Trenes> trenes) {
        this.trenes = trenes;
        if(trenes.isEmpty()==true){
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("No hay Registros");
            msg.setHeaderText("Por favor cree nuevos registros de recorridos"
                    + "\n o abra un archivo");
            msg.showAndWait();
            this.Pane.setVisible(false);
        }
        ObservableList <String> nombresRecorridos = FXCollections.observableArrayList();
        for (int i  = 0; i < trenes.size(); i++) {
            Trenes temp = trenes.get(i);
            nombresRecorridos.add(temp.getModelo());
            cmbTrenes.setItems(nombresRecorridos);
        }
        
    }

    public void setViajes(ArrayList<Viajes> viajes) {
        this.viajes = viajes;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    @FXML
    private void aceptar(){
        try {
            String guia = cmbMaquinista.getValue();
            String recorrido = cmbTrenes.getValue();
            
            Viajes temp = new Viajes(guia, recorrido);
            this.viajes.add(temp);

            cmbMaquinista.getSelectionModel().clearSelection();
            cmbTrenes.getSelectionModel().clearSelection();
            
            
            
            Alert msgC = new Alert(Alert.AlertType.INFORMATION);
            msgC.setTitle("VIAJE REGISTRADO");
            msgC.setHeaderText("Se registró el viaje correctamente");
            msgC.show();
            
            try {
                
                FileWriter fw = new FileWriter("Viaje" + 
                        temp.getNombreMaquinista() + "_" + 
                        temp.getModeloTren() +  ".txt");
                
                PrintWriter escritor = new PrintWriter(fw);
                    escritor.println("*****VIAJE*****");
                    escritor.println("Maquinista: " +  temp
                            .getNombreMaquinista());
                    
                    escritor.println("Locomotora: " +
                            temp.getModeloTren());
                    escritor.println();
                    escritor.close();
            } catch (IOException e) {
                Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("¡ERROR DE ESCRITURA!");
                msgE.setHeaderText("No se pudo guardar el archivo, revise"
                        + "sus datos.");
                msgE.show();
            }
            
            
            
        } catch (Exception e) {
            Alert msgE = new Alert(Alert.AlertType.ERROR);
                msgE.setTitle("ERROR");
                msgE.setHeaderText("No se pudo producir la orden");
                msgE.show();
        }
    }
    
    @FXML
    private void cancelar(){
        this.Pane.setVisible(false);
    }
}
