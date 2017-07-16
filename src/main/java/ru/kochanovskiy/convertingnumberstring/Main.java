package ru.kochanovskiy.convertingnumberstring;

import org.apache.log4j.Logger;

import java.util.Scanner;

import static ru.kochanovskiy.convertingnumberstring.Parser.*;

public class Main {

    static private Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        while (true){

            /**
             * Invitation to enter a number
             */
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your number: ");
            int enteredNumber = Integer.parseInt(scan.next());

            /**
             * Output of result
             */
            if(enteredNumber > 0){
                System.out.println(decimalParser(Integer.toString(enteredNumber)) + " в десятиричной системе;");
                System.out.println(decimalParser(octalConversion(enteredNumber)) + " в восьмеричной системе;");
                System.out.println("");
            } else {
                System.out.println("Введите целое положительное число!");
            }
        }

    }

}
