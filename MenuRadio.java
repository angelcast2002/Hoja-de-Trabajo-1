import java.util.Scanner;

public class MenuRadio {
    Acciones act = new Acciones();
    Scanner scan = new Scanner(System.in);
    //Contructor de clase
    public void menu() {
        boolean salir = false;
        while (salir != true) {
            show("Bienvenido usuario. ¿Que quieres hacer?\n");
            show("1. Encender la radio");
            show("2. Cambiar de AM a FM");
            show("3. Avanzar en el dial de las emisoras");
            show("4. Guardar una emisora");
            show("5. Seleccionar emisora guardada");
            show("6. Apagar la radio");
            show("7. Terminar la ejecución de programa. ");
            show("->");

            int ans = scan.nextInt();
            switch (ans) {
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
                    boolean frec;
                    if (scan.nextInt() == 2) {
                        frec = false; // FM
                    } else {
                        frec = true; // AM
                    }
                    show(act.cambiarSenal(frec));
                    break;

                case 3: // Sube a la siguiente emisora.
                    act.subirEmisora();
                    show("La emisora actual es:");
                    show("" + act.getEmisoraActual());

                    break;

                case 4: // Guarda la emisora actual
                    show("La emisora actual es: " + act.getEmisoraActual());
                    show("Se guardará con tus emisoras favoritas.");
                    show("Ingresa el botón, entre 1 y 12, en el que quieras guardar tu emisora.");
                    act.guardarEmisoraActual(scan.nextInt());
                    break;

                case 5: // selecciona la emisora guardada.
                    show("Selecciona el botón para establecer una de tus emisoras favoritas. ");
                    act.seleccionarEmisoraGuardad(scan.nextInt());
                    show("La emisora actual es : " + act.getEmisoraActual());
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

    public void show(String string) { // sustituye System.out.println("something");
        System.out.println(string);
    }

}
