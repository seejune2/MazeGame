package MazeMap;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Container;
import javax.swing.JPanel;
import MazeMap.MazeGenerator;
import java.awt.GridLayout;

public class MazeManager  {
    private static final String MAZE_DIRECTORY = "mazes";
    public JPanel[][] cells;
    public Container container;
    public int rows;
    public int cols;


    public MazeManager(Container container, int rows, int cols) {
        this.container = container;
        this.rows = rows;
        this.cols = cols;
        this.cells = new JPanel[rows][cols];
        File dir = new File(MAZE_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir(); // mazes 폴더 생성
        }
        
        initializeCells(rows, cols);
    }


    private void initializeCells(int rows, int cols) {
        container.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new JPanel();
                container.add(cells[i][j]);
            }
        }
    }

    public MazeManager() {
        this(new JPanel(), 40, 40);
        File dir = new File(MAZE_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir(); // mazes 폴더 생성
        }
    }

    public void saveMaze(boolean[][] maze, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MAZE_DIRECTORY + "/" + fileName))) {
            for (boolean[] row : maze) {
                for (boolean cell : row) {
                    writer.write(cell ? "0" : "1"); // 0 = 길, 1 = 벽
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean[][] loadMaze(String fileName) {
        List<boolean[]> mazeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MAZE_DIRECTORY + "/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean[] row = new boolean[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    row[i] = line.charAt(i) == '0'; // '0' -> 길, '1' -> 벽

                }
                paintCellAndRefresh(0, 0, Color.RED);
                paintCellAndRefresh(rows - 2, cols - 2, Color.GREEN);
                mazeList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mazeList.toArray(new boolean[0][]);
    }

    public String[] getSavedMazes() {
        File dir = new File(MAZE_DIRECTORY);
        return dir.list((d, name) -> name.endsWith(".txt"));
    }


     public void paintCellAndRefresh(int row, int col, Color color) {
         cells[row][col].setBackground(color);
         container.revalidate();
         container.repaint();
    }
}