package com.company;

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public int getY() {
        return y;
    }

    public int getX(){
        return x;
    }

    public Coordinates increment(Coordinates coordinate, String direction) {
        Coordinates incrementedCoordinates;
        switch (direction) {
            case "horizontal":
                incrementedCoordinates = new Coordinates(coordinate.getX()+1, coordinate.getY());
                return incrementedCoordinates;
            case "vertical":
                incrementedCoordinates = new Coordinates(coordinate.getX(), coordinate.getY()+1);
                return incrementedCoordinates;
            case "diagonalTopLeftToBottomRight":
                incrementedCoordinates = new Coordinates(coordinate.getX()+1, coordinate.getY()+1);
                return incrementedCoordinates;
            case "diagonalBottomLeftToTopRight":
                incrementedCoordinates = new Coordinates(coordinate.getX()+1, ( coordinate.getY()-1) >= 0 ? coordinate.getY()-1 : coordinate.getY());
                return incrementedCoordinates;
        }
        return coordinate;
    }
}
