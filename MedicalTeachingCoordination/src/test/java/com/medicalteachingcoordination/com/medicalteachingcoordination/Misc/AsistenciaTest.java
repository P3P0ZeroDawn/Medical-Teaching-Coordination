package com.medicalteachingcoordination.com.medicalteachingcoordination.Misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Misc.Asistencia;
import com.medicalteachingcoordination.Misc.Contador;

public class AsistenciaTest {
    @Test
    void testConstructor() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        Asistencia obj = new Asistencia(administrativo);
        assertNotNull(obj);
    }

    @Test
    void testGetUsuario() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        Asistencia obj = new Asistencia(administrativo);
        assertEquals(obj.getUsuario(), administrativo);
    }

    @Test
    void testGetFecha() {
        char[] contrasena = { '1', '2' };
        Contador cont = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, cont);
        Asistencia obj = new Asistencia(administrativo);
        assertEquals(obj.getFecha(), LocalDate.now());
    }
}
