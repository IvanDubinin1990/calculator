import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("Введите два числа от 1 до 10 и действие через пробел (+, -, *, /), римскими или арабскими цифрами: ");
                String input = new Scanner(System.in).nextLine().trim();
                checkNumbersOne(input);
                break;
            } catch (ArrayIndexOutOfBoundsException z1) {
                System.out.println("Вы ввели недопустимые символы. Попробуйте ещё раз!");
            } catch (StringIndexOutOfBoundsException z2) {
                System.out.println("Попробуйте ещё раз!");
            } catch (ArithmeticException z3) {
                System.out.println("На ноль делить нельзя. Попробуйте ещё раз!");
            }
        }
    }

    public static void checkNumbersOne(String input) {

        String[] str = input.split("(\\s)+");

        if (str.length == 3) {

            String ARABIC_NUMERALS = "1234567890";
            String ROMAN_NUMERALS = "IVXLC";
            String ARITHMETIC_OPERATION = "+-*/";

            String firstNumber = str[0];
            String secondNumber = str[2];
            String operation = str[1];

            for (int i = 0; i < input.length(); i++) {
                if (ARITHMETIC_OPERATION.contains(String.valueOf(operation.charAt(i)))) {
                    if (ARABIC_NUMERALS.contains(String.valueOf(firstNumber.charAt(i))) && ARABIC_NUMERALS.contains(String.valueOf(secondNumber.charAt(i)))) {
                        calculateArabicNumerals(str);
                        break;
                    } else if (ROMAN_NUMERALS.contains(String.valueOf(firstNumber.charAt(i))) && ROMAN_NUMERALS.contains(String.valueOf(secondNumber.charAt(i)))) {
                        calculateRomanNumerals(str);
                        break;
                    } else {
                        System.out.println("Можно произвести действие либо с двумя арабскими, либо с двумя римскими цифрами.");
                    }
                } else {
                    System.out.println("Неверная операция");
                }
            }
        } else {
            System.out.println("Неверное количество символов");
        }
    }

    public static boolean checkNumbersTwo(Integer i1, Integer i2) {

        if (i1 < 0 || i1 > 10) {
            if (i2 < 0 || i2 > 10) {
                System.out.println("Первое и второе число некорректны");
                return false;
            } else {
                System.out.println("Первое число некорректно");
                return false;
            }
        } else if (i2 < 0 || i2 > 10) {
            System.out.println("Второе число некорректно");
            return false;
        }
        return true;
    }

    public static void calculateArabicNumerals(String[] arr) {

        Integer i1 = Integer.parseInt(arr[0]);
        Integer i2 = Integer.parseInt(arr[2]);

        boolean isCheck = checkNumbersTwo(i1, i2);
        if (isCheck) {
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
    }

    public static void calculateRomanNumerals(String[] str) {

        String[] arr1 = {"-IX", "-VIII", "-VII", "-VI", "-V", "-IV", "-III", "-II", "-I", "N", "I", "II", "III", "IV", "V", "VI", "VII",
                "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXIV", "XXV", "XXVII",
                "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX", "LXIII",
                "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};
        int[] arr2 = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25,
                27, 28, 30, 32, 35, 36, 40, 42, 45, 48, 49, 50, 54, 56, 60, 63, 64, 70, 72, 80, 81, 90, 100};

        String firstNumber = str[0];
        String secondNumber = str[2];

        for (int i = 0; i < arr1.length; i++) {
            if (firstNumber.equals(arr1[i])) {
                firstNumber = String.valueOf(arr2[i]);
            }
            if (secondNumber.equals(arr1[i])) {
                secondNumber = String.valueOf(arr2[i]);
            }
        }

        Integer x = Integer.parseInt(firstNumber);
        Integer y = Integer.parseInt(secondNumber);

        boolean isCheck = checkNumbersTwo(x, y);

        if (isCheck) {

            if (str[1].equals("+")) {
                int addition = x + y;
                for (int i = 0; i < arr2.length; i++) {
                    if (addition == arr2[i]) {
                        System.out.println("Сумма введенных чисел: " + arr1[i]);
                    }
                }
            }
            if (str[1].equals("-")) {
                int subtraction = x - y;
                for (int i = 0; i < arr2.length; i++) {
                    if (subtraction == arr2[i]) {
                        System.out.println("Разность введенных чисел: " + arr1[i]);
                    }
                }
            }
            if (str[1].equals("*")) {
                int multiplication = x * y;
                for (int i = 0; i < arr2.length; i++) {
                    if (multiplication == arr2[i]) {
                        System.out.println("Произведение введенных чисел: " + arr1[i]);
                    }
                }
            }
            if (str[1].equals("/")) {
                int division = x / y;
                for (int i = 0; i < arr2.length; i++) {
                    if (division == arr2[i]) {
                        System.out.println("Частное введенных чисел: " + arr1[i]);
                    }
                }
            }
        }
    }
}
