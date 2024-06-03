package Walk;

public class Hurdles_Coord {
    public int x = 0;
    public int y = 0;
    Controlled controller;
    Random random;
    String name;
    public final int[][] mixedCoordinates = { {2, 3}, {5, -6}, {-9, 1}, {8, -1}, {-6, -5},{-3, 7},{1, -5},{-1, -3}, {4, -2}, {-7, 6}, {10, 2},{-2, -8}, {7, -4}, {-5, 9},{3, -7},{-10, 4}};

    public void Check_Hurdle(int inp){

            switch (inp) {
                case 1 -> {
                    this.y++;
                    for (int[] ele : this.mixedCoordinates) {
                        if (this.x == ele[0] && this.y == ele[1]) {
                            System.out.println("Hurdle at ("+ x +","+ y +"). You Can't Move Here");
                            this.y--;
                        }
                    }
                }
                case 2 -> {
                    this.y--;
                    for (int[] ele : this.mixedCoordinates) {
                        if (this.x == ele[0] && this.y == ele[1]) {
                            System.out.println("Hurdle at ("+ x +","+ y +"). You Can't Move Here");
                            this.y++;
                        }
                    }
                }
                case 3 -> {
                    this.x++;
                    for (int[] ele : this.mixedCoordinates) {
                        if (this.x == ele[0] && this.y == ele[1]) {
                            System.out.println("Hurdle at ("+ x +","+ y +"). You Can't Move Here");
                            this.x--;
                        }
                    }
                }
                case 4 -> {
                    this.x--;
                    for (int[] ele : mixedCoordinates) {
                        if (this.x == ele[0] && this.y == ele[1]) {
                            System.out.println("Hurdle at ("+ x +","+ y +"). You Can't Move Here");
                            this.x++;
                        }
                    }
                }
                default -> System.out.println("Please use valid input only.");
            }
            System.out.printf("%s is at (%d,%d)\n",this.name,this.x,this.y);

    }
    public void steps(int step)
    {
        for (int i = 0; i < step; i++) {
            controller.Control();
            random.random();
        }
        controller.dist();
        random.dist();
    }
}
