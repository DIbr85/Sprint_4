package org.example.Data;

public class RandomData {
    private static final int numberOfLimitDayRent = (int) (Math.random() * 6 + 1);
    private static final int nameOfMetroStation = (int) (Math.random() * 224 + 1);
    private static final int colorOfScooter = (int) (Math.random() * 2 + 1);

    public static int getNumberOfLimitDayRent() {
        return numberOfLimitDayRent;
    }

    public static int getNameOfMetroStation() {
        return nameOfMetroStation;
    }

    public static int getColorOfScooter() {
        return colorOfScooter;
    }

}