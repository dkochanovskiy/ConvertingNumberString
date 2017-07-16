package ru.kochanovskiy.convertingnumberstring;

import org.apache.log4j.Logger;

public class Parser {

    static private Logger logger = Logger.getLogger(Parser.class);

    private static String arrayWords[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static String arrayWordsBig[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    /**
     * Verbal number notation in decimal notation
     */
    static String decimalParser(String enteredString){
        String outputString = null;
        char[] arrayOfDigits = enteredString.toCharArray();
        if(enteredString.length() == 1){
            for (int i = 0; i < 10; i++){
                if (enteredString.equals(Integer.toString(i))) outputString = arrayWords[i];
            }

        } else if (enteredString.length() == 2){

            if(arrayOfDigits[0] == '1'){
                for (char c = 0; c < 10; c++){
                    if (arrayOfDigits[1] == c) outputString = arrayWords[Integer.parseInt(String.valueOf(arrayOfDigits[0]) + arrayWords[c])];
                    System.out.println(arrayWords[Integer.parseInt(arrayWords[1] + " " + arrayWords[c])]);
                }
//                if (arrayOfDigits[1] == '0') outputString = arrayWords[10];
//                if (arrayOfDigits[1] == '1') outputString = arrayWords[11];
//                if (arrayOfDigits[1] == '2') outputString = arrayWords[12];
//                if (arrayOfDigits[1] == '3') outputString = arrayWords[13];
//                if (arrayOfDigits[1] == '4') outputString = arrayWords[14];
//                if (arrayOfDigits[1] == '5') outputString = arrayWords[15];
//                if (arrayOfDigits[1] == '6') outputString = arrayWords[16];
//                if (arrayOfDigits[1] == '7') outputString = arrayWords[17];
//                if (arrayOfDigits[1] == '8') outputString = arrayWords[18];
//                if (arrayOfDigits[1] == '9') outputString = arrayWords[19];
            } else {
                if (arrayOfDigits[0] == '2'){
                    if (arrayOfDigits[1] == '0') outputString = arrayWordsBig[2];
                    if (arrayOfDigits[1] == '1') outputString = arrayWordsBig[2] + " " + arrayWords[1];
                    if (arrayOfDigits[1] == '2') outputString = arrayWordsBig[2] + " " + arrayWords[2];
                    if (arrayOfDigits[1] == '3') outputString = arrayWordsBig[2] + " " + arrayWords[3];
                    if (arrayOfDigits[1] == '4') outputString = arrayWordsBig[2] + " " + arrayWords[4];
                    if (arrayOfDigits[1] == '5') outputString = arrayWordsBig[2] + " " + arrayWords[5];
                    if (arrayOfDigits[1] == '6') outputString = arrayWordsBig[2] + " " + arrayWords[6];
                    if (arrayOfDigits[1] == '7') outputString = arrayWordsBig[2] + " " + arrayWords[7];
                    if (arrayOfDigits[1] == '8') outputString = arrayWordsBig[2] + " " + arrayWords[8];
                    if (arrayOfDigits[1] == '9') outputString = arrayWordsBig[2] + " " + arrayWords[9];
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
