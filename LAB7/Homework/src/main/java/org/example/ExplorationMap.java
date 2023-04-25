package org.example;

/**
 * An exploration map is a matrix of cells that can be visited by robots.
 */
public class ExplorationMap {
    private final Cell[][] matrix;
    private final int size;
    public ExplorationMap(int n) {
        this.matrix= new Cell[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                matrix[i][j]=new Cell();
            }
        }
        this.size=n;
    }

    public int getSize() {
        return matrix.length;
    }

    public boolean isFull(){
        for(int i=0;i<size;++i){
            for(int j=0;j<size;++j){
                if(matrix[i][j].getTokens().isEmpty())
                    return false;
            }
        }
        return true;
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].getTokens().isEmpty()) {
                System.out.println(robot.getName() + " failed to visit " + row + " " + col + "\n" + this.toString());
                return false;
            }
            matrix[row][col].getTokens().addAll(robot.getTokens());
            System.out.println(robot.getName() + " visited " + row + " " + col + "\n" + this.toString());
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        for (Cell[] cells : matrix) {
            for (Cell cell : cells) {
                matrixString.append(cell.getTokens().size());
                matrixString.append(" ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }

}