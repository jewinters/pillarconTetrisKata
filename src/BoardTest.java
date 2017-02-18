import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jwinters on 2/18/17.
 */
public class BoardTest {

    @Test
    public void whenABoardIsCreatedItHasAWidth() {
        Board subject = new Board();

        assertEquals(10, subject.getWidth());
    }

    @Test
    public void whenABoardIsCreatedItHasAHeight() {
        Board subject = new Board();

        assertEquals(24, subject.getHeight());
    }

    @Test
    public void whenNoActivePieceExistsThenStepCreatesANewActivePiece() {
        Board subject = new Board();

        subject.setActivePiece(null);
        subject.step();

        assertNotNull(subject.getActivePiece());
    }

    @Test
    public void whenActivePieceExistsThenStepDoesNotCreateANewActivePiece() {
        Board subject = new Board();
        Piece expectedPiece = new MockPiece();
        subject.setActivePiece(expectedPiece);

        subject.step();

        assertSame(expectedPiece, subject.getActivePiece());
    }

    @Test
    public void whenNoActivePieceExistsThenStepSetsTheActivePiecePositionToMiddleTopOfTheBoard() {
        Board subject = new Board();

        subject.setActivePiece(null);

        subject.step();

        Position expectedPosition = new Position(4, 0);
        assertEquals(expectedPosition, subject.getActivePiecePosition());
    }

    @Test
    public void whenStepIsCalledActivePieceAdvancesVerticallyByOneStep() {
        Board subject = new Board();

        subject.setActivePiece(new MockPiece());
        subject.setActivePiecePosition(new Position(1, 4));

        subject.step();

        assertEquals(subject.getActivePiecePosition().getY(), 5);
    }

    @Test
    public void whenStepIsCalledIfActivePieceCollidesWithOccupiedSpaceActivePieceIsNull() {
        Board subject = new Board();

        subject.setOccupied(new Position(0,23));
        subject.setActivePiece(new MockPiece());
        subject.setActivePiecePosition(new Position(0, 22));

        subject.step();

        assertNull(subject.getActivePiece());
    }

    private class MockPiece extends Piece {

        @Override
        public boolean[][] getRepresentation() {
            return new boolean[][]{
                    { true }
            };
        }
    }
}