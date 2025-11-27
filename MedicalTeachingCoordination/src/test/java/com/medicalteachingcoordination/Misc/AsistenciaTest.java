package com.medicalteachingcoordination.Misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import com.medicalteachingcoordination.Administrativo.Administrativo;

public class AsistenciaTest {
    @Test
    void testConstructor() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena,
                new GenerarCodigo(contador).generarCodigo("administrativo"));
        Asistencia obj = new Asistencia(administrativo, "Administrativo presente");
        assertNotNull(obj);
    }

    @Test
    void testGetUsuario() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena,
                new GenerarCodigo(contador).generarCodigo("administrativo"));
        Asistencia obj = new Asistencia(administrativo, "Administrativo presente");
        assertEquals(obj.getUsuario(), administrativo);
    }

    @Test
    void testGetFecha() {
        char[] contrasena = { '1', '2' };
        Contador contador = new Contador();
        Administrativo administrativo = new Administrativo("Jose Lopes Lopes", "Jose", contrasena,
                new GenerarCodigo(contador).generarCodigo("administrativo"));
        Asistencia obj = new Asistencia(administrativo, "Administrativo presente");
        assertEquals(obj.getFecha(), LocalDate.now());
    }
}
