package Walk;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Hurdles_Coord hur = new Hurdles_Coord();
        Controlled player1 = new Controlled("Ali");
        Random player2 = new Random("Hasan");

        hur.controller = player1;
        hur.random = player2;
        System.out.println("Ali Takes Orders."+" Walks By Will.");
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Number Of Steps:");
        hur.steps(inp.nextInt());

    }
}
