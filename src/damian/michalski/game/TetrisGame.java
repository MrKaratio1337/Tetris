package damian.michalski.game;

import javax.swing.*;

public class TetrisGame extends JFrame {

    public TetrisGame(){
        initUI();
    }

    private void initUI(){
        Board board = new Board();
        add(board);
        setTitle("Tetris");
        setSize(300, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        TetrisGame game = new TetrisGame();
        game.setVisible(true);
    }
}
