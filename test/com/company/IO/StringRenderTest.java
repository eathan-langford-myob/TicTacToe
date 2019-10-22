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
    public void renderEmptyBoard() {
        Render boardRenderer = new StringRender();
        Board board = new Board(3);

        String actual = boardRenderer.renderBoard(board);
        String expected =
                        "      1     2     3\n" +
                        "      :     :     :   \n" +
                        "1  :  *     *     *\n" +
                        "                   \n" +
                        "2  :  *     *     *\n" +
                        "                   \n" +
                        "3  :  *     *     *";
        Assert.assertEquals(expected, actual);
    }
}
