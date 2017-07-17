package ru.kochanovskiy.convertingnumberstring;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Parser {

    static private Logger logger = Logger.getLogger(Parser.class);

    static String outputString = null;

    private static String units[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static String tens[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static String hundreds[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    /**
     * Number partitioning
     */
    static ArrayList<Integer> numbPart(int number){
        ArrayList<Integer> arrayDigits = null;

        while (number > 0){
            number %= 10;
            arrayDigits.add(number);
        }

        return arrayDigits;
    }

    /**
     * One numeral convertation
     */
    private static void oneNumeral(String enteredString){
        for (int i = 0; i < 10; i++){
            if (enteredString.equals(Integer.toString(i))) outputString = units[i];
        }
    }

    /**
     * Two numeral convertation
     */
    private static void twoNumeral(String enteredString, char[] arrayOfDigits){
        if(arrayOfDigits[0] == '1'){
            int unit = 1;
            for (char c = '0'; c <= '9'; c++){
                if (arrayOfDigits[1] == c) outputString = units[Integer.parseInt(Integer.toString(unit) + String.valueOf(c))];
            }
        } else {
            for (char i = '2'; i <= '9'; i++){
                if (arrayOfDigits[0] == i){
                    if (arrayOfDigits[1] == '0') outputString = tens[Integer.parseInt(String.valueOf(i))];
                    for (char c = '1'; c <= '9'; c++){
                        if (arrayOfDigits[1] == c) outputString = tens[Integer.parseInt(String.valueOf(i))] + " " + units[Integer.parseInt(String.valueOf(c))];
                    }
                }
            }
        }
    }

    /**
     * Verbal number notation in decimal notation
     */
    static String decimalParser(String enteredString){

        char[] arrayOfDigits = enteredString.toCharArray();
        if(enteredString.length() == 1){
            oneNumeral(enteredString);
        }
        if (enteredString.length() == 2){
            twoNumeral(enteredString, arrayOfDigits);
        }
        if (enteredString.length() == 3){
            for (char c = '1'; c <= '9'; c++){
                if (arrayOfDigits[0] == c){
                    if (arrayOfDigits[1] == '0'){
                        if (arrayOfDigits[2] == '0') outputString = hundreds[Integer.parseInt(String.valueOf(c))];
                        for (char i = '1'; i <= '9'; i++){
                            if (arrayOfDigits[2] == c) outputString = hundreds[Integer.parseInt(String.valueOf(c))] + " " + units[Integer.parseInt(String.valueOf(c))];
                        }
                    }
                }
            }
        }
        return outputString;
    }

    /**
     * Conversion to octal notation
     */
    static String octalConversion(int convertNumber){
        int notation = 8;
        return Integer.toString(convertNumber, notation);
    }

}
