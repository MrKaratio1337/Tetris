package damian.michalski.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;
    private final int CELL_SIZE = 30;
    private TetrisPiece currentPiece;
    private Timer timer;

    public Board(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BOARD_WIDTH * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE));
        addKeyListener(new TAdapter());
        timer = new Timer(400, this);
        startGame();
    }

    private void startGame(){
        currentPiece = new TetrisPiece();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePieceDown();
        repaint();
    }

    private void movePieceDown(){
        currentPiece.moveDown();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPiece(g);
    }

    private void drawPiece(Graphics g){
        g.setColor(currentPiece.getColor());
        for(int[] block : currentPiece.getBlocks()){
            int x = block[0] * CELL_SIZE;
            int y = block[1] * CELL_SIZE;
            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_LEFT:
                    currentPiece.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    currentPiece.moveRight();
                    break;
                case KeyEvent.VK_DOWN:
                    movePieceDown();
                    break;
                case KeyEvent.VK_UP:
                    currentPiece.rotate();
                    break;
            }
            repaint();
        }
    }
}
