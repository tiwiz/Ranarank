package net.orgiu.ranarank2.utils;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class})
public class StringUtilsTest {

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(TextUtils.class);
    }

    @Test(expected = NullPointerException.class)
    public void nullStringThrowsNullPointerException() throws Exception {
        StringUtils.isValid(null);
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