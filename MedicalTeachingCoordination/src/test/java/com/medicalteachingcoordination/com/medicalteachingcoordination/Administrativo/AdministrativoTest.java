package com.medicalteachingcoordination.com.medicalteachingcoordination.Administrativo;

import org.junit.jupiter.api.Test;

import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Misc.Contador;

import static org.junit.jupiter.api.Assertions.*;

public class AdministrativoTest {
    @Test
    void testConstructor() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        assertNotNull(obj);
    }

    @Test
    void testGetClave() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        assertEquals(obj.getClave(), "administrativo1");
    }

    @Test
    void testRegistrarAsistencia() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        assertNotNull(obj.registrarAsistencia());
    }
}
