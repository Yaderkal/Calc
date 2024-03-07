//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию");
        String string = scanner.nextLine();
        String operation;
        int result;
        int match=0;
        int number1=0;
        int number2=0;
        String[] mass;
        if (string.contains("+")) {
            mass = string.split("\\+");
            operation ="+";
        }
        else if (string.contains("-")) {
            mass = string.split("\\-");
            operation ="-";
        }
        else if (string.contains("/")) {
            mass = string.split("\\/");
            operation ="/";
        }
        else if (string.contains("*")) {
            mass = string.split("\\*");
            operation ="*";
        }
        else throw new Exception("Операция не найдена");
        if (mass.length>=3) {
            throw new InputMismatchException("Неверный формат данных");
        }
        match = isNumber(mass[0],mass[1]);
        if (match == 1)  {
            number1 = Integer.parseInt(mass[0]);
            number2 = Integer.parseInt(mass[1]);
            result = calculate(number1, number2, operation);
            System.out.println(result);
        }
        else if (match == 0){
            number1 = romanToNum(mass[0]);
            number2 = romanToNum(mass[1]);
            result = calculate(number1, number2, operation);
            String newresult = convToArab(result);
            System.out.println(newresult);
        }
    }
    private static String convToArab (int numArab){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArab];
        return s;
    }
    private static int romanToNum(String roman) {

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        else throw new InputMismatchException("Неверный формат данных");
    }
    private static int isNumber(String num1, String num2) {
        try {
            int check1=Integer.parseInt(num1);
            int check2=Integer.parseInt(num2);
            if (check1-10<=0 && check2-10<=0) {
                return 1;
            }
            else throw new InputMismatchException("Неверный формат данных");
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
    private static int calculate(int num1, int num2, String oper) {
        int result = 0;
        switch(oper) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                throw new IllegalArgumentException("не верный знак операции");
        }
        return result;
    }
}