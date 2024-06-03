package Walk;

public class Random {
    Hurdles_Coord Hasan = new Hurdles_Coord();



    public Random(String name) {
        Hasan.name = name;
    }

    public void random()
    {
        java.util.Random random = new java.util.Random();
        int ran = random.nextInt(1, 5);
        Hasan.Check_Hurdle(ran);
    }

    @Override
    public String toString() {
        return "("+Hasan.x+","+Hasan.y+")";
    }
    public void dist()
    {
        double dis = Math.sqrt(Math.pow(Hasan.x,2.0)+Math.pow(Hasan.y,2.0));
        System.out.printf("The Distance of %s from Starting Position is: %.4f%n",Hasan.name, dis);
    }
}
