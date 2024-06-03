package PacMan_Game;
class MazeMaker{
    static int food = 0;
    static int m = 20;
    static int n = 20;
    static String[][] bound = new String[m][n];


    public void setMaze() {


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) //i statements for top and bottom border
// j statements for lef t and right border
                {
                    bound[i][j] = "#"; //outer wall
                } else if ((i == 2 && j >1 && j < 8) || (i == 2 && j >11 && j < 18)) {
                    bound[i][j] = "#";
                }else if ((i == 17 && j >1 && j < 8) || (i == 17 && j >11 && j < 18)) {
                    bound[i][j] = "#";
                } else if (i > 2 && i < 8 && (j == 2 || j == 17)) {
                    bound[i][j] = "#";

                }else if (i > 11 && i < 17 && (j == 2 || j == 17)) {
                    bound[i][j] = "#";

                } else if (i == 4 && j > 5 && j  < 14) {
                    bound[i][j] = "#";
                }else if (i == 15 && j > 5 && j  < 14) {
                    bound[i][j] = "#";
                }
                else if (j == 4 && i > 5 && i  < 14) {
                    bound[i][j] = "#";
                }else if (j == 15 && i > 5 && i  < 14) {
                    bound[i][j] = "#";
                } else if (j > 6 && j < 13 && i > 6 && i < 13) {
                    // Create a box with "#" border and "." inside
                    if (i == 7 && (j == 7 || j == 12)) {
                        bound[i][j] = "#";
                    } else if (i == 12 && (j == 7 || j == 12)) {
                        bound[i][j] = "#";
                    } else if (i > 7 && j > 7 && j < 12) {
                        bound[i][j] = ".";
                        food++;// inner space
                    } else {
                        bound[i][j] = "#"; // border of the box
                    }
                } else // Food
                {
                    bound[i][j] = ".";
                    food++;//inner food
                }
            }

        }

    }

    public void draw() {
        System.out.println("\r");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(bound[i][j] + " ");

            }
            System.out.println("\r");
        }

    }


}

public class GameBoard {
    public static void main(String[] args) {
        MazeMaker mz = new MazeMaker();
        mz.setMaze();
        MazeMaker.bound[8][11] = "\uD83D\uDE04";
        MazeMaker.bound[1][1] = "👻";
        MazeMaker.bound[1][18] = "👻";


        Pacman pacman = new Pacman();
        Enemies enemies1 = new Enemies();
        Enemies enemies2 = new Enemies();
        pacman.pac_x = 8;
        pacman.pac_y = 11;
        enemies1.en_x = 1;
        enemies1.en_y = 1;
        enemies2.en_x = 1;
        enemies2.en_y = 18;
        while(true){
            mz.draw();
            System.out.println("Score: "+ pacman.score);
            pacman.run_pac();
            enemies1.run_en();
            enemies2.run_en();
            if (MazeMaker.food == 0) {
                System.out.println("""
                    You Won!
                    Your Score: 
                    """+ pacman.score);
                break;
            } else if ((pacman.pac_x == enemies1.en_x && pacman.pac_y == enemies1.en_y) || (pacman.pac_x == enemies2.en_x && pacman.pac_y == enemies2.en_y))
            {
                System.out.println("You Lost! Try Again");
                break;
            }

        }


    }



    }

