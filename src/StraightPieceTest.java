import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwinters on 2/18/17.
 */
public class StraightPieceTest {
    @Test
    public void getRepresentationReturnsATwoDimensionalArrayRepresentation() {
        StraightPiece subject = new StraightPiece();

        boolean[][] expected = {
                { true, false },
                { true, false },
                { true, false },
                { true, false },
        };

        assertArrayEquals(expected, subject.getRepresentation());
    }
}