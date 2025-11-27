package com.medicalteachingcoordination.Administrativo;

import org.junit.jupiter.api.Test;
import com.medicalteachingcoordination.Misc.GenerarCodigo;
import com.medicalteachingcoordination.Misc.Contador;
import static org.junit.jupiter.api.Assertions.*;

public class AdministrativoTest {
    @Test
    void testConstructor() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, new GenerarCodigo(contador).generarCodigo("administrativo"));
        assertNotNull(obj);
        assertEquals(2, contador.getContador());
    }

    @Test
    void testGetClave() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, new GenerarCodigo(contador).generarCodigo("administrativo"));
        assertEquals(obj.getClave(), "administrativo1");
    }

    @Test
    void testRegistrarAsistencia() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, new GenerarCodigo(contador).generarCodigo("administrativo"));
        assertNotNull(obj.registrarAsistencia("Administrativo presente"));
    }
}
