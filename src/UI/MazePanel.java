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

// package UI;
// import GameLogic.GameEngine;
// import MazeMap.MazeManager;

// import java.awt.Color;
// import java.awt.Container;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.GridLayout;
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// public class MazeGameScreen extends JFrame {
// private String mazeFileName;
// private GameEngine gameEngine;
// private JPanel[][] cells;
// private boolean[][] maze;

// public MazeGameScreen(String mazeFileName) {
// this.mazeFileName = mazeFileName;
// setTitle("미로 게임 화면");
// setSize(800, 600);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setLayout(null);

// // 여기서 mazeFileName을 사용하여 미로를 로드하고 화면에 표시하는 로직을 추가합니다.
// // 예를 들어, MazeManager를 사용하여 미로를 로드할 수 있습니다.
// MazeManager manager = new MazeManager();
// this.maze = manager.loadMaze(mazeFileName);

// // 미로를 화면에 표시하는 로직을 추가합니다.
// // ...

// setLocationRelativeTo(null);
// setVisible(true);
// }

// public MazeGameScreen(boolean[][] maze) {
// this.maze = maze;
// this.cells = new JPanel[maze.length][maze[0].length];
// this.gameEngine = new GameEngine(maze, cells);

// setTitle("Maze Game");
// //setSize(800, 800);
// pack();
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setLocationRelativeTo(null);

// Container container = getContentPane();
// container.setLayout(new GridLayout(maze.length, maze[0].length));

// initializeCells(container);
// addKeyListener(new KeyAdapter() {
// @Override
// public void keyPressed(KeyEvent e) {
// switch (e.getKeyCode()) {
// case KeyEvent.VK_KP_UP:
// gameEngine.movePlayer(-1, 0);
// break;
// case KeyEvent.VK_KP_DOWN:
// gameEngine.movePlayer(1, 0);
// break;
// case KeyEvent.VK_KP_LEFT:
// gameEngine.movePlayer(0, -1);
// break;
// case KeyEvent.VK_KP_RIGHT:
// gameEngine.movePlayer(0, 1);
// break;
// }
// if (gameEngine.isAtExit()) {
// System.out.println("도착!");
// }
// }
// });

// setFocusable(true);
// setVisible(true);
// }

// private void initializeCells(Container container) {
// for (int i = 0; i < maze.length; i++) {
// for (int j = 0; j < maze[0].length; j++) {
// cells[i][j] = new JPanel();
// container.add(cells[i][j]);
// }
// }
// gameEngine.movePlayer(0, 0); // 초기 위치 업데이트
// }

// // public static void main(String[] args) {
// // boolean[][] maze = {
// // {true, true, false, true, true},
// // {false, true, false, true, false},
// // {true, true, true, true, true},
// // {true, false, false, false, true},
// // {true, true, true, true, true}
// // };
// // new MazeGameScreen(maze);
// // }

// public class MazePanel extends JPanel {
// private int[][] maze;
// private final int cellSize = 20;

// public MazePanel(int[][] maze) {
// this.maze = maze;
// setPreferredSize(new Dimension(maze[0].length * cellSize, maze.length *
// cellSize)); // panel의 크기 설정
// }

// @Override
// protected void paintComponent(Graphics g) {
// super.paintComponent(g);

// // 현재 패널 크기에 맞게 cellSize 계산
// int cellWidth = getWidth() / maze[0].length;
// int cellHeight = getHeight() / maze.length;
// int cellSize = Math.min(cellWidth, cellHeight); // 정사각형 유지

// for (int row = 0; row < maze.length; row++) {
// for (int col = 0; col < maze[row].length; col++) {
// if (maze[row][col] == 1) {
// g.setColor(Color.WHITE); // 벽
// } else {
// g.setColor(Color.BLACK); // 길
// }
// g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
// g.setColor(Color.BLACK); // 셀 경계선
// g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
// }
// }
// }
// }}
