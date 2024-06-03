package Walk;

import java.util.Scanner;

public class Controlled {
    Hurdles_Coord Ali = new Hurdles_Coord();


    public Controlled(String name) {
        Ali.name = name;
    }

    public void Control()
    {

            Scanner input = new Scanner(System.in);
            System.out.println(Ali.name+":Where Should I Go Now: 1)up 2)down 3)left 4)right");
            int move = input.nextInt();
            Ali.Check_Hurdle(move);

    }
    @Override
    public String toString() {
        return "("+Ali.x+","+Ali.y+")";
    }

    public void dist()
    {
        double dis = Math.sqrt(Math.pow(Ali.x,2.0)+Math.pow(Ali.y,2.0));
        System.out.printf("The Distance of %s form Starting Position is: %.4f%n",Ali.name, dis);
    }
}
