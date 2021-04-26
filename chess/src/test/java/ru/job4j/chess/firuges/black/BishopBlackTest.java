package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import org.junit.Test;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionIsUnchanged() {
        Cell expected = Cell.A1;
        Figure result = new BishopBlack(expected);
        assertThat(result.position(), is(expected));
    }

    @Test
    public void whenCopy() {
        Figure original = new BishopBlack(Cell.A1);
        Cell expected = Cell.G8;
        Figure result = original.copy(expected);
        assertThat(result.position(), is(expected));
    }

    @Test
    public void whenStartingPositionC1ThenWayD2E3F4G5() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] expected = {
                Cell.D2,
                Cell.E3,
                Cell.F4,
                Cell.G5
        };
        Cell[] result = bishop.way(Cell.G5);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenStartingPositionH8ThenWayG7F6E5D4C3B2A1() {
        Figure bishop = new BishopBlack(Cell.H8);
        Cell[] expected = {
                Cell.G7,
                Cell.F6,
                Cell.E5,
                Cell.D4,
                Cell.C3,
                Cell.B2,
                Cell.A1
        };
        Cell[] result = bishop.way(Cell.A1);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenStartingPositionD4ThenWayC5B6A7() {
        Figure bishop = new BishopBlack(Cell.D4);
        Cell[] expected = {
                Cell.C5,
                Cell.B6,
                Cell.A7
        };
        Cell[] result = bishop.way(Cell.A7);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenWayIsDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Assert.assertTrue(bishop.isDiagonal(Cell.A1, Cell.B2));
        Assert.assertTrue(bishop.isDiagonal(Cell.H8, Cell.A1));
        Assert.assertTrue(bishop.isDiagonal(Cell.B7, Cell.F3));
        Assert.assertTrue(bishop.isDiagonal(Cell.H4, Cell.D8));
    }

    @Test
    public void whenWayIsNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Assert.assertFalse(bishop.isDiagonal(Cell.A1, Cell.B3));
        Assert.assertFalse(bishop.isDiagonal(Cell.H8, Cell.A2));
        Assert.assertFalse(bishop.isDiagonal(Cell.B7, Cell.F7));
        Assert.assertFalse(bishop.isDiagonal(Cell.H4, Cell.H8));
    }
}