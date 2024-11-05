package damian.michalski.game;

import java.awt.*;

public class TetrisPiece {

    private int[][] blocks;
    private Color color;

    public TetrisPiece(){
        initPiece();
    }

    private void initPiece(){
        blocks = Shape.getRandomShape();
        color = Shape.getRandomColor();
    }

    public int[][] getBlocks(){
        return blocks;
    }

    public Color getColor() {
        return color;
    }

    public void moveLeft(){
        for(int[] block : blocks){
            block[0]--;
        }
    }

    public void moveRight(){
        for(int[] block : blocks){
            block[0]++;
        }
    }

    public void moveDown(){
        for(int[] block : blocks){
            block[1]++;
        }
    }

    public void rotate(){
        for(int i = 0; i < blocks.length; i++){
            int x = blocks[i][0];
            int y = blocks[i][1];
            blocks[i][0] = -y;
            blocks[i][1] = x;
        }
    }
}
