package chichikov.antroute.core;

/**
 * Position
 *
 * @author Anatoly Chichikov (30.06.2013)
 */
public class Position implements Positionable {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Positionable o) {
        Position position = (Position) o;
        if (this.x < position.x) return -1;
        if (this.x > position.x) return 1;
        if (this.y < position.y) return -1;
        if (this.y > position.y) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "\nPosition { x = " + x + ", y = " + y + " }";
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
