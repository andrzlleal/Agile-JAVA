import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterTest {
    @Test
    public void testWhitespace() {
        //Tester o character de nova linha
        assertTrue(Character.isWhitespace('\n'));

        //Tester o character de tabulação
        assertTrue(Character.isWhitespace('\t'));

        //Tester o character de espaço
        assertTrue(Character.isWhitespace(' '));

        //Standout outros carcasses; eles devem retornar false
        assertFalse(Character.isWhitespace('A'));

        assertFalse(Character.isWhitespace('1'));

        assertFalse(Character.isWhitespace('#'));

        /* encontrando outro caractere que retorne true */
        assertTrue(Character.isWhitespace('\u0020'));
    }
    @Test
    public void testValidIdentifierStart() {
        ///Teste para verificar se um caractere é um válido inicio de identificação Java
        assertTrue(Character.isJavaIdentifierStart('a'));
        assertTrue(Character.isJavaIdentifierStart('$'));

        assertFalse(Character.isJavaIdentifierStart('1'));
        assertFalse(Character.isJavaIdentifierStart('^'));
    }
    @Test
    public void testValidIdentifierPart() {
        ///Teste para verificar se um caractere é uma parte válida de um identificador Java
        assertTrue(Character.isJavaIdentifierPart('a'));
        assertTrue(Character.isJavaIdentifierPart('_'));

        assertFalse(Character.isJavaIdentifierPart('^'));
    }
}
