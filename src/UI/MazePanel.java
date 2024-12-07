package UI;

import GameLogic.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazePanel extends JPanel implements KeyListener {
    private boolean[][] maze;
    private final int cellSize = 20;

    public MazePanel(boolean[][] maze) {
        this.maze = maze;
        setPreferredSize(new Dimension(maze[0].length * cellSize, maze.length * cellSize)); // panel의 크기 설정
    }

    // 그리기
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 현재 패널 크기에 맞게 cellSize 계산
        int cellWidth = getWidth() / maze[0].length;
        int cellHeight = getHeight() / maze.length;
        int cellSize = Math.min(cellWidth, cellHeight); // 정사각형 유지

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == true) {
                    g.setColor(Color.WHITE); // 벽
                } else {
                    g.setColor(Color.BLACK); // 길
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                // g.setColor(Color.BLACK); // 셀 경계선
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
        // GameEngine gameEngine = new GameEngine(maze, new
        // JPanel[maze.length][maze[0].length]);
        // add(gameEngine);
        // gameEngine.movePlayer(0, 0); // 초기 위치 업데이트
        // gameEngine.isAtExit();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 키 입력 처리 로직
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 키 입력 처리 로직
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 키 입력 처리 로직
    }

}