package fes.aragon.verdugo.inicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unam.fes.aragon.dinamicas.cola.Cola;

import java.io.IOException;

public class Verdugo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Verdugo.class.getResource("/fes/aragon/verdugo/view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VERDUGO");
        stage.setScene(scene);
        stage.show();
    }

    public String matar(int k, int n, int amigo){
        int posicionInicio=1;
        int posicionesRecorridas=0;
        boolean amigoSalvado= false;
        Cola<Integer> prisioneros = new Cola<>();

        for(int i=1; i<=n; i++){
            prisioneros.insertar(i);
        }

        int cantidadMaxima = n;
        prisioneros.extraer();
        cantidadMaxima-=1;

        while(cantidadMaxima!=1){
            posicionesRecorridas=0;
            while(posicionesRecorridas<=k){
                prisioneros.insertar(prisioneros.extraer());
                posicionesRecorridas+=1;
            }
            int eliminado = prisioneros.extraer();
            if(eliminado == amigo){
                break;
            }
            cantidadMaxima-=1;
        }
        if(cantidadMaxima == 1 && prisioneros.elementoSuperior() == amigo){
            return Integer.toString(posicionInicio);
        }else{
            while(!amigoSalvado){
                posicionInicio+=1;
                cantidadMaxima = n;

                prisioneros.borrar();
                for(int i=1; i<=n; i++){
                    prisioneros.insertar(i);
                }

                posicionesRecorridas=0;
                while(posicionesRecorridas<posicionInicio-1){
                    prisioneros.insertar(prisioneros.extraer());
                    posicionesRecorridas+=1;
                }
                prisioneros.extraer();
                cantidadMaxima-=1;

                while(cantidadMaxima!=1){
                    posicionesRecorridas=1;
                    while(posicionesRecorridas<k){
                        prisioneros.insertar(prisioneros.extraer());
                        posicionesRecorridas+=1;
                    }
                    int eliminado = prisioneros.extraer();
                    if(eliminado == amigo){
                        break;
                    }
                    cantidadMaxima-=1;
                }

                if(cantidadMaxima==1 && prisioneros.elementoSuperior()==amigo){
                    amigoSalvado= true;
                    return Integer.toString(posicionInicio);
                }
            }
        }
        return "No hay posición";
    }
}
