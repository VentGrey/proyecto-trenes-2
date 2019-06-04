package Trenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Omar
 */

/*
BORRAR ANTES DE ENTREGAR

TODO:
- Estilar el proyecto como material
- Agregar imágenes
- Subirlo a GitHub
- Borrar los comentarios antes de entregar

https://docs.oracle.com/javafx/2/
y explicarle al prof de dónde rayos saqué algunas funciones para
que no se enoje conmigo por huevón y no ir a clase.
*/
public class ProyectoFinal_Trenes extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSistema.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
