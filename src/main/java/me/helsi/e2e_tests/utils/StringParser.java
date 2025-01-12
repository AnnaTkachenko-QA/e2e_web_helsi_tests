package me.helsi.e2e_tests.utils;

public class StringParser {

    public static Integer parseIntegerFromString(String targetText) {
        String digitText = targetText.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public static Double parseDoubleFromString(String targetText) {
        String doubleText = targetText.replaceAll("[^\\d.]", "");
        return Double.parseDouble(doubleText);
    }

}
