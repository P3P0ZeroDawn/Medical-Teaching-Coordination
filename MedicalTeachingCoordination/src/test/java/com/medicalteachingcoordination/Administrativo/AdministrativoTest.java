package com.medicalteachingcoordination.Administrativo;

import org.junit.jupiter.api.Test;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

import static org.junit.jupiter.api.Assertions.*;

public class AdministrativoTest {
    @Test
    void testConstructor() {
        char[] contrasena = { '1', '2' };
        GenerarCodigo genCodigoAdministrativos = new GenerarCodigo();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, genCodigoAdministrativos);
        assertNotNull(obj);
    }

    @Test
    void testGetClave() {
        char[] contrasena = { '1', '2' };
        GenerarCodigo genCodigoAdministrativos = new GenerarCodigo();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, genCodigoAdministrativos);
        assertEquals(obj.getClave(), "administrativo1");
    }

    @Test
    void testRegistrarAsistencia() {
        char[] contrasena = { '1', '2' };
        GenerarCodigo genCodigoAdministrativos = new GenerarCodigo();
        Administrativo obj = new Administrativo("Jose Lopes Lopes", "Jose", contrasena, genCodigoAdministrativos);
        assertNotNull(obj.registrarAsistencia());
    }
}
