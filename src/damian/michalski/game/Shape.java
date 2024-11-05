package damian.michalski.game;

import java.awt.*;
import java.util.Random;

public class Shape {

    private static final int[][][] SHAPES = {
            {{0,0}, {1,0}, {0,1}}, // O
            {{0,0}, {1,0}, {2,0}, {3,0}}, // I
            {{0,0}, {1,0}, {2,0}, {2,1}}, // L
            {{0,1}, {1,1}, {2,1}, {2,0}}, // J
            {{0,0}, {1,0}, {1,1}, {2,1}}, // S
            {{1,0}, {2,0}, {0,1}, {1,1}}, // Z
            {{1,0}, {0,1}, {1,1}, {2,1}} // T
    };

    private static final Color[] COLORS = {
        Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.ORANGE
    };

    public static int[][] getRandomShape(){
        Random rand = new Random();
        return SHAPES[rand.nextInt(SHAPES.length)];
    }

    public static Color getRandomColor(){
        Random rand = new Random();
        return COLORS[rand.nextInt(COLORS.length)];
    }
}
