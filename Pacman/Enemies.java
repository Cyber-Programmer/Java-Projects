package PacMan_Game;



public class Enemies {
    int en_x;
    int en_y;
    MazeMaker m;
    public void run_en()
    {
        java.util.Random random = new java.util.Random();
        int ran = random.nextInt(1,5);
        switch (ran) {
            case 1 -> {
                this.en_y++;
                if (MazeMaker.bound[this.en_x][this.en_y].equals(".")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x][this.en_y-1] = ".";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals(" ")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x][this.en_y-1] = " ";
                } else if (MazeMaker.bound[this.en_x][this.en_y].equals("#")){
                    System.out.println("Hurdle at "+this.en_x+","+this.en_y);
                    this.en_y--;
                }
            }
            case 2 -> {
                this.en_y--;
                if (MazeMaker.bound[this.en_x][this.en_y].equals(".")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x][this.en_y+1] = ".";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals(" ")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x][this.en_y+1] = " ";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals("#")){
                    System.out.println("Hurdle at "+this.en_x+","+this.en_y);
                    this.en_y++;
                }
                }
            case 3 -> {
                this.en_x++;
                if (MazeMaker.bound[this.en_x][this.en_y].equals(".")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x-1][this.en_y] = ".";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals(" ")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x-1][this.en_y] = " ";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals("#")){
                    System.out.println("Hurdle at "+this.en_x+","+this.en_y);
                    this.en_x--;
                }
            }
            case 4 -> {
                this.en_x--;
                if (MazeMaker.bound[this.en_x][this.en_y].equals(".")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x+1][this.en_y] = ".";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals(" ")) {
                    MazeMaker.bound[this.en_x][this.en_y] = "👻";
                    MazeMaker.bound[this.en_x+1][this.en_y] = " ";
                }
                else if (MazeMaker.bound[this.en_x][this.en_y].equals("#")){
                    System.out.println("Hurdle at "+this.en_x+","+this.en_y);
                    this.en_x++;
                }
            }
            default -> System.out.println("Please use valid input only.");
        }

        }
}
