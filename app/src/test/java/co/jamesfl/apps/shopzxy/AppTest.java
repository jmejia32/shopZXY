package co.jamesfl.apps.shopzxy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class AppTest {

    @Test
    public void mujerZapatillasNike2() {
        assertEquals(200000, Metodos.calcularTotal(1, 0, 0, 2));
    }

    @Test
    public void mujerZapatillasAdidasIncorrecto() {
        assertNotEquals(150000, Metodos.calcularTotal(1, 0, 1, 1));
    }

    @Test
    public void mujerClasicosPuma3Incorrecto() {
        assertNotEquals(350000, Metodos.calcularTotal(1, 1, 2, 3));
    }

    @Test
    public void hombreClasicosAdidas2() {
        assertEquals(160000, Metodos.calcularTotal(0, 1, 1, 2));
    }

    @Test
    public void hombreZapatillasPuma3Incorrecto() {
        assertNotEquals(400000, Metodos.calcularTotal(0, 0, 2, 3));
    }

    @Test
    public void hombreZapatillasNike() {
        assertEquals(120000, Metodos.calcularTotal(0, 0, 0, 1));
    }
}
