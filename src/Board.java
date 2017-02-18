/**
 * Created by jwinters on 2/18/17.
 */
public class Board {
    private int height;
    private int width;
    private Piece activePiece;
    private Position activePiecePosition;
    private boolean[][] representation;

    public Board() {
        this.height = 24;
        this.width = 10;
        this.representation = new boolean[width][height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Piece getActivePiece() {
        return activePiece;
    }

    public void setActivePiece(Piece activePiece) {
        this.activePiece = activePiece;
    }

    public void step() {
        if (activePiece == null) {
            setActivePiece(new StraightPiece());
            activePiecePosition = new Position(4,0);
        } else {
            activePiecePosition = new Position(activePiecePosition.getX(), activePiecePosition.getY() + 1);
        }
    }

    public void setActivePiecePosition(Position activePiecePosition) {
        this.activePiecePosition = activePiecePosition;
    }

    public Position getActivePiecePosition() {
        return activePiecePosition;
    }

    public void setOccupied(Position position) {
        representation[position.getX()][position.getY()] = true;
    }

    public boolean[][] getRepresentation() {
        return representation;
    }
}
