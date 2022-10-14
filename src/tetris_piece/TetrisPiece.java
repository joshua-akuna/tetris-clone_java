package tetris_piece;

public class TetrisPiece {
    //  define 2 properties for the coordinates of the game piece instance.
    private int xCoord, yCoord;
    //  define a property for the shape of the game piece instance as a 3x3 array.
    //1 - cell is occupied, 0 - cell is empty.
    private int[][] pieceMatrix;

    //  class constructor
    public TetrisPiece(int xCoord, int yCoord, int[][] pieceMatrix) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.pieceMatrix = pieceMatrix;
    }

    //  Returns the x-coordinates of the game piece instance.
    public int getX() {
        return xCoord;
    }

    //  Returns the y-coordinates of the game piece instance.
    public int getY() {
        return yCoord;
    }

    //  Returns the matrix representing the current game piece instance.
    public int[][] getPieceMatrix() {
        return pieceMatrix;
    }

    //  moves the game piece to the left.
    public void left() {
    }

    //  moves the game piece to the right.
    public void right() {
    }

    //  moves the game piece down.
    public void down() {
    }

    //  moves the game piece up.
    public void up() {
    }

    //  rotates the game piece about its diagonal
    public void rotate() {
    }

    //  Drops the game piece to the bottom
    public void dropToBottom() {
    }

    //  Invoked when the current game piece reaches the bottom
    //  or lands on another game piece.
    public void land() {
    }

    //  checks if the game piece can be placed in the current position or not.
    public boolean isCurrentPositionAvailable() {
        return true;
    }
}
