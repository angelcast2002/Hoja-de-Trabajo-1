import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class JUnitTest {
    @Test
    public void testComprobarEncendido(){
        Acciones act = new Acciones();
        assertEquals(true, act.comprobarEncendido() );
    }

    @Test
    public void testSeleccionarEmisorasGuardadas(){
        Acciones act = new Acciones();
        assertEquals("am, 106.5", act.getEmisorasGuardadas().get(0));
    }



}
