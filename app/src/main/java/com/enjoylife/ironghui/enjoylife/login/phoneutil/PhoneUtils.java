package com.enjoylife.ironghui.enjoylife.login.phoneutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PhoneUtils {
    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
//        String regExp = "^((13[0-9])|(15[^4])|(166)|(17[0-8])|(18[0-9])|(19[8-9])|(147,145))\\d{8}$";
        Pattern regExp = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = regExp.matcher(str);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
}
