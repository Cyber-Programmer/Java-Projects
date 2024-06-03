package DigitalClock;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        W_DigitalTimer t1 = new W_DigitalTimer();
        System.out.println("How many Seconds you want to run the timer");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Hours: ");
        int h = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Minutes: ");
        int m = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Seconds: ");
        int s = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter AM/PM");
        String divider = sc.next();
        t1.setvalue(h, m, s,divider);
        t1.tick(b);
    }


}
