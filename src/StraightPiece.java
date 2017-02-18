/**
 * Created by jwinters on 2/18/17.
 */
public class StraightPiece extends Piece {
    @Override
    public boolean[][] getRepresentation() {
        return new boolean[][]{
                { true, false },
                { true, false },
                { true, false },
                { true, false },
        };
    }
}
