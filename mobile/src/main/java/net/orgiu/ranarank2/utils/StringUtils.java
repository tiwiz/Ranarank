package net.orgiu.ranarank2.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public class StringUtils {

    private static final int NAME_MINIMAL_LENGTH = 3;

    public static boolean isValid(@Nullable CharSequence name) {
        return name != null && name.length() > NAME_MINIMAL_LENGTH;
    }
}
