import java.awt.event.KeyEvent;

public class Tetris {
    public static void main(String[] args) throws InterruptedException {
        Tetris game = Tetris.getInstance();
        game.tester();
    }
    private static Tetris instance = null;
    public static Tetris getInstance() {
        if (instance == null) instance = new Tetris(10, 20);
        return instance;
    }
    private TetrisField tetrisField;     //  a tetris property of type Field.
    private TetrisPiece tetrisPiece;     //  a tetris property of type GamePiece.
    public TetrisField getTetrisField() {
        return tetrisField;
    }    //  getter for the Field type property
    public TetrisPiece getTetrisGamePiece() {
        return tetrisPiece;
    }   //  getter for the GamePiece type property.
    private  boolean isGameOver;    //Indicates when the game is over

    public Tetris(int width, int height){
        tetrisField = new TetrisField(width, height);
        tetrisPiece = TetrisPieceFactory.createRandomGamePiece(width/2-1, 0);
    }

    public void run() throws InterruptedException {  //  responsible for the entire game.
        //  Create a KeyboardObserver instance and start it.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        Thread keyboardObserverThread = new Thread(keyboardObserver);
        keyboardObserverThread.start();

        //  Create the first game piece in the middle at the top
        //  x = half of the width, y = 0
        tetrisPiece = TetrisPieceFactory
                .createRandomGamePiece(tetrisField.getWidth()/2, 0);
        isGameOver = false;     //  Sets the initial value of isGameOver property to false;
        /**
         * The program's main loop.
         * This is where all the important actions happen.
         */
        while (!isGameOver){
            if(keyboardObserver.hasKeyEvents()){    //  Checks if the KeyEvents Queue is not empty.
                KeyEvent e = keyboardObserver.getEventFromTop();    //  Gets the KeyEvent from the top.

                if(e.getKeyChar() == 'q') return; //    Exit game if 'q' is pressed.

                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT -> {
                        tetrisPiece.left();
                        break;
                    }
                    case KeyEvent.VK_RIGHT -> {
                        tetrisPiece.right();
                        break;
                    }
                    case  KeyEvent.VK_DOWN -> {
                        tetrisPiece.dropToBottom();
                        break;
                    }
                    case KeyEvent.VK_SPACE-> {
                        tetrisPiece.rotate();
                        break;
                    }
                }
            }
            step(); //  Executes the step() method
            tetrisField.print();    //  Displays the Tetris Field.
            Thread.sleep(300); //  Pause for 300ms/0.3s.
        }
        System.out.println("Game Over");    //Displays Game Over
    }

    /*
     *  One step of the game.
     */
    public void step() {     //  responsible for a single game piece step
        // Drop the piece a step lower.
        getTetrisGamePiece().down();
        //  If the current piece can't be placed in the current location:
        if(!getTetrisGamePiece().isCurrentPositionAvailable()) {
            //  Put it back
            getTetrisGamePiece().up();
            //  Land it
            getTetrisGamePiece().land();
            //  If the game piece lands at the very top, then it's GAME OVER
            if(getTetrisGamePiece().getY() >= tetrisField.getHeight())
                isGameOver = true;
            //  Remove the completed lines
            tetrisField.removeFullLines();
            //  Create a new game piece
            this.tetrisPiece = TetrisPieceFactory
                    .createRandomGamePiece(tetrisField.getWidth()/2, 0);
        }
    }

    private void printField(){tetrisField.print();}

    void tester () throws InterruptedException {
        int[][] mat = tetrisField.getMatrix();

        for(int i = tetrisField.getHeight()/2; i < tetrisField.getHeight(); i++){
            for(int j = 0; j < tetrisField.getWidth(); j++){
                tetrisField.setValue(i, j, 1);
            }
        }

        for(int i = 0; i < mat.length/2; i++){
            for(int j = 0; j < i; j++){
                tetrisField.setValue(i, j, 1);
            }
        }
        printField();
        tetrisField.removeFullLines();
        Thread.sleep(5000);
        printField();
    }
}