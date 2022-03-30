package hu.progmatic;


import java.util.*;

public class StringMix {


  public static String mix(String s1, String s2) {
    LinkedHashMap<String, Integer> stringlista1 = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> stringlista2 = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> stringMap = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();


    String lista = "";


    for (int i = 0; i < s1.length(); i++) {
      Integer rarity = stringlista1.get(String.valueOf(s1.charAt(i)));
      if (s1.charAt(i) <= 'z' && s1.charAt(i) >= 'a') {
        stringlista1.put(String.valueOf(s1.charAt(i)), (rarity == null ? 1 : rarity + 1));
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      Integer rarity = stringlista2.get(String.valueOf(s2.charAt(i)));
      if (s2.charAt(i) <= 'z' && s2.charAt(i) >= 'a') {
        stringlista2.put(String.valueOf(s2.charAt(i)), (rarity == null ? 1 : rarity + 1));
      }
    }


    if (stringlista1.size() > stringlista2.size()) {
      for (Map.Entry<String, Integer> map : stringlista1.entrySet()) {
        if (stringlista2.containsKey(map.getKey()) && map.getValue() > 1) {
          if (stringlista2.get(map.getKey()) < map.getValue()) {
            lista += "1:";
            stringMap.put(map.getKey(), map.getValue());
            for (int i = 0; i < map.getValue(); i++) {
              lista += map.getKey();
              if (i == map.getValue() - 1) {
                lista += "/";
              }
            }
          }
        }
        if (stringlista2.containsKey(map.getKey()) && map.getValue() > 1) {
          if (stringlista2.get(map.getKey()) > map.getValue()) {
            lista += "2.";
            stringMap.put(map.getKey(), stringlista2.get(map.getKey()));
            for (int i = 0; i < stringlista2.get(map.getKey()); i++) {
              lista += map.getKey();
              if (i == stringlista2.get(map.getKey()) - 1) {
                lista += "/";
              }
            }
          }
        }
        if (stringlista2.containsKey(map.getKey()) && map.getValue() > 1) {
          if (stringlista2.get(map.getKey()) == map.getValue()) {
            lista += "=:";
            stringMap.put(map.getKey(), map.getValue());
            for (int i = 0; i < map.getValue(); i++) {
              lista += map.getKey();
            }
          }
        }
      }
      stringMap.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

      return String.valueOf(reverseSortedMap);
    }

    for (Map.Entry<String, Integer> map : stringlista2.entrySet()) {
      if (stringlista1.containsKey(map.getKey()) && map.getValue() > 1) {
        if (stringlista1.get(map.getKey()) < map.getValue()) {
          lista += "2:";
          stringMap.put(map.getKey(), map.getValue());
          for (int i = 0; i < map.getValue(); i++) {
            lista += map.getKey();
            if (i == map.getValue() - 1) {
              lista += "/";
            }
          }
        }
      }
      if (stringlista1.containsKey(map.getKey()) && map.getValue() > 1) {
        if (stringlista1.get(map.getKey()) > map.getValue()) {
          lista += "1.";
          stringMap.put(map.getKey(), stringlista2.get(map.getKey()));
          for (int i = 0; i < stringlista2.get(map.getKey()); i++) {
            lista += map.getKey();
            if (i == stringlista2.get(map.getKey()) - 1) {
              lista += "/";
            }
          }
        }
      }
      if (stringlista1.containsKey(map.getKey()) && map.getValue() > 1) {
        if (stringlista1.get(map.getKey()) == map.getValue()) {
          lista += "=:";
          stringMap.put(map.getKey(), map.getValue());
          for (int i = 0; i < map.getValue(); i++) {
            lista += map.getKey();
            if (i == map.getValue() - 1) {
              lista += "/";
            }
          }
        }
      }
    }
    stringMap.entrySet()
    .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

    return String.valueOf(reverseSortedMap);

  }


}
