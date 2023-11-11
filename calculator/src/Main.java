import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("Введите два числа от 1 до 10 и действие через пробел (+, -, *, /), римскими или арабскими цифрами: ");
                String input = new Scanner(System.in).nextLine().trim();
                proverkaChisel(input);
                break;
            } catch (ArrayIndexOutOfBoundsException z) {
                System.out.println("Вы ввели недопустимые символы");
            }
        }
    }

    public static void proverkaChisel(String input) {

        String[] str = input.split("(\\s)+");
        String ARABIC_NUMERALS = "1234567890";
        String ROMAN_NUMERALS = "IVX";

        String pervoeChislo = str[0];
        String vtoroeChislo = str[2];

        for (int i = 0; i < input.length(); i++) {
            if (ARABIC_NUMERALS.contains(String.valueOf(pervoeChislo.charAt(i))) && ARABIC_NUMERALS.contains(String.valueOf(vtoroeChislo.charAt(i)))) {
                calculateArabicNumerals(str);
                break;
            } else if (ROMAN_NUMERALS.contains(String.valueOf(pervoeChislo.charAt(i))) && ROMAN_NUMERALS.contains(String.valueOf(vtoroeChislo.charAt(i)))) {
                calculateRomanNumerals(str);
                break;
            } else {
                System.out.println("Можно произвести действие либо с двумя арабскими, либо с двумя римскими цифрами.");
            }
        }
    }

    public static void calculateArabicNumerals(String[] arr) {

        Integer i1 = Integer.parseInt(arr[0]);
        Integer i2 = Integer.parseInt(arr[2]);

        if (arr[1].equals("-")) {
            System.out.println("Разность введенных чисел: " + (i1 - i2));
        } else if (arr[1].equals("+")) {
            System.out.println("Сумма введенных чисел: " + (i1 + i2));
        } else if (arr[1].equals("*")) {
            System.out.println("Произведение введенных чисел: " + (i1 * i2));
        } else if (arr[1].equals("/")) {
            System.out.println("Частное введенных чисел: " + (i1 / i2));
        }
    }

    public static void calculateRomanNumerals(String[] str) {

        String[] arr1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX" };
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        String pervoeChislo = str[0];
        String vtoroeChislo = str[2];

        for (int i = 0; i < arr1.length; i++) {
            if (pervoeChislo.equals(arr1[i])) {
                pervoeChislo = String.valueOf(arr2[i]);
            }
            if (vtoroeChislo.equals(arr1[i])) {
                vtoroeChislo = String.valueOf(arr2[i]);
            }
        }

        int x = Integer.parseInt(pervoeChislo);
        int y = Integer.parseInt(vtoroeChislo);

        if (str[1].equals("+")) {
            int sum = x + y;
            for (int i = 0; i < arr2.length; i++) {
                if (sum == arr2[i]) {
                    System.out.println("Сумма введенных чисел: " + arr1[i]);
                }
            }
        }
        if (str[1].equals("-")) {
            int razn = x - y;
            for (int i = 0; i < arr2.length; i++) {
                if (razn == arr2[i]) {
                    System.out.println("Разность введенных чисел: " + arr1[i]);
                }
            }
        }
        if (str[1].equals("*")) {
            int multiply = x * y;
            for (int i = 0; i < arr2.length; i++) {
                if (multiply == arr2[i]) {
                    System.out.println("Произведение введенных чисел: " + arr1[i]);
                }
            }
        }
        if (str[1].equals("/")) {
            int chastnoe = x / y;
            for (int i = 0; i < arr2.length; i++) {
                if (chastnoe == arr2[i]) {
                    System.out.println("Частное введенных чисел: " + arr1[i]);
                }
            }
        }
    }
}
