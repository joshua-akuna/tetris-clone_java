//  responsible for generating various shapes of tetris pieces.
public class TetrisPieceFactory {
    /**
     *
     */
    public static final int[][][] BRICKS = {{
            {1, 1,  0},                             //  X   X
            {0, 1,  1},                             //       X   X
            {0, 0,  0}},{

            {1, 0,  0},                             //  X   X
            {1, 1,  0},                             //  X   X
            {0, 1,  0}},    {                      //       X

            {0, 1,  0},                             //       X
            {0, 1,  0},                             //       X
            {0, 1,  0}},    {                      //       X

            {1, 1,  0},                             //  X   X
            {1, 1,  0},                             //  X   X
            {0, 0,  0}},{

            {1, 1,  1},                             //  X   X   X
            {0, 1,  0},                             //       X
            {0, 0,  0}},{

            {1, 1,  1},                             //  X   X   X
            {1, 1,  1},                             //  X   X   X
            {0, 0,  0}},
    };
    public static TetrisPiece createRandomGamePiece(int xCoord, int yCoord) {
        int randomIndex = (int)(Math.random() * BRICKS.length);
        return new TetrisPiece(xCoord, yCoord, BRICKS[randomIndex]);
    }
}
