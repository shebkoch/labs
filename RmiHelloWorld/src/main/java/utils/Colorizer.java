package utils;

public class Colorizer {
    public static String userColor(String name,ANSI ansi){
        return String.format("%s%s%s",ansi.getCode(),name,ANSI.RESET.getCode());
    }
}
