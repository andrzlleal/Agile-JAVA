import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SuperClassTest {
    @Test
    public void testConstructorCalls() {
        SuperClass superClass = new SubClass("parm");
        assertTrue(SuperClass.constructorWasCalled);
    }

}
