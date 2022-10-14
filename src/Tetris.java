import tetris_field.TetrisField;
import tetris_piece.TetrisPiece;

public class Tetris {
    public static void main(String[] args) {
        Tetris game = Tetris.getInstance();
        game.run();
    }

    private static Tetris instance = null;

    public static Tetris getInstance() {
        if (instance == null) instance = new Tetris();
        return instance;
    }

    //  a tetris property of type Field.
    private TetrisField tetrisField;
    //  a tetris property of type GamePiece.
    private TetrisPiece tetrisPiece;

    //  getter for the Field type property
    public TetrisField getTetrisField() {
        return tetrisField;
    }

    //  getter for the GamePiece type property.
    public TetrisPiece getTetrisGamePiece() {
        return tetrisPiece;
    }

    //  responsible for the entire game.
    public void run() {
        tetrisPiece = TetrisPieceFactory.createRandomGamePiece(0, 0);
    }

    //  responsible for a single game piece step
    public void step() {
    }
}
