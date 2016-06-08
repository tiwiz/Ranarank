package net.orgiu.ranarank2.utils;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void nullStringThrowsNullPointerException() throws Exception {
        assertFalse(StringUtils.isValid(null));
    }

    @Test
    public void emptyStringReturnsFalse() throws Exception {
        assertFalse(StringUtils.isValid(""));
    }

    @Test
    public void shortStringReturnsFalse() throws Exception {
        assertFalse(StringUtils.isValid("abc"));
    }

    @Test
    public void longStringReturnsTrue() throws Exception {
        assertTrue(StringUtils.isValid("abcd"));
    }
}