package ru.kochanovskiy.convertingnumberstring;

import java.util.Scanner;
import static ru.kochanovskiy.convertingnumberstring.Parser.*;

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();

        while (true){

            /**
             * Invitation to enter a number
             */
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите ваше число: ");
//            System.out.print("Enter your number: ");
            int enteredNumber = Integer.parseInt(scan.next());

            /**
             * Output of result
             */
            if(enteredNumber > 0){
                System.out.println(parser.decimalParser(Integer.toString(enteredNumber)) + " в десятиричной системе счисления;");
                System.out.println(parser.decimalParser(parser.octalConversion(enteredNumber)) + " в восьмеричной системе счисления;");

//                System.out.println(decimalParser(Integer.toString(enteredNumber)) + " in decimal notation;");
//                System.out.println(decimalParser(octalConversion(enteredNumber)) + " in octal notation;");

                System.out.println("");
            } else {
                System.out.println("Введите целое положительное число!");
//                System.out.println("Enter a positive integer!");
            }
        }
    }
}