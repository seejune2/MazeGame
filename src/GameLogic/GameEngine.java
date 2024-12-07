package GameLogic;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class GameEngine extends JFrame {
    private final boolean[][] maze;
    private int playerX, playerY;
    private JPanel[][] cells;

    public GameEngine(boolean[][] maze, JPanel[][] cells) {
        this.maze = maze;
        this.cells = cells;
        this.playerX = 0;
        this.playerY = 0; // 시작점
        Container container = getContentPane();
        container.setLayout(new GridLayout(maze.length, maze[0].length));
        initializeCells();
        updatePlayerPosition();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        movePlayer(-1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        movePlayer(1, 0);
                        break;
                    case KeyEvent.VK_LEFT:
                        movePlayer(0, -1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        movePlayer(0, 1);
                        break;
                }
                if (isAtExit()) {
                    JOptionPane.showMessageDialog(null,"도착!");
                }

            }
        }); // 키보드 이벤트 처리
        setFocusable(true);
        requestFocusInWindow();

    } // 게임 엔진 생성자

    private void initializeCells() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                cells[row][col] = new JPanel();
                add(cells[row][col]);
            }
        }

    }

    public boolean isAtExit() {
        return playerX == maze.length - 2 && playerY == maze[0].length - 2; // 종료 조건
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    private void updatePlayerPosition() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (row == playerX && col == playerY) {
                    cells[row][col].setBackground(Color.BLUE); // 플레이어 위치
                } else if (maze[row][col]) {
                    cells[row][col].setBackground(Color.WHITE); // 길
                } else {
                    cells[row][col].setBackground(Color.BLACK); // 벽
                }
                if (row == 0 && col == 0) {
                    cells[row][col].setBackground(Color.RED); // 시작 지점
                }
                if (row == maze.length - 2 && col == maze[0].length - 2) {
                    cells[row][col].setBackground(Color.GREEN); // 종료 지점
                }

            }
        }
    }

    private boolean canMove(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y];
    }

    public void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        if (canMove(newX, newY)) {
            playerX = newX;
            playerY = newY;
            updatePlayerPosition();
        }
    }
}