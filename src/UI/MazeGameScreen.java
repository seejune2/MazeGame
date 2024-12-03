package UI;
import MazeMap.MazeManager;
import java.awt.*;
import javax.swing.*;

public class MazeGameScreen extends JFrame {
    
    public MazeGameScreen() {
        String filepath = "maze1.txt";


        // 저장된 미로 불러오기
        
        MazeManager mazeManager = new MazeManager();
        boolean[][] booleanMaze = mazeManager.loadMaze(filepath);
        // 메인 게임 화면 표시
            // boolean[][] 데이터를 int[][]로 변환
            int [][] maze = new int[booleanMaze.length][booleanMaze[0].length];
            for (int i = 0; i < booleanMaze.length; i++){
                for (int j = 0; j < booleanMaze[i].length; j++){
                    maze[i][j] = booleanMaze[i][j] ? 1 : 0;
                }
            }
        MazePanel mazePanel = new MazePanel(maze);
        add(mazePanel);
        // JFrame 생성 및 설정
        setTitle("미로 게임"); 
        //setSize(400, 300); // frame의 setSize 호출
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 동작 설정
        setLocationRelativeTo(null); // 화면 중앙 배치
        setVisible(true); // 창 표시

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                mazePanel.revalidate();
                mazePanel.repaint();
            }
        });
    }

public class MazePanel extends JPanel{
    private int[][] maze;
    private final int cellSize = 20;

    public MazePanel(int[][] maze){
        this.maze = maze;
        setPreferredSize(new Dimension(maze[0].length * cellSize, maze.length * cellSize)); // panel의 크기 설정
    }
    
    // 그리기
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
                    // 현재 패널 크기에 맞게 cellSize 계산
                    int cellWidth = getWidth() / maze[0].length;
                    int cellHeight = getHeight() / maze.length;
                    int cellSize = Math.min(cellWidth, cellHeight); // 정사각형 유지

        for (int row = 0; row < maze.length; row++){
            for (int col = 0; col < maze[row].length; col++){
                if (maze[row][col]== 1){
                    g.setColor(Color.WHITE); //벽
                } else {
                    g.setColor(Color.BLACK); // 길
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
               //g.setColor(Color.BLACK); // 셀 경계선
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
        
}
}
}


