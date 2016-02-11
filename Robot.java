
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Robot {

    private int[] hall;
    private int pos;
    private boolean facingRight;

    public Robot() {
        hall = new int[]{1, 1, 2, 3, 4, 5};
        pos = 3;
        facingRight = true;
    }

    private boolean forwardMoveBlocked() {
        return (facingRight && pos == hall.length - 1) || (!facingRight && pos == 0);
    }

    private void move() {
        if (hall[pos] > 0) {
            hall[pos]--;
        }

        if (hall[pos] == 0) {
            if (forwardMoveBlocked()) {
                facingRight = !facingRight;
            }
            else if (facingRight) {
                pos++;
            }
            else {
                pos--;
            }
        }
    }

    public int clearHall() {
        int counter = 0;

        while (!hallIsClear()) {
            this.move();
            counter++;
        }

        return counter;
    }

    private boolean hallIsClear() {

        for (int i = 0; i < hall.length; i++) {
            if (hall[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] getHall() {
        return hall;
    }

    public int getPosition() {
        return pos;
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        Scanner scan = new Scanner(System.in);

        int delay = 1000;
        
        int moveCount = 0;
        
        boolean commandInputted = false;
        boolean singleMove = true;

        while (!robot.hallIsClear()) {
            System.out.println(robot);
            
            while (!commandInputted || singleMove) {
                String cmd = scan.nextLine();
                
                switch (cmd.toLowerCase()) {
                    case "run":
                        commandInputted = true;
                        singleMove = false;
                        break;

                    case "quick run":
                        delay = 100;
                        commandInputted = true;
                        singleMove = false;
                        break;
                        
                    case "single move" :
                        commandInputted = true;
                        singleMove = true;
                        break;
                        
                    default:
                        System.out.println("\nList of valid commands: run, quick run, and single move\n");
                        commandInputted = false;
                        singleMove = false;
                        break;
                }
                
                if (singleMove && commandInputted) break;
            }

            try {
                Thread.currentThread().sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            robot.move();
            moveCount++;
        }
        System.out.println(robot + "\n\n" + "It took " + moveCount + " moves");
    }

    public String toString() {

        System.out.print("\f");
        
        for (int i = 0; i < hall.length; i++) {
            System.out.print(hall[i] + "\t");
        }
        System.out.println("\n");

        for (int i = 0; i < hall.length; i++) {
            if ((i + 1) % (pos + 1) == 0) {
                System.out.print((facingRight) ? ">" : "<");
                break;
            }
            else {
                System.out.print("\t");
            }
        }
        System.out.println();
        return (hallIsClear()) ? "\nThe Hall Is Clear" : "";
    }
}
