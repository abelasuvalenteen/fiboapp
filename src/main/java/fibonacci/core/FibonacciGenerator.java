package fibonacci.core;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator {

    public int getNumber() {
        return number;
    }

    public int number;
    public final String numberStr;
    public FibonacciGenerator(String number){
        this.numberStr = number;
        generateSum();
    }

    public List<Integer> sequence = new ArrayList<>();

    public int total;

    public String invalidInput = "";

    public List<Integer> getSequence() {
        return sequence;
    }

    public void setSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setInvalidInput(String invalidInput) {this.invalidInput = invalidInput;}

    public String getInvalidInput() {return invalidInput;}

    public void generateSum() {
        if(!isNumeric(this.numberStr)) {
            this.setInvalidInput("Invalid Input, Enter only numbers between 1 to 100");
        } else {
            number = Integer.parseInt(this.numberStr);
            int total = 0;
            int n1=0,n2=1,n3,i;
            for (i = 0; i < number; ++i) {
                n3 = n1 + n2;
                sequence.add(n3);
                total = total + n3;
                n1 = n2;
                n2 = n3;
            }
            this.setSequence(sequence);
            this.setTotal(total);
        }
    }


    public static boolean isNumeric(String string) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);

            if(intValue < 1 || intValue > 100) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}