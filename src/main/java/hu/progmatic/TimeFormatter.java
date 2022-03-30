package hu.progmatic;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
  public static String formatDuration(long seconds) {
    String time = "";
    String time2 = "";
    List<String> list = new ArrayList<>();
    if (seconds < 1) {
      return "now";
    }

    if (seconds < 60) {
      return getSeconds(seconds);
    }

    if (seconds < 3600) {
      list.add(String.valueOf(seconds / 60) + " minute" + convert(seconds / 60));
      time += String.valueOf(seconds / 60) + " minute" + convert(seconds / 60);
      long y = seconds % 60;
      if (seconds % 60 != 0) {
        time += " and ";
        list.add(getSeconds(y));
        time += getSeconds(y);
      }
      return time;
    }

    if (seconds < 86400) {
      list.add(String.valueOf(seconds / 3600) + " hour" + convert(seconds / 3600));
      time += String.valueOf(seconds / 3600) + " hour" + convert(seconds / 3600);
      long y = seconds % 3600;
      if (seconds % 3600 != 0) {
        if (seconds > 3600) {
          time += ", ";
        }
        list.add(String.valueOf(y / 60) + " minute" + convert(y / 60));
        time += String.valueOf(y / 60) + " minute" + convert(y / 60);
      }
      long z = y % 60;
      if (y % 60 != 0) {
        time += " and ";
        list.add(getSeconds(z));
        time += getSeconds(z);
      }
    }

    if (seconds > 86400 && seconds < 31536000) {
      list.add(String.valueOf(seconds / 86400) + " day" + convert(seconds / 86400));
      long x = seconds % 86400;
      if (x/3600 > 0) {
        list.add(String.valueOf(x / 3600) + " hour" + convert(x / 3600));
      }
      long y = x % 3600;
      if (x % 3600 != 0) {
        list.add(String.valueOf(y / 60) + " minute" + convert(y / 60));
      }
      long z = y % 60;
      if (y % 60 != 0) {
        list.add(getSeconds(z));
      }
    }

    if (seconds > 31536000) {
      list.add(String.valueOf(seconds / 31536000) + " year" + convert(seconds / 31536000));
      long t = seconds % 31536000;
      if (seconds % 31536000 >= 86400) {
        list.add(String.valueOf(t / 86400) + " day" + convert(seconds / 86400));
      }
      long x = t % 86400;
      if (seconds % 86400 >= 1) {
        list.add(String.valueOf(x / 3600) + " hour" + convert(x / 3600));
      }
      long y = x % 3600;
      if (x % 3600 != 0) {
        list.add(String.valueOf(y / 60) + " minute" + convert(y / 60));
      }
      long z = y % 60;
      if (y % 60 != 0) {
        list.add(getSeconds(z));
      }
    }

    if (list.size() == 1) {
      time2 = list.get(0);
      return time2;
    }
    if (list.size() == 2) {
      time2 = list.get(0) + " and " + list.get(1);
      return time2;
    }
    for (int i = 0; i < list.size(); i++) {
      if (i < list.size() - 1) {
        time2 += list.get(i) + ", ";
      } else {
        time2 = time2.substring(0, time2.length() - 2);
        time2 += " and " + list.get(i);
      }
    }
    return time2;
  }

  private static String getSeconds(long i) {
    return i + " second" + convert(i);
  }

  private static String convert(long i) {
    if (i != 1) {
      return "s";
    }
    return "";
  }
}
