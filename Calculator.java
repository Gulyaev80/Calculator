import org.jetbrains.annotations.NotNull;

import java.lang.String;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите математическое выражение состоящее из римских или арабских чисел");
        String expression = sc.nextLine();
        String expressionNew = expression.replace(" ", "");
        String[] operands = expressionNew.split("[-,+,*,/]");
        if (operands.length == 1){
            System.out.println("Строка не является математической операцией!");
            return;
        }
        else if (operands.length !=2){
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор!");
            return;
        }
        String arabian = "1,2,3,4,5,6,7,8,9,10";
        String roman = "I,II,III,IV,V,VI,VII,VIII,IX,X";
        String op1 = operands[0];
        String op2 = operands[1];

        int index = 0;
        if (expressionNew.contains("+")) {
            index = expressionNew.indexOf('+');
        } else if (expressionNew.contains("-")) {
            index = expressionNew.indexOf('-');
        } else if (expressionNew.contains("*")) {
            index = expressionNew.indexOf('*');
        } else if (expressionNew.contains("/")) {
            index = expressionNew.indexOf('/');
        }
        if (arabian.contains(op1) & arabian.contains(op2)) {
            arabian(operands[0], expressionNew.charAt(index), operands[1]);
        } else if (roman.contains(op1) & roman.contains(op2)) {
            roman(operands[0], expressionNew.charAt(index), operands[1]);
        } else if ((arabian.contains(op1)&roman.contains(op2)) || (roman.contains(op1)&arabian.contains(op2)) ) {
            System.out.println(" Операция не может быть выполнена, т. к. используются разные системы исчисления!");
        }

    }

    private static void roman(@NotNull String operand, char charAt, String operand1) {
        String[] arab = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
                "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
                "LVII", "LVII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVII", "LXIX", "LXX", "LXXI", "LXXII",
                "LXXII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int romanArabian = 0;
        if (operand.equals("I")) {
            romanArabian = 1;
        } else if (operand.equals("II")) {
            romanArabian = 2;
        } else if (operand.equals("III")) {
            romanArabian = 3;
        } else if (operand.equals("IV")) {
            romanArabian = 4;
        } else if (operand.equals("V")) {
            romanArabian = 5;
        } else if (operand.equals("VI")) {
            romanArabian = 6;
        } else if (operand.equals("VII")) {
            romanArabian = 7;
        } else if (operand.equals("VIII")) {
            romanArabian = 8;
        } else if (operand.equals("IX")) {
            romanArabian = 9;
        } else if (operand.equals("X")) {
            romanArabian = 10;
        }
        int romanArabian2 = 0;
        if (operand1.equals("I")) {
            romanArabian2 = 1;
        } else if (operand1.equals("II")) {
            romanArabian2 = 2;
        } else if (operand1.equals("III")) {
            romanArabian2 = 3;
        } else if (operand1.equals("IV")) {
            romanArabian2 = 4;
        } else if (operand1.equals("V")) {
            romanArabian2 = 5;
        } else if (operand1.equals("VI")) {
            romanArabian2 = 6;
        } else if (operand1.equals("VII")) {
            romanArabian2 = 7;
        } else if (operand1.equals("VIII")) {
            romanArabian2 = 8;
        } else if (operand1.equals("IX")) {
            romanArabian2 = 9;
        } else if (operand1.equals("X")) {
            romanArabian2 = 10;
        }
        int result = 0;
        if (charAt == '+') {
            result = romanArabian + romanArabian2;
            System.out.println(arab[result-1]);
        } else if (charAt == '-') {
            if (romanArabian > romanArabian2) {
                result = romanArabian - romanArabian2;
                System.out.println(arab[result-1]);
            }else if (romanArabian < romanArabian2) {
                System.out.println("В римской системе нет отрицательных чисел!");
            } else if ((romanArabian == romanArabian2)) {
                System.out.println("В римских цифрах нет цифры 0 ! ");
            }

        } else if (charAt == '*') {
            result = romanArabian * romanArabian2;
            System.out.println(arab[result-1]);
        } else if (charAt == '/') {
            result = romanArabian / romanArabian2;
            System.out.println(arab[result-1]);
        }try {

        }catch (ArrayIndexOutOfBoundsException exc){
        System.out.println(arab[result - 1]);}

    }


    private static void arabian(String operand, char charAt, String operand1) {
        int number1 = Integer.parseInt(operand);
        int number2 = Integer.parseInt(operand1);
        int result = 0;
        if (charAt == '+') {
            result = number1 + number2;
            System.out.println(result);
        } else  if (charAt == '-') {
            result =  number1 - number2;
            System.out.println(result);
        } else if (charAt == '*') {
            result = number1 * number2;
            System.out.println(result);
        } else if (charAt == '/') {
            try {
                result = number1 / number2;
                System.out.println(result);
            } catch (ArithmeticException exp) {
                System.out.println("Делить на ноль нельзя");
            }

        } else {
            System.out.println("Не поддерживаемая операция");
        }

    }
}




