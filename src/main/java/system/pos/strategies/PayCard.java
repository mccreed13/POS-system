package system.pos.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayCard implements PayStrategy{

    @Override
    public boolean pay(double paymentAmount) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isPayed = false;
        try {
            boolean isDone = false;
            while(!isDone){
                String s = reader.readLine();
                switch (s) {
                    case "c" -> {
                        System.out.println("Canceled");
                        isDone = true;
                    }
                    case "p" -> {
                        System.out.println("Payed");
                        isPayed = true;
                        isDone = true;
                    }
                    default -> {
                        System.out.println("Something goes wrong");
                        System.out.println("Try again");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isPayed;
    }
}
