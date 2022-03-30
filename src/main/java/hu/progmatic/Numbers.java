package hu.progmatic;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Numbers {


    public static String oddity(BigInteger n) {
        long sum = 0;
        long number = Integer.parseInt(String.valueOf(n));

        for (long i = 1; i <= Math.sqrt(number) + 1; i += 1) {
            if (number % i == 0) {

                // If divisors are
                // equal increment
                // count by one
                // Otherwise increment
                // count by 2
                sum += (number / i == i) ? 1 : 2;
            }
        }
        if (sum % 2 == 0) {
            return "even";
        }
        return "odd";
    }

    public static String repeatStr(final int repeat, final String string) {
        StringBuilder text = new StringBuilder();
        return String.valueOf(text.append(String.valueOf(string).repeat(Math.max(0, repeat))));
    }


    public static String convertFrac(long[][] lst) {
        String list = "";
        int[] numerator = new int[lst.length];
        int[] denominator = new int[lst.length];
        int number1 = 0;
        int number2 = 0;
        List<Long> numbers = new ArrayList<>();
        for (int i = 0; i < lst.length; i++) {
            for (int j = 0; j < lst[i].length; j++) {
                if (j == 0) {
                    number1 = (int) lst[i][j];
                }
                if (j == 1) {
                    number2 = (int) lst[i][j];
                }
            }
            int temp = number2;
            if (number1 > number2) {
                number2 = number1;
                number1 = temp;
            }
            numerator[i] = number2 / number1;

        }
        return list;
    }

    public static String convert(boolean b) {
        return String.valueOf(b);
    }


    public static String rangeExtraction(int[] ints) {
        Arrays.sort(ints);
        String lista = String.valueOf(ints[0]);
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] + 1 != ints[i + 1]) {
                lista += ints[i + 1];
            } else {
                lista += "-";
            }
        }
        return lista;
    }

    public static String bmi(int weight, double height) {
        double bmiIndex = weight / (height * height);
        if (bmiIndex <= 18.5) return "Underweight";
        if (bmiIndex <= 25.0) return "Normal";
        if (bmiIndex <= 30.0) return "Overweight";
        return "Obese";


    }

    public static List filterList(final List<Object> list) {
        return list.stream().filter(object -> object instanceof Integer).collect(Collectors.toList());
    }


    public static String toRoman(int income) {
        StringBuilder roman = new StringBuilder("");

        int digitCounter = Integer.toString(income).length();
        int indexCounter = 0;
        while (digitCounter != 0) {
            int number = Integer.toString(income).charAt(indexCounter) - '0';
            int counter = number;

            if (number > 3 && number < 9) {
                roman.append(fivesToRoman(digitCounter));
                if (number != 4) {
                    counter = number - 5;
                }
            }
            if (number == 9) {
                roman.append(onesToRoman(digitCounter + 1));
            }
            for (int i = 0; i < counter; i++) {

                if (number == 4 || number == 9) {
                    roman.insert(roman.length() - 1, onesToRoman(digitCounter));
                    break;
                }

                if (number < 4 || number > 4 && number < 9) {
                    roman.append(onesToRoman(digitCounter));
                }

            }
            digitCounter--;
            indexCounter++;
        }
        return String.valueOf(roman);
    }

    public static String fivesToRoman(int digitCounter) {
        switch (digitCounter) {
            case 1:
                return "V";
            case 2:
                return "L";
            case 3:
                return "D";
        }
        return "";
    }

    public static String onesToRoman(int digitCounter) {
        switch (digitCounter) {
            case 1:
                return "I";
            case 2:
                return "X";
            case 3:
                return "C";
            case 4:
                return "M";
        }
        return "";
    }

    public static int fromRoman(String income) {
        int sum = 0;
        char dependent = '0';
        for (int i = 0; i < income.length(); i++) {
            char inspected = income.charAt(income.length() - i - 1);
            if (i != 0) {
                dependent = income.charAt(income.length() - i);
            }
            if (inspected == 'I' && dependent != 'V' && dependent != 'X') {
                sum += toInt1(String.valueOf(inspected));
            }
            if (inspected == 'X' && dependent != 'L' && dependent != 'C') {
                sum += toInt1(String.valueOf(inspected));
            }
            if (inspected == 'C' && dependent != 'D' && dependent != 'M') {
                sum += toInt1(String.valueOf(inspected));
            }
            if (inspected == 'M') {
                sum += toInt1(String.valueOf(inspected));
            }
            if (inspected == 'V') {
                sum += toInt5(String.valueOf(inspected));
            }
            if (inspected == 'L') {
                sum += toInt5(String.valueOf(inspected));
            }
            if (inspected == 'D') {
                sum += toInt5(String.valueOf(inspected));
            }
            if (inspected == 'I' && i != 0 && dependent == 'V' || inspected == 'I' && i != 0 && dependent == 'X') {
                sum -= toInt1(String.valueOf(inspected));
            }
            if (inspected == 'X' && i != 0 && dependent == 'L' || inspected == 'X' && i != 0 && dependent == 'C') {
                sum -= toInt1(String.valueOf(inspected));
            }
            if (inspected == 'C' && i != 0 && dependent == 'D' || inspected == 'C' && i != 0 && dependent == 'M') {
                sum -= toInt1(String.valueOf(inspected));
            }
        }
        return sum;
    }

    private static int toInt5(String income) {
        switch (income) {
            case "V":
                return 5;
            case "L":
                return 50;
            case "D":
                return 500;
        }
        return 0;
    }

    public static int toInt1(String income) {
        switch (income) {
            case "I":
                return 1;
            case "X":
                return 10;
            case "C":
                return 100;
            case "M":
                return 1000;
        }
        return 0;
    }

    private static final Map<Integer, String> CONVERSIONS;
    static {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        CONVERSIONS = Collections.unmodifiableMap(map.descendingMap());
    }

    public static int fromRoman1(String romanNumeral) {
        int result = 0;
        for (Map.Entry<Integer, String> entry : CONVERSIONS.entrySet()) {
            while (romanNumeral.startsWith(entry.getValue())) {
                result += entry.getKey();
                romanNumeral = romanNumeral.substring(entry.getValue().length());
            }
        }
        return result;
    }
}
