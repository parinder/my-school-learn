package com.gms.helpers;

public class DataHelper {

    public static String getUpdatedString(String original) {
        if (original.endsWith(" A")) {
            return removeSuffix(original, " A") + " B";
        } else if (original.endsWith(" B")) {
            return removeSuffix(original, " B") + " A";
        } else {
            return original + " A";
        }
    }

    public static String getUpdatedLanguage(String original) {
        if (original.isEmpty()) {
            return "en";
        } else if (original.equals("en")) {
            return "fr";
        } else if (original.equals("fr")) {
            return "en";
        } else {
            return "en";
        }
    }

    public static String removeSuffix(String original, String suffix) {
        if (original != null && original.endsWith(suffix)) {
            return original.split(suffix)[0];
        }
        return original;
    }
}