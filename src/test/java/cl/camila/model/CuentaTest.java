package cl.camila.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuentaTest {

    private static Logger logger = Logger.getLogger("cl.camila.model");
    private static Cuenta cuenta= new Cuenta("Camila", 100000);
    private static Cuenta cuentaMock = mock(Cuenta.class);
    private static final float saldoInicial = 10.0f;
    private static final float saldoAgregado = 5.0f;
    private static final float saldoAgregadoNegativo = -5.0f;

    @BeforeEach
    void setUp(){
        logger.info("Iniciando tests");
    }

    @Test
    @DisplayName("Testeando nombre de la cuenta")
    void testNombrecuenta(){
        String nombreEsperado = "Camila";
        String real = cuenta.getUsuario();
        assertEquals(nombreEsperado,real, "el nombre obtenido no es el esperado");
        assertTrue(real.equals("Camila"));
    }

    @Test
    @DisplayName("testeando suma con mockito")
    public void testSetearSaldo() {

        logger.info("Ejecutando test saldo agregado en cuenta");
        when(cuentaMock.agregarSaldo(saldoInicial,saldoAgregado)).thenReturn((float) 15);
        float respuesta = cuentaMock.agregarSaldo(saldoInicial, saldoAgregado);
        assertEquals(15.0f, respuesta);
    }

    @Test
    @DisplayName("testeando suma de numeros negaativos con mockito")
    public void testSetearSaldoNegativo() {

        logger.info("Ejecutando test saldo negativo en cuenta");
        when(cuentaMock.agregarSaldo(saldoInicial,saldoAgregadoNegativo)).thenReturn((float) 0);
        float respuesta = cuentaMock.agregarSaldo(saldoInicial, saldoAgregadoNegativo);
        assertEquals(0f, respuesta);
    }

}