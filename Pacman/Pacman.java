package PacMan_Game;



import java.util.Scanner;

public class Pacman {
    int pac_x;
    int pac_y;
    MazeMaker m;
    int score = 0;
    public void run_pac()
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Where To Move: 1)Right 2)Left 3)Down 4)Up");
        int move = input.nextInt();
        switch (move) {
            case 1 -> {
                this.pac_y++;
                if (MazeMaker.bound[this.pac_x][this.pac_y].equals(".")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x][this.pac_y-1] = " ";
                    MazeMaker.food--;
                    score+=5;
                } else if (MazeMaker.bound[this.pac_x][this.pac_y].equals(" ")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x][this.pac_y-1] = " ";
                }  else if(MazeMaker.bound[this.pac_x][this.pac_y].equals("#")){
                    System.out.println("Hurdle at "+this.pac_x+","+this.pac_y);
                    this.pac_y--;
                }
            }
            case 2 -> {
                this.pac_y--;
                if (MazeMaker.bound[this.pac_x][this.pac_y].equals(".")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x][this.pac_y+1] = " ";
                    score+=5;
                    MazeMaker.food--;
                }
                else if (MazeMaker.bound[this.pac_x][this.pac_y].equals(" ")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x][this.pac_y+1] = " ";
                }

                else if(MazeMaker.bound[this.pac_x][this.pac_y].equals("#")){
                    System.out.println("Hurdle at "+this.pac_x+","+this.pac_y);
                    this.pac_y++;
                }
                }
            case 3 -> {
                this.pac_x++;
                if (MazeMaker.bound[this.pac_x][this.pac_y].equals(".")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x-1][this.pac_y] = " ";
                    score+=5;
                    MazeMaker.food--;
                }
                else if (MazeMaker.bound[this.pac_x][this.pac_y].equals(" ")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x-1][this.pac_y] = " ";
                }

                else if (MazeMaker.bound[this.pac_x][this.pac_y].equals("#")){
                    System.out.println("Hurdle at "+this.pac_x+","+this.pac_y);
                    this.pac_x--;
                }
            }
            case 4 -> {
                this.pac_x--;
                if (MazeMaker.bound[this.pac_x][this.pac_y].equals(".")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x+1][this.pac_y] = " ";
                    score+=5;
                    MazeMaker.food--;
                }
                else if (MazeMaker.bound[this.pac_x][this.pac_y].equals(" ")) {
                    MazeMaker.bound[this.pac_x][this.pac_y] = "\uD83D\uDE04";
                    MazeMaker.bound[this.pac_x+1][this.pac_y] = " ";
                }

                else if(MazeMaker.bound[this.pac_x][this.pac_y].equals("#")){
                    System.out.println("Hurdle at "+this.pac_x+","+this.pac_y);
                    this.pac_x++;
                }
            }
            default -> System.out.println("Please use valid input only.");
        }

        }

    }


