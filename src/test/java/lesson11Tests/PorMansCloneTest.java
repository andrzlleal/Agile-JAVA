package lesson11Tests;

import lesson11.PoorMansClone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PorMansCloneTest {
    @Test
    public void testCloneObject() {
        //Cria um objeto MyClass original 
        PoorMansClone.MyClass original = new PoorMansClone.MyClass(42, "Hello");
        
        //Clona o objeto original 
        PoorMansClone.MyClass cloned = PoorMansClone.cloneObject(original);
        
        //Verifica se o objeto clonado não é o mesmo que o original 
        assertNotSame(original, cloned);
        
        //Verifica se os campos do objeto clonado são iguais aos do original 
        assertEquals(original.toString(), cloned != null ? cloned.toString() : null);
    }
}
