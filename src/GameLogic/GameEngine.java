package GameLogic;

import java.util.Scanner;

public class GameEngine {
    private final boolean[][] maze;
    private int playerX, playerY;

    public GameEngine(boolean[][] maze) {
        this.maze = maze;
        this.playerX = 0;
        this.playerY = 0; // 시작점
    }

    public void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;

        if (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY]) {
            playerX = newX;
            playerY = newY;
        }
    }

    public boolean isAtExit() {
        return playerX == maze.length - 1 && playerY == maze[0].length - 1; // 종료 조건
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void startGame() {
        // TODO Auto-generated method stub
            while (true) {
                printMaze();
                if (isAtExit()) {
                    System.out.println("도착!");
                    break;
                }
                movePlayer();
            }
        
    }

    public void printMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (row == playerX && col == playerY) {
                    System.out.print("P ");
                } else {
                    System.out.print(maze[row][col] ? "1 " : "0 ");
                }
            }
            System.out.println();
        }
    }

    public void movePlayer() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("이동 방향을 입력하세요 (상: w, 하: s, 좌: a, 우: d): ");
            String direction = scanner.next();
            int dx = 0, dy = 0;
            switch (direction) {
                case "w":
                    dx = -1;
                    break;
                case "s":
                    dx = 1;
                    break;
                case "a":
                    dy = -1;
                    break;
                case "d":
                    dy = 1;
                    break;
            }
            if (canMove(dx, dy)) {
                playerX += dx;
                playerY += dy;
            }
        }
    }
    public boolean canMove(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        return newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY];
    }

    

}
