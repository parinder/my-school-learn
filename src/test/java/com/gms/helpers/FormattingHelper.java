package com.gms.helpers;

public class FormattingHelper {
    public static String deDerpifyJson(String badJson) {
        String betterJson = badJson.replaceAll("^\"+|\"+$", "");
        return betterJson.replace("\\", "");
    }
}