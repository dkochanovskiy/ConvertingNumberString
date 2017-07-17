package ru.kochanovskiy.convertingnumberstring;

class Parser {

    private static String outputString = null;

    private static String unitsRu[] = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    private static String unitsEn[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen ", "fourteen", "fifteen ", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String tensRu[] = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static String tensEn[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String hundredsRu[] = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static String hundredsEn[] = {"", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};

    /**
     * One numeral convertation
     */
    private static void oneNumeral(String enteredString, String[] inputArrayU){
        for (int i = 0; i < 10; i++){
            if (enteredString.equals(Integer.toString(i))) outputString = inputArrayU[i];
        }
    }

    /**
     * Two numeral convertation
     */
    private static void twoNumeral(String enteredString, char[] arrayOfDigits, String[] inputArrayT, String[] inputArrayU){
        if(arrayOfDigits[0] == '1'){
            int unit = 1;
            for (char c = '0'; c <= '9'; c++){
                if (arrayOfDigits[1] == c) outputString = inputArrayU[Integer.parseInt(Integer.toString(unit) + String.valueOf(c))];
            }
        } else {
            for (char i = '2'; i <= '9'; i++){
                if (arrayOfDigits[0] == i){
                    if (arrayOfDigits[1] == '0') outputString = inputArrayT[Integer.parseInt(String.valueOf(i))];
                    for (char c = '1'; c <= '9'; c++){
                        if (arrayOfDigits[1] == c) outputString = inputArrayT[Integer.parseInt(String.valueOf(i))] + " " + inputArrayU[Integer.parseInt(String.valueOf(c))];
                    }
                }
            }
        }
    }

    /**
     * Three numeral convertation
     */
    private static void threeNumeral(String enteredString, char[] arrayOfDigits, String[] inputArrayT, String[] inputArrayU, String[] inputArrayH){
        for (char c = '1'; c <= '9'; c++){
            if (arrayOfDigits[0] == c){
                if (arrayOfDigits[1] == '0'){
                    if (arrayOfDigits[2] == '0') outputString = inputArrayH[Integer.parseInt(String.valueOf(c))];
                    for (char i = '1'; i <= '9'; i++){
                        if (arrayOfDigits[2] == i) outputString = inputArrayH[Integer.parseInt(String.valueOf(c))] + " " + inputArrayU[Integer.parseInt(String.valueOf(i))];
                    }
                }if (arrayOfDigits[1] == '1'){
                    for (char i = '0'; i <= '9'; i++){
                        if (arrayOfDigits[2] == i) outputString = inputArrayH[Integer.parseInt(String.valueOf(c))] + " " + inputArrayU[Integer.parseInt(1 + String.valueOf(i))];
                    }
                }
                for (char j = '2'; j <= '9'; j++){
                    if (arrayOfDigits[1] == j){
                        if (arrayOfDigits[2] == '0') outputString = inputArrayH[Integer.parseInt(String.valueOf(c))] + " " + inputArrayT[Integer.parseInt(String.valueOf(j))];
                        for (char i = '1'; i <= '9'; i++){
                            if (arrayOfDigits[2] == i) outputString = inputArrayH[Integer.parseInt(String.valueOf(c))] + " " + inputArrayT[Integer.parseInt(String.valueOf(j))] + " " + inputArrayU[Integer.parseInt(String.valueOf(i))];
                        }
                    }
                }
            }
        }
    }

    /**
     * Verbal number notation in decimal notation
     */
    String decimalParser(String enteredString){

        char[] arrayOfDigits = enteredString.toCharArray();
        if(enteredString.length() == 1){
            oneNumeral(enteredString, unitsRu);
        }
        if (enteredString.length() == 2){
            twoNumeral(enteredString, arrayOfDigits, tensRu, unitsRu);
        }
        if (enteredString.length() == 3){
            threeNumeral(enteredString, arrayOfDigits, tensRu, unitsRu, hundredsRu);
        }
        return outputString;
    }

    /**
     * Conversion to octal notation
     */
    String octalConversion(int convertNumber){
        int notation = 8;
        return Integer.toString(convertNumber, notation);
    }
}