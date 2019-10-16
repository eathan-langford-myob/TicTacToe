package com.company.IO;

import com.company.Board;
import org.junit.*;

public class StringRenderTest {


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void renderBoard() {
        Render boardRenderer = new StringRender();
        Board board = new Board(3);

        String actual = boardRenderer.renderBoard(board);
        String expected = "*  ⁻  *  ⁻  *\nᶦ  ⁻  ᶦ  ⁻  ᶦ\n*  ⁻  *  ⁻  *\nᶦ  ⁻  ᶦ  ⁻  ᶦ\n*  ⁻  *  ⁻  *";
        Assert.assertEquals(expected, actual);
    }
}
