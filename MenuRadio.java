import java.util.ArrayList;
import java.util.Scanner;

public class MenuRadio {
    Acciones act = new Acciones();
    public void menu(){
        show("Bienvenido usuario. ¿Que quieres hacer?\n");
        show("1. Encender la radio");
        show("2. Cambiar de AM a FM");
        show("3. Avanzar en el dial de las emisoras");
        show("4. Guardar una emisora");
        show("5. Seleccionar emisora guardada");
        show("6. Apagar la radio");
        show("->");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            
            case 1: // Enciende la radio y devuleve un mensaje que indica el estado de la radio.
                act.encenderApagar();
                act.comprobarEncendido();
                if (act.comprobarEncendido() == true) {
                    show("La radio está encendida");
                } else {
                    show("La radio no está encendida");
                }

                break;
            
            case 2:
                show("Introduce:");
                show("1. para AM");
                show("2. para FM");
                Scanner scan = new Scanner(System.in);
                boolean frec;
                if (scan.nextInt()== 2) {
                    frec = false; // FM
                } else{
                    frec = true; // AM
                }
                show(act.cambiarSenal(frec));
                break;
        
            case 3:
                act.subirEmisora();
                show("La emisora actual es:");
                show(act.getEmisoraAguardar());

                break;

            case 4:
                





        }




    }
    
    public void show(String string){
        System.out.println(string);
    }



}
