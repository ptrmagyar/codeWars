package hu.progmatic;

import java.util.ArrayList;
import java.util.List;

interface StringFunction {
  String run(String str);
}

public class Main {
  public static void main(String[] args) {
    StringFunction exclaim = (s) -> s + "!";
    StringFunction ask = (s) -> s + "?";
    printFormatted("Hello", exclaim);
    printFormatted("Hello", ask);

    List<Integer> inPut = new ArrayList<>();
    inPut.add(2);
    inPut.add(3);
    inPut.add(5);
    inPut.add(6);

    System.out.println(subList(inPut,20));
  }
  public static void printFormatted(String str, StringFunction format) {
    String result = format.run(str);
    System.out.println(result);
  }


  public static List<Integer> subList(List<Integer> list, Integer income){
    int sum = 0;
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < list.size(); i++) {
      sum = 0;
      result.clear();
      for (int j = i; j < list.size() && sum < income; j++) {
          sum += list.get(j);
          result.add(list.get(j));
        if(sum == income){
          return result;
        }
      }
    }

    return new ArrayList<>();
  }


}
