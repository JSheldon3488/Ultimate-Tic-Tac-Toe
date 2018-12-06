package edu.uiowa

import org.junit.Test

import org.junit.Assert.*


internal class TTTengineTest {

    @Test
    fun executeGoodTurn() {
        val testEngine = TTTengine()
        assertEquals(true,testEngine.executeTurn(0,0, "X"))
        assertEquals("X", testEngine.board[0][0])
        assertEquals(1, testEngine.moves)
    }

    @Test
    fun executeBadTurn() {
        val testEngine = TTTengine()
        testEngine.executeTurn(0,0,"X")
        assertEquals(false, testEngine.executeTurn(0,0,"O"))
        //Make sure nothing got updated on the board
        assertEquals("X", testEngine.board[0][0])
        assertEquals(1, testEngine.moves)
    }

    @Test
    fun checkForDraw() {
        val testEngine = TTTengine()
        testEngine.executeTurn(0,0,"X")
        testEngine.executeTurn(0,1,"O")
        testEngine.executeTurn(0,2,"X")
        testEngine.executeTurn(1,0,"O")
        testEngine.executeTurn(1,1,"X")
        testEngine.executeTurn(1,2,"O")
        testEngine.executeTurn(2,0,"O")
        testEngine.executeTurn(2,1,"X")
        testEngine.executeTurn(2,2,"O")
        assertEquals("Draw", testEngine.winner)
        assertEquals(true, testEngine.gameOver)
    }

    @Test
    fun checkDiagonal() {
        val testEngine = TTTengine()
        testEngine.executeTurn(0,0,"X")
        testEngine.executeTurn(1,1,"X")
        testEngine.executeTurn(2,2,"X")
        assertEquals(true, testEngine.gameOver)
        assertEquals("X", testEngine.winner)
        assertEquals(3, testEngine.moves)

        val testEngine2 = TTTengine()
        testEngine2.executeTurn(0,2,"O")
        testEngine2.executeTurn(1,1,"O")
        testEngine2.executeTurn(2,0,"O")
        assertEquals(true, testEngine2.gameOver)
        assertEquals("O", testEngine2.winner)
        assertEquals(3, testEngine2.moves)
    }

    @Test
    fun checkVertical() {
        val testEngine = TTTengine()
        testEngine.executeTurn(0,0,"O")
        testEngine.executeTurn(1,0,"O")
        testEngine.executeTurn(2,0,"O")
        assertEquals(true, testEngine.gameOver)
        assertEquals("O", testEngine.winner)
        assertEquals(3, testEngine.moves)
    }

    @Test
    fun checkHorizontal() {
        val testEngine = TTTengine()
        testEngine.executeTurn(0,0,"X")
        testEngine.executeTurn(0,1,"X")
        testEngine.executeTurn(0,2,"X")
        assertEquals(true, testEngine.gameOver)
        assertEquals("X", testEngine.winner)
        assertEquals(3, testEngine.moves)
    }

}