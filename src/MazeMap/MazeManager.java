package MazeMap;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MazeManager {
    private static final String MAZE_DIRECTORY = "mazes";

    public MazeManager() {
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
}
