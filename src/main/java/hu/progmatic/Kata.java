package hu.progmatic;

import java.util.Locale;

public class Kata {
  public static String name = "codewa.rs";

  public static String abbrevName(String name) {
    String[] names = name.split(" ");
    return names[0].substring(0,1).toUpperCase() + "." + names[0].substring(0,1).toUpperCase();
  }

  public static int stringToNumber(String str) {
    return Integer.parseInt(str);
  }

  public static String correct(String string) {
    string = string.replace('1','I');
    string = string.replace('5','S');
    string = string.replace('0','O');
    return string;
  }
}
