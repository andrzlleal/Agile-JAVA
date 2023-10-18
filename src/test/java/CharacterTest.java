import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void testWhitespace() {
        char newLineChar = '\n';
        char spaceChar = ' ';
        char tabChar = '\t';

        assertTrue(Character.isWhitespace(newLineChar));
        assertTrue(Character.isWhitespace(spaceChar));
        assertTrue(Character.isWhitespace(tabChar));

        char letterChar = 'A';
        char numberChar = '5';
        char specialChar = '!';

        assertFalse(Character.isWhitespace(letterChar));
        assertFalse(Character.isWhitespace(numberChar));
        assertFalse(Character.isWhitespace(specialChar));

        char ideographicSpaceChar = '\u3000';
        assertTrue(Character.isWhitespace(ideographicSpaceChar));
    }

    @Test
    public void testIdentifierCharacters() {
        char validStartChar1 = 'a';
        char validStartChar2 = 'A';
        char validStartChar3 = '_';
        char validStartChar4 = '$';

        assertTrue(Character.isJavaIdentifierPart(validStartChar1));
        assertTrue(Character.isJavaIdentifierStart(validStartChar2));
        assertTrue(Character.isJavaIdentifierStart(validStartChar3));
        assertTrue(Character.isJavaIdentifierStart(validStartChar4));

    }
}