package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class CoordinatesTest {
    Coordinates coordinates;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldReturnIntegerRepresentingXCoordinate() {
        coordinates = new Coordinates(2,0);
        int actual = coordinates.getX();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIntegerRepresentingYCoordinate() {
        coordinates = new Coordinates(0,2);
        int actual = coordinates.getY();
        int expected = 2;

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinatesHorizontal() {
        coordinates = new Coordinates(0,0);
        Coordinates actual = coordinates.increment(coordinates, "horizontal");
        Coordinates expected = new Coordinates(1,0);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinatesVertical() {
        coordinates = new Coordinates(0,0);
        Coordinates actual = coordinates.increment(coordinates, "vertical");
        Coordinates expected = new Coordinates(0,1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinatesDiagonalTopLeftToBottomRight() {
        coordinates = new Coordinates(0,0);
        Coordinates actual = coordinates.increment(coordinates, "diagonalTopLeftToBottomRight");
        Coordinates expected = new Coordinates(1,1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinatesDiagonalBottomLeftToTopRight() {
        coordinates = new Coordinates(0,2);
        Coordinates actual = coordinates.increment(coordinates, "diagonalBottomLeftToTopRight");
        Coordinates expected = new Coordinates(1,1);

        assertEquals(expected, actual);
    }
}
