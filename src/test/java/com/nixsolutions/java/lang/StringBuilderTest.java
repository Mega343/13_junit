package com.nixsolutions.java.lang;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class StringBuilderTest {

    private StringBuilder sb;
    private static final char[] TEST_ARRAY = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static final CharSequence TEST_CHAR_SEQUENCE = "0123456789";

    @Before
    public void setUp() throws Exception {
        sb = new StringBuilder("test");
    }

    @Test
    public void shouldReturnStringRepresentationOfThisSequence() throws Exception {
        //given
        String expectedResult = "test";

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void objectChangesShouldNotChangeString() throws Exception {
        //given
        String actualResult = sb.toString();

        //when
        sb.append("smt");

        //then
        assertNotEquals(sb.toString(), actualResult);
    }

    @Test
    public void shouldAppendStringRepresentationOfBoolean() throws Exception {
        //given
        boolean b = false;
        String expectedResult = "testfalse";

        //when
        sb.append(b);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendStringRepresentationOfCharacterArray() throws Exception {
        //given
        String expectedResult = "testabcdef";

        //when
        sb.append(TEST_ARRAY);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendStringRepresentationOfSubarrayCharacters() throws Exception {
        //given
        int offset = 2;
        int len = 3;
        String expectedResult = "testcde";

        //when
        sb.append(TEST_ARRAY, offset, len);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfIndexOfFirstElementLessThanZero() throws Exception {
        //given
        int offset = -1;
        int len = 3;

        //when
        sb.append(TEST_ARRAY, offset, len);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfNumberOfCharsToAppendLessThanZero() throws Exception {
        //given
        int offset = 0;
        int len = -1;

        //when
        sb.append(TEST_ARRAY, offset, len);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfNumberOfCharsToAppendMoreThanArrayLength() throws Exception {
        //given
        int offset = 0;
        int len = 7;

        //when
        assertTrue(len > TEST_ARRAY.length);
        sb.append(TEST_ARRAY, offset, len);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfParametersOffsetPlusLenGreaterThanArrayLength() throws Exception {
        //given
        int offset = 3;
        int len = 4;

        //when
        sb.append(TEST_ARRAY, offset, len);
    }

    @Test
    public void shouldAppendCharacterSequence() throws Exception {
        //given
        String expectedResult = "test0123456789";

        //when
        sb.append(TEST_CHAR_SEQUENCE);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void ifCharacterSequenceIsNullThenShouldAppendWordNull() throws Exception {
        //given
        CharSequence s = null;
        String expectedResult = "testnull";

        //when
        sb.append(s);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendSubsequenceOfCharSequence() throws Exception {
        //given
        int start = 2;
        int end = 5;
        String expectedResult = "test234";

        //when
        sb.append(TEST_CHAR_SEQUENCE, start, end);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfStartParameterIsNegative() throws Exception {
        //given
        int start = -1;
        int end = 5;

        //when
        sb.append(TEST_CHAR_SEQUENCE, start, end);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfStartParameterIsGreaterThanEnd() throws Exception {
        //given
        int start = 3;
        int end = 2;

        //when
        sb.append(TEST_CHAR_SEQUENCE, start, end);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfEndParameterIsGreaterThanCharSequenceLength() throws Exception {
        //given
        int start = 3;
        int end = 11;

        //when
        assertTrue(end > TEST_CHAR_SEQUENCE.length());
        sb.append(TEST_CHAR_SEQUENCE, start, end);
    }

    @Test
    public void shouldAppendStringRepresentationOfDouble() throws Exception {
        //given
        double d = 2.54;
        String expectedResult = "test2.54";

        //when
        sb.append(d);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendStringRepresentationOfDoubleInExponentialForm() throws Exception {
        //given
        double d = 2.02E13;
        String expectedResult = "test2.02E13";

        //when
        sb.append(d);

        //then
        assertEquals(expectedResult, sb.toString());
    }


    @Test
    public void shouldAppendWordNullIfObjectIsNull() throws Exception {
        //given
        Object o = null;
        String expectedResult = "testnull";

        //when
        sb.append(o);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendStringRepresentationOfObject() throws Exception {
        //given
        Object o = new Boolean(true);
        String expectedResult = "testtrue";

        //when
        sb.append(o);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldAppendStringRepresentationOfCodePoint() throws Exception {
        //given
        int codePoint = 33;
        String expectedResult = "test!";

        //when

        sb.appendCodePoint(codePoint);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void shouldReturnCurrentCapacity() throws Exception {
        assertTrue(sb.capacity() > 0);
    }

    @Test
    public void shouldReturnSurrogateCharacterAtSpecifiedIndex() throws Exception {
        //given
        int index = 4;
        char expectedResult = '\u0012';

        //when
        sb.append(expectedResult);
        char actualResult = sb.charAt(index);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedIndexLessThanZero() throws Exception {
        //given
        int index = -1;

        //when
        sb.charAt(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedIndexEqualsSequenceLength() throws Exception {
        //given
        int index = 4;

        //when
        assertTrue(index == sb.length());
        sb.charAt(index);
    }

    @Test
    public void shouldReturnCodePointOfCharacterAtIndex() throws Exception {
        //given
        int index = 3;
        int expectedCodePoint = 116;

        //when
        assertEquals(expectedCodePoint, sb.codePointAt(index));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedIndexIsNegative() throws Exception {
        //given
        int index = -1;

        //when
        sb.codePointAt(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedIndexGreaterThanSequenceLength() throws Exception {
        //given
        int index = 5;

        //when
        assertTrue(index > sb.length());
        sb.codePointAt(index);
    }

    @Test
    public void shouldRemoveSubstringOfThisSequence() throws Exception {
        //given
        int start = 1; // inclusive
        int end = 3;   // exclusive
        String expectedResult = "tt";

        //then
        assertEquals(expectedResult, sb.delete(start, end).toString());
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedStartGreaterThanSequenceLength() throws Exception {
        //given
        int start = 5;
        int end = 3;

        //when
        assertTrue(start > sb.length());
        sb.delete(start, end);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedStartIsNegative() throws Exception {
        //given
        int start = -1;
        int end = 3;

        //when
        sb.delete(start, end);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfSpecifiedStartIsGreaterThanEnd() throws Exception {
        //given
        int start = 3;
        int end = 2;

        //when
        sb.delete(start, end);
    }

    @Test
    public void shouldDeleteCharAtSpecifiedPosition() throws Exception {
        //given
        int index = 2;
        String expectedResult = "tet";

        //then
        assertEquals(expectedResult, sb.deleteCharAt(index).toString());
    }

    @Test
    public void shouldCopyCharsToArrayInSpecifiedPositions() throws Exception {
        //given
        int srcBegin = 2;
        int srcEnd = 4;
        int dstBegin = 0;
        char[] expectedResult = {'s', 't'};
        char[] dst = new char[2];

        //when
        sb.getChars(srcBegin, srcEnd, dst, dstBegin);

        //than
        assertEquals(Arrays.toString(expectedResult), Arrays.toString(dst));
    }

    @Test
    public void shouldReturnIndexOfFirstOccurrenceOfSpecifiedSubstring() throws Exception {
        //given
        String substring = "es";
        int expectedResult = 1;

        //when
        int actualResult = sb.indexOf(substring);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnMinusOneIfOccurrenceOfSpecifiedSubstringNotFound() throws Exception {
        //given
        String substring = "hf";
        int expectedResult = -1;

        //when
        int actualResult = sb.indexOf(substring);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldInsertStringRepresentationOfBooleanValue() throws Exception {
        //given
        boolean test = true;
        int offset = 2;
        String expectedResult = "tetruest";

        //when
        sb.insert(offset, test);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfOffsetParameterIsInvalid() throws Exception {
        //given
        int offset = -1;
        boolean test = false;

        //when
        sb.insert(offset, test);
    }

    @Test
    public void shouldReturnSequenceLength() throws Exception {
        //given
        int expectedResult = 4;

        //when
        int actualResult = sb.length();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReplaceCharactersInSequenceWithCharactersInSpecifiedString() {
        //given
        int start = 2;
        int end = 4;
        String str = "bz";
        String expectedResult = "tebz";

        //when
        sb.replace(start, end, str);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfStartPositionIsNegative() throws Exception {
        //given
        int start = -1;
        int end = 4;
        String str = "bz";

        //when
        sb.replace(start, end, str);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfStartPositionGreaterThanEnd() throws Exception {
        //given
        int start = 3;
        int end = 2;
        String str = "bz";

        //when
        sb.replace(start, end, str);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfStartPositionGreaterThanSequenceLength() throws Exception {
        //given
        int start = 5;
        int end = 6;
        String str = "bz";

        //when
        assertTrue(start > sb.length());
        sb.replace(start, end, str);
    }

    @Test
    public void shouldReverseSequence() throws Exception {
        //given
        String expectedResult = "tset";

        //when
        sb.reverse();

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test
    public void characterAtSpecifiedIndexShouldSetToInputValue() throws Exception {
        //given
        int index = 2;
        char inputValue = 'z';
        String expectedResult = "tezt";

        //when
        sb.setCharAt(index, inputValue);

        //then
        assertEquals(expectedResult, sb.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfIndexIsNegative() throws Exception {
        //given
        int index = -1;
        char inputValue = 'z';

        //when
        sb.setCharAt(index, inputValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfIndexGreaterThanSequenceLength() throws Exception {
        //given
        int index = 5;
        char inputValue = 'z';

        //when
        assertTrue(index > sb.length());
        sb.setCharAt(index, inputValue);
    }
}