package UI;
import javax.swing.*;
import MazeMap.MazeManager;
import GameLogic.GameEngine;
public class MazeSelectionScreen extends JFrame {


    public MazeSelectionScreen() {
        setTitle("미로 선택 화면");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        MazeManager manager = new MazeManager();
        String[] savedMazes = manager.getSavedMazes();

        JList<String> mazeList = new JList<>(savedMazes);
        mazeList.setBounds(50, 50, 300, 100);
        add(mazeList);

        JButton startButton = new JButton("게임 시작");
        startButton.setBounds(100, 200, 200, 50);
        startButton.addActionListener(e -> {
            String selectedMaze = mazeList.getSelectedValue();
            if (selectedMaze != null) {
                // boolean[][] maze = manager.loadMaze(selectedMaze);
                getContentPane().removeAll();
                new MazeGameScreen();
                setVisible(false);
                // GameEngine engine = new GameEngine(maze);
                // engine.startGame();
                // 게임 시작 로직 (별도의 화면에서 처리)
            }
            
        }
        
        );

        add(startButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
 
}


