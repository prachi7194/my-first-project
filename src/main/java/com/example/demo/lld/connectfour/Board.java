package com.example.demo.lld.connectfour;

public class Board {
    private static final int rows = 6;
    private static final int cols = 7;
    private final DiscColor[][] grid;
    public Board(){
        this.grid = new DiscColor[rows][cols];
    }

    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public boolean canPlace(int column){
        if(column < 0 && column >= cols){
            return false;
        }
        return grid[0][column] == null;
    }

    public int placeDisc(int column, DiscColor discColor){
        if(!canPlace(column)){
            return -1;
        }
        for(int i = rows-1;i>=0;i--){
            if(grid[i][column] == null){
                grid[i][column] = discColor;
                return i;
            }
        }
        return -1;
    }

    public boolean checkWin(int row, int column, DiscColor discColor){
        if(!inBounds(row, column) || grid[row][column] != discColor){
            return false;
        }
        int[][] directions = new int[][]{
                {0,1},
                {1,0},
                {1,1},
                {-1,1}
        };
        for(int[] dir :directions){
            int count = 1;
            count += countInDirection(row,column,dir[0],dir[1],discColor);
            count += countInDirection(row,column,-dir[0],-dir[1],discColor);
            if(count >= 4){
                return true;
            }


        }
        return false;
    }

    public boolean isFull(){
        for(int i = 0; i < cols;i++){
            if(grid[0][i] == null){
                return false;
            }
        }
        return true;
    }

    private int countInDirection(int row, int column, int dr, int dc, DiscColor discColor) {
        int count = 0;
        int r = row + dr;
        int c = row + dc;
        while(inBounds(r,c) && grid[r][c] == discColor){
            count = count + 1;
            r = r + dr;
            c = c + dc;
        }
        return count;
    }

    private boolean inBounds(int row, int column) {
        return row >= 0 && row <= rows && column >= 0 && column <= cols;
    }

}
