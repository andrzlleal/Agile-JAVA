package lesson10;

import org.junit.Test;

import static org.junit.Assert.*;

public class WrapperVsPrimitiveTest {
    @Test
    public void testEqualityComparison() {
        float primitiveFloat = 1.0F;
        float anotherPrimitiveFloat = 1.0F;

        assertEquals(primitiveFloat, anotherPrimitiveFloat, 0.0);

        Float wrapperFloat = 1.0F;
        Float anotherWrapperFloat = 1.0F;

        assertEquals(wrapperFloat, anotherWrapperFloat, 0.0);
    }
    @Test
    public void testNullAssignment() {
        //float primitiveFloat = null; Esta linha resultaria em um erro

        Float wrapperFloat = null;

        assertNull(wrapperFloat);
    }
    @Test
    public void testAdditionalMethods() {
        //float primitiveFloat = 1.0f;  Nenhum método adicional para primitivo

        Float wrapperFloat = 1.0F;

        assertFalse(wrapperFloat.isNaN());
    }
    @Test
    public void testAutoboxingUnboxing() {
        float primitiveFloat = 1.0F;
        Float wrapperFloat = primitiveFloat;

        assertEquals(primitiveFloat, wrapperFloat, 0.0);

        Float anotherWrapperFloat = 2.0f;
        Float anotherPrimitiveFloat = anotherWrapperFloat;

        assertEquals(anotherPrimitiveFloat, anotherWrapperFloat, 0.0);
    }

}
