/**
 * Created by jwinters on 2/18/17.
 */
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object position) {
        if (position instanceof Position) {
            Position casted = (Position) position;
            return casted.getX() == x && casted.getY() == y;
        }
        return false;
    }
}
