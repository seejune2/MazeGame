package UI;
import MazeMap.MazeManager;
import javax.swing.*;

import GameLogic.GameEngine;

public class MazeGameScreen extends JFrame {
    

    public MazeGameScreen(boolean[][] maze) {
        JPanel[][] cells = new JPanel[maze.length][maze[0].length];
        // 미로 게임 화면 생성
        // 미로 데이터를 받아서 화면에 표시
        // 미로 데이터는 boolean[][]로 주어지며, true는 벽, false는 길을 나타냄
        String filepath = "maze1.txt";

        // 저장된 미로 불러오기
        MazeManager mazeManager = new MazeManager();
        boolean[][] booleanMaze = mazeManager.loadMaze(filepath);
        GameEngine gameEngine = new GameEngine(maze, cells);
        // 메인 게임 화면 표시
        MazePanel mazePanel = new MazePanel(booleanMaze);
        gameEngine.addKeyListener(mazePanel);
        gameEngine.setTitle("Maze Game");
        gameEngine.pack();
        gameEngine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameEngine.setLocationRelativeTo(null);
        gameEngine.setLayout(null);
        gameEngine.setFocusable(true);
        gameEngine.requestFocusInWindow();
        gameEngine.setVisible(true);
        add(mazePanel);

        // JFrame 생성 및 설정
        // setTitle("미로 게임"); 
        // pack();
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 동작 설정
        // setLocationRelativeTo(null); // 화면 중앙 배치
        // setVisible(true); // 창 표시        
        // addComponentListener(new java.awt.event.ComponentAdapter() {
        //     @Override
        //     public void componentResized(java.awt.event.ComponentEvent e) {
        //         mazePanel.revalidate();
        //         mazePanel.repaint();
        //     }
        
    
    };
    }