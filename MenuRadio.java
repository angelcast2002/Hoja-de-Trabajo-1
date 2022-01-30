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
        
        boolean salir = false;
        while (salir == false) {
            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()) {
                
                case 1: // Enciende la radio y devuleve un mensaje que indica el estado de la radio.
                    act.encenderApagar();
                    act.comprobarEncendido();
                    if (act.comprobarEncendido() == true) {
                        show("La radio está encendida");
                    } else {
                        show("La radio no está encendida");
                    }
                    
                    break;
                
                case 2: // Selecciona AM o FM
                    show("Introduce:");
                    show("1. para AM");
                    show("2. para FM");
                    Scanner scan1 = new Scanner(System.in);
                    boolean frec;
                    if (scan1.nextInt()== 2) {
                        frec = false; // FM
                    } else{
                        frec = true; // AM
                    }
                    show(act.cambiarSenal(frec));
                    scan1.close();
                    break;
            
                case 3: //Sube a la siguiente emisora. 
                    act.subirEmisora();
                    show("La emisora actual es:");
                    show(act.getEmisoraAguardar());

                    break;

                case 4: //Guarda la emisora actual
                    show("La emisora actual es: " + act.getEmisoraActual());
                    show("Se guardará con tus emisoras favoritas.");
                    show("Ingresa el botón, entre 1 y 12, en el que quieras guardar tu emisora.");
                    Scanner scan2 = new Scanner(System.in);
                    act.guardarEmisoraActual(scan2.nextInt());
                    scan2.close();

                    break;

                case 5: // selecciona la emisora guardada. 
                    show("Selecciona el botón para establecer una de tus emisoras favoritas. ");
                    Scanner scan3 = new Scanner(System.in);
                    act.seleccionarEmisoraGuardad(scan3.nextInt());
                    scan3.close();
                    break;

                case 6: // apaga la radio
                    show("Apagando la radio");
                    act.encenderApagar();
                    break;

                case 7: // Sale del ciclo. 
                salir = true;

            }
        }
    }
    
    public void show(String string){ // sustituye System.out.println("something");
        System.out.println(string);
    }



}
