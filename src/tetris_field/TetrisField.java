package tetris_field;

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

    public int getHeight() {    return height;  }

    public int getWidth() { return width;   }

    public int[][] getMatrix() {    return matrix;  }

    //  Gets the value of a matrix cell.
    public int getValue(int x, int y){  return matrix[x][y];    }

    //  Sets the value of a matrix cell.
    public void setValue( int x, int y, int value){ matrix[x][y] = value; }

    //The print() draws the current state of the Field instance on the screen
    public void print(){
        for(int[] row : matrix){
            for(int col : row){System.out.print(col + "\t\t\t");}
            System.out.println();
        }
    }

    //  Responsible for removing a completed row from the Field instance
    //  and higher rows move down.
    public void removeFullLines(){
    }
}
