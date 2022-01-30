public interface Radio {

    public void encenderApagar(); // cambia el estado de encenidido/apagado

    public boolean comprobarEncendido(); // comprueba que la radio este encendido

    public String guardarEmisoraActual(int numBoton); // guarda la emisora como favorita en el boton indicado

    public String seleccionarEmisoraGuardad(int numBoton); // Reproduce la emisora guardada en uno de los 12 botones.

    public String cambiarSenal(boolean opcion); // true: AM false:FM

    public boolean getTipoSenal(); // true: AM // false:FM

    public void subirEmisora();

    public void bajarEmisora();

    public float getEmisoraActual();

}
