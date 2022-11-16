import java.util.ArrayList;
import java.util.List;

public class TetrisField {
    //specify 2 fields for the width and height of the field.
    private int height;
    private int width;
    //define the property for a 2-D matrix
    private int [][]matrix;

    public TetrisField (int width, int height){
        this.height = height;
        this.width = width;
        this.matrix = new int[height][width];
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public int[][] getMatrix() { return matrix; }

    //  Gets the value of a matrix cell.
    public int getValue(int x, int y){
        if(x >= 0 && x < height && y >= 0 && y < width)
            return matrix[x][y];

        return -1;
    }

    //  Sets the value of a matrix cell.
    public void setValue( int x, int y, int value){
        if(x >= 0 && x < height && y >= 0 && y < width)
            matrix[x][y] = value;
    }

    //The print() draws the current state of the Field instance on the screen
    public void print(){
        //Create a new matrix object reference where we will draw the current game state.
        int[][] canvas = matrix.clone();

        //Get the coordinates and matrix of the current game piece
        int top = Tetris.getInstance().getTetrisGamePiece().getY();
        int left = Tetris.getInstance().getTetrisGamePiece().getX();
        int[][] pieceMatrix = Tetris.getInstance().getTetrisGamePiece().getPieceMatrix();

        for(int i = 0; i < pieceMatrix.length; i++)
            for (int j = 0; j < pieceMatrix[i].length; j++){
                if(top + i >= height || left + j >= width) continue;
                if(pieceMatrix[i][j] == 1)
                    canvas[top+i][left+j] =2;
            }
        printBorder();
        printField(canvas);
        printBorder();
    }

    private void printField(int[][] field) {
        for(int i = 0; i < height; i++){
            for(int j = 0 ; j < width; j++){
                String sign = "";
                int val = getValue(i, j);

                if(val == 0) sign = "  .  ";
                else if(val  == 1) sign = "  X  ";
                else if(val == 2) sign = "  Y  ";
                else sign = "???";

                System.out.print(sign);
            }
            System.out.println("\n");
        }
    }

    //  Responsible for removing a completed row from the Field instance
    //  and higher rows move down.
    public void removeFullLines(){
        // a list to hold the incomplete lines in the Field matrix.
        List<int[]> lines = new ArrayList<>();

        //  Loop through the Tetris Field matrix and add all the incomplete
        //  lines to the lines list.
        for(int i = 0; i < matrix.length; i++){
            int count = 0;
            for(int j = 0; j < matrix[i].length; j++){
                count += getValue(i, j);
            }
            if(count != width) lines.add(0, matrix[i]);
        }
        //System.out.printf("List SIze: %d%n", lines.size());

        //  Check if the size of the list is less than the length of the matrix.
        //  If it is, fill empty space of the list with matrix of empty cells, where
        //  cell_value == 0;
        while(lines.size() < matrix.length){
            lines.add(new int[matrix[0].length]);
        }
        //System.out.printf("List SIze: %d%n", lines.size());
        //  Create a 2D matrix and copy the list entries into it.
        int[][] res = new int[height][width];

        for(int i = 0; i< res.length; i++){
            res[res.length-i-1] = lines.get(i);
        }
        matrix = res;
    }

     private void printBorder(){
        for(int i = 0; i < 60; i++) System.out.print("=");
        System.out.println();
    }
}
