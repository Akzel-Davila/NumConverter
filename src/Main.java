import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        Boolean custom = false;
        if(base ==10){
            custom = true;
            System.out.print("Enter a base from 1-64 to convert to: ");
            String custom_base = s.nextLine();
            base = Integer.parseInt(custom_base);
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        while (base == 2 && (!number.contains("1") || !number.contains("0"))){
            System.out.println("Must enter correct number for binary");
            System.out.print("Enter your number: ");
            number = s.nextLine();
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        if (custom){
            System.out.println("Number in base: " + base + ": " + nc.convertCustom());
        }
        if (base == 2){
            System.out.println("Number in decimal: " + nc.convertToDecimal());
            System.out.println("Number in octal: " + nc.convertToOctal());
            System.out.println("Number in hex: " + nc.convertToHex());
        }
        if (base == 8) {
            System.out.println("Number in decimal: " + nc.convertToDecimal());
            System.out.println("Number in binary: " + nc.convertToBinary());
            System.out.println("Number in hex: " + nc.convertToHex());
        }
        if (base == 16) {
            System.out.println("Number in decimal: " + nc.convertToDecimal());
            System.out.println("Number in binary: " + nc.convertToBinary());
            System.out.println("Number in octal: " + nc.convertToOctal());
        }

    }
}
