package UI;
import javax.swing.*;
import MazeMap.MazeGenerator;
import MazeMap.MazeManager;

public class MainScreen extends JFrame {
    public MainScreen() {
        // 메인 화면 표시
        setTitle("미로 게임");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JPanel mainPanel = new JPanel(null);
        add(mainPanel); 

        
        JButton createMazeButton = new JButton("미로 생성");
        createMazeButton.setBounds(100, 50, 200, 50);
        createMazeButton.addActionListener(e -> {
            MazeGenerator generator = new MazeGenerator(21, 21, 20); // 미로 생성
            MazeManager manager = new MazeManager();
            manager.saveMaze(generator.getMaze(), "maze1.txt"); // 미로 저장
            JOptionPane.showMessageDialog(null, "미로 생성 완료");
            generator.dispose();

        });

        // 미로 list 버튼 추가
        JButton startMapListButton = new JButton("미로 목록");
        startMapListButton.setBounds(100, 100, 200, 50);
        startMapListButton.addActionListener(e -> {
            getContentPane().removeAll();
            JPanel Mazmap = new JPanel(null);
            Mazmap.setBounds(0, 0, 400, 300);
            setTitle("미로 목록");
            setLayout(null);

            MazeManager manager = new MazeManager();
            String[] savedMazes = manager.getSavedMazes();

            JList<String> mazeList = new JList<>(savedMazes);
            mazeList.setBounds(50, 50, 300, 100);
            add(mazeList);

            JButton backButton = new JButton("뒤로가기");
            backButton.setBounds(100, 200, 200, 50);
            backButton.addActionListener(e2 -> {
                getContentPane().remove(Mazmap);
                new MainScreen();
                setVisible(false);
                // revalidate();
                // repaint();

                
            });
            add(backButton);
            add(Mazmap);
            revalidate();
            repaint();
        });


        JButton startGameButton = new JButton("게임 시작");
        startGameButton.setBounds(100, 150, 200, 50);
        startGameButton.addActionListener(e -> {
            getContentPane().remove(mainPanel);
            new MazeSelectionScreen();
            setVisible(false);
        });
        add(startMapListButton);
        add(createMazeButton);
        add(startGameButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
