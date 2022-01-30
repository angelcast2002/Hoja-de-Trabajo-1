import java.util.ArrayList;

public class Acciones implements Radio {

    public Acciones() {
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");
        EmisorasGuardadas.add("am, 106.5");

    }

    private boolean Estado = false;
    // determina el estado de la radio, true o false

    private boolean TipoSenal = false;
    // determina si es am (true) o fm (false)

    private float AmActual;
    private float FmActual;
    private float Mensajef;

    public float getMensajef() {
        return this.Mensajef;
    }

    public void setMensajef(float Mensajef) {
        this.Mensajef = Mensajef;
    }

    private ArrayList<String> EmisorasGuardadas = new ArrayList<String>();
    private String[] DentroDelBotton;

    public String[] getDentroDelBotton() {
        return this.DentroDelBotton;
    }

    public void setDentroDelBotton(String[] DentroDelBotton) {
        this.DentroDelBotton = DentroDelBotton;
    }

    private boolean Mensajeb;
    private String Mensaje;

    private String ContenidoBotton;

    public String getContenidoBotton() {
        return this.ContenidoBotton;
    }

    public void setContenidoBotton(String ContenidoBotton) {
        this.ContenidoBotton = ContenidoBotton;
    }

    public String getMensaje() {
        return this.Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    private String EmisoraAguardar;

    public String getEmisoraAguardar() {
        return this.EmisoraAguardar;
    }

    public void setEmisoraAguardar(String EmisoraAguardar) {
        this.EmisoraAguardar = EmisoraAguardar;
    }

    public boolean isMensajeb() {
        return this.Mensajeb;
    }

    public void setMensajeb(boolean Mensajeb) {
        this.Mensajeb = Mensajeb;
    }

    public boolean isEstado() {
        return this.Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public boolean isTipoSenal() {
        return this.TipoSenal;
    }

    public void setTipoSenal(boolean TipoSenal) {
        this.TipoSenal = TipoSenal;
    }

    public float getAmActual() {
        return this.AmActual;
    }

    public void setAmActual(float AmActual) {
        this.AmActual = AmActual;
    }

    public float getFmActual() {
        return this.FmActual;
    }

    public void setFmActual(float FmActual) {
        this.FmActual = FmActual;
    }

    public ArrayList<String> getEmisorasGuardadas() {
        return this.EmisorasGuardadas;
    }

    public void setEmisorasGuardadas(ArrayList<String> EmisorasGuardadas) {
        this.EmisorasGuardadas = EmisorasGuardadas;
    }

    // comprueba el estado de la radio y lo cambia
    public void encenderApagar() {

        if (Estado == false) {

            Estado = true;

        } else {

            Estado = false;

        }

    }

    // comprueba si la radio se encuentra encendida o apagada para mostrar el valor
    // correspondiente
    public boolean comprobarEncendido() {

        if (Estado == false) {

            Mensajeb = true;

        } else {

            Mensajeb = false;

        }

        return Mensajeb;
    }

    // Guarda la emisora sintonizada en el boton que el usuario elija, tambien
    // comprueba que el numero del boton este en el rango permitido
    public String guardarEmisoraActual(int numBoton) {

        if (0 < numBoton && numBoton < 13) {

            if (TipoSenal == false) {

                EmisorasGuardadas.set(numBoton, (String.valueOf(TipoSenal) + "," + Float.toString(FmActual)));
                Mensaje = "Se ha guardado exitosamente la emisora " + FmActual + " en el boton " + numBoton;

            } else {

                EmisorasGuardadas.set(numBoton, (String.valueOf(TipoSenal) + "," + Float.toString(AmActual)));
                Mensaje = "Se ha guardado exitosamente la emisora " + AmActual + " en el boton " + numBoton;

            }

        } else {

            Mensaje = "Numero fuera de rango, elija uno entre 1 y 12";

        }

        return Mensaje;
    }

    // Selecciona un boton de los antes guardados, tambien revisa que el numero del
    // boton seleccionado este en el rango
    public String seleccionarEmisoraGuardad(int numBoton) {

        if (0 < numBoton && numBoton < 13) {

            ContenidoBotton = getEmisorasGuardadas().get(numBoton);
            DentroDelBotton = ContenidoBotton.split(",");
            TipoSenal = Boolean.valueOf(DentroDelBotton[0]);

            if (TipoSenal == false) {

                FmActual = Float.valueOf(DentroDelBotton[1]);
                Mensaje = "Escuchando la emisora " + TipoSenal + FmActual + " del boton " + numBoton;

            } else {

                AmActual = Float.valueOf(DentroDelBotton[1]);
                Mensaje = "Escuchando la emisora " + TipoSenal + AmActual + " del boton " + numBoton;
            }

        } else {

            Mensaje = "Numero fuera de rango, elija uno entre 1 y 12";

        }

        return Mensaje;
    }

    // Cambia la senal de am a fm
    public String cambiarSenal(boolean opcion) {

        TipoSenal = opcion;

        if (TipoSenal == false) {

            Mensaje = "Se ha cambiado exitosamente la emisora a FM";

        } else {

            Mensaje = "Se ha cambiado exitosamente la emisora a AM";

        }

        return Mensaje;
    }

    // Obtiene el tipo de senal que se esta sintonizando
    public boolean getTipoSenal() {

        Mensajeb = TipoSenal;
        return Mensajeb;

    }

    // Cambia la emisora, comprueba el tipo de senal y asi hace el cambio
    public void subirEmisora() {

        if (TipoSenal == false) {

            FmActual = (float) (FmActual + 0.2);

            if (FmActual <= 107.9) {

            } else {

                FmActual = (float) (87.9);

            }

        } else {

            AmActual = (float) (AmActual + 10);

            if (AmActual <= 1610) {

            } else {

                AmActual = (float) (530);

            }

        }
    }

    // Cambia la emisora, comprueba el tipo de senal y asi hace el cambio
    public void bajarEmisora() {

        if (TipoSenal == false) {

            FmActual = (float) (FmActual - 0.2);

            if (FmActual >= 87.9) {

            } else {

                FmActual = (float) (107.9);

            }

        } else {

            AmActual = (float) (AmActual - 10);

            if (AmActual >= 530) {

            } else {

                AmActual = (float) (1610);

            }

        }
    }

    // Muestra la emisora actual
    public float getEmisoraActual() {

        if (TipoSenal == false) {

            Mensajef = FmActual;

        } else {

            Mensajef = AmActual;

        }

        return Mensajef;

    }

}
