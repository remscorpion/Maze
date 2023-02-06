import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int size = 0;  // how big the map is
    public static char[][] map = new char[100][100];  // map info by saving as char

    /**
     * Main function
     */
    public static void main(String[] args) {
        // scan file
        scanFile("files/maze.txt");

        // set size
        StdDraw.setXscale(0, size);
        StdDraw.setYscale(0, size);

        draw();
    }


    /**
     * Draw the map
     */
    public static void draw() {
        // Search (draw) row by row
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size -1; j++) {
                if (map[i][j] == '#'  && map[i][j+1] == '#') {
                    StdDraw.line(getX(j), getY(i), getX(j+1), getY(i));
                }
            }
        }

        // Search (draw) column by column
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (map[i][j] == '#' && map[i+1][j] == '#') {
                    StdDraw.line(getX(j), getY(i), getX(j), getY(i+1));
                }
            }
        }
    }

    public static double getX(int j) {
        return j + 0.5;
    }

    /**
     * converse the index from index of array to the y coordinate of StdDraw.line()
     * @param i index of the array
     * @return y coordinate of StdDraw.line()
     */
    public static double getY(int i) {
        return -(i - size) - 0.5;
    }

    /**
     * Scan the file, storage info into map
     * @param f the file name (path)
     */
    public static void scanFile(String f) {
        try {
            // Initialize the Scanner
            Scanner scan = new Scanner(new File(f));

            // Scan the file line by line
            while (scan.hasNextLine()) {
                String t = scan.nextLine();  // t save the text of current line

                // put each character into map
                for (int i = 0; i < t.length(); i++) {
                    map[size][i] = t.charAt(i);
                }

                // increase size
                size++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}