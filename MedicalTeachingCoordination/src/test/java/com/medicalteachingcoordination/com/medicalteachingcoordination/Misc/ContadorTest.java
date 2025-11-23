package com.medicalteachingcoordination.com.medicalteachingcoordination.Misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.medicalteachingcoordination.Misc.Contador;

public class ContadorTest {
    @Test
    void testConstructor() {
        Contador obj = new Contador();
        assertNotNull(obj);
    }

    @Test
    void testIncrementarContador() {
        Contador obj = new Contador();
        assertEquals(obj.getContador(), 1);
        obj.incrementarContador();
        assertEquals(obj.getContador(), 2);
    }
}
