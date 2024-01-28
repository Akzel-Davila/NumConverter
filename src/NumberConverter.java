import java.util.HashMap;

public class NumberConverter {
    int[] digits;
    int base;


    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }


    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }


    public int[] getDigits() {
        return digits;
    }


    public int convertToDecimal() {
        int total = 0;
        for (int i = 0; i<digits.length; i++){
            total = digits[i] * (int)(Math.pow(base,digits.length-1)) + total;
        }
        return total;
    }


    public String convertToBinary() {
        int number = Integer.parseInt(displayOriginalNumber().trim());
        if(base!=10){
            number = convertToDecimal();
        }
        String num = "";
        while (number != 0){
            num = number%2 + num ;
            number = number/2;
        }
        return num;
    }


    public String convertToOctal() {
        int number = Integer.parseInt(displayOriginalNumber().trim());
        if (base!=10) {
            number = convertToDecimal();
        }
        String num = "";
        while (number != 0){
            num = number%8 + num;
            number = number/8;
        }
        return num;
    }
    public String convertToHex(){
        HashMap map = makeMap();
        int number = Integer.parseInt(displayOriginalNumber().trim());
        if(base!=10) {
            number = convertToDecimal();
        }
        String num = "";
        while (number != 0){
            if(number%16 > 9)
            {
                num = map.get(number%16) + num;
            }
            else
            {
                num = number%16 + num;
            }
            number = number/16;
        }
        return num;
    }
    public String convertCustom(){
        HashMap<Integer, String> map = makeMap();
        int number = Integer.parseInt(displayOriginalNumber().trim());
        String num = "";
        while (number != 0){
            if(number%base > 9)
            {
                num = map.get(number%base) + num;
            }
            else
            {
                num = number%base + num;
            }
            number = number/base;
        }
        return num;
    }
    public HashMap makeMap(){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        map.put(16, "G");
        map.put(17, "H");
        map.put(18, "I");
        map.put(19, "J");
        map.put(20, "K");
        map.put(21, "L");
        map.put(22, "M");
        map.put(23, "N");
        map.put(24, "O");
        map.put(25, "P");
        map.put(26, "Q");
        map.put(27, "R");
        map.put(28, "S");
        map.put(29, "T");
        map.put(30, "U");
        map.put(31, "V");
        map.put(32, "W");
        map.put(33, "X");
        map.put(34, "Y");
        map.put(35, "Z");
        map.put(36, "a");
        map.put(37, "b");
        map.put(38, "c");
        map.put(39, "d");
        map.put(40, "e");
        map.put(41, "f");
        map.put(42, "g");
        map.put(43, "h");
        map.put(44, "i");
        map.put(45, "j");
        map.put(46, "k");
        map.put(47, "l");
        map.put(48, "m");
        map.put(49, "n");
        map.put(50, "o");
        map.put(51, "p");
        map.put(52, "q");
        map.put(53, "r");
        map.put(54, "s");
        map.put(55, "t");
        map.put(56, "u");
        map.put(57, "v");
        map.put(58, "w");
        map.put(59, "x");
        map.put(60, "y");
        map.put(61, "z");
        map.put(62, "+");
        map.put(63, "/");

        return map;
    }
}

