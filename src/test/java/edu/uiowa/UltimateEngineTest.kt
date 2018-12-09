package edu.uiowa

import org.junit.Test

import org.junit.Assert.*

internal class UltimateEngineTest {

    @Test
    fun changePlayer() {
        val testEngine = UltimateEngine()
        assertEquals(testEngine.player1, testEngine.currentPlayer)
        testEngine.changePlayer()
        assertEquals(testEngine.player2, testEngine.currentPlayer)
        testEngine.changePlayer()
        assertEquals(testEngine.player1, testEngine.currentPlayer)
    }

    @Test
    fun setBoardWinner() {
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0, testEngine.player1)
        assertEquals(testEngine.player1, testEngine.board[0][0])
        assertEquals(false, testEngine.gameOver)
        testEngine.executeTurn(1,1, testEngine.player2)
        assertEquals(testEngine.player2, testEngine.board[1][1])
        assertEquals(false, testEngine.gameOver)
        testEngine.executeTurn(2,2, "Draw")
        assertEquals("Draw", testEngine.board[2][2])
        assertEquals(false, testEngine.gameOver)
    }

    @Test
    fun checkForWinner() {
        val testEngine = UltimateEngine()
        assertEquals(false, testEngine.checkForWinner())
        testEngine.executeTurn(0,0,testEngine.player1)
        testEngine.executeTurn(0,1, testEngine.player1)
        assertEquals(false, testEngine.checkForWinner())
        testEngine.executeTurn(0,2, testEngine.player1)
        assertEquals(true, testEngine.checkForWinner())
    }
    @Test
    fun checkForDraw() {
        val testEngine = UltimateEngine()
        assertEquals(false, testEngine.checkForDraw())
        testEngine.executeTurn(0,0,"X")
        testEngine.executeTurn(0,1,"O")
        testEngine.executeTurn(0,2, "X")
        testEngine.executeTurn(1,0,"O")
        testEngine.executeTurn(1,1,"X")
        testEngine.executeTurn(1,2, "O")
        testEngine.executeTurn(2,0,"O")
        testEngine.executeTurn(2,1,"X")
        testEngine.executeTurn(2,2, "O")
        assertEquals(true, testEngine.gameOver)
        assertEquals("Draw", testEngine.winner)
    }

    @Test
    fun checkHorzWinner() {
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0,testEngine.player2)
        testEngine.executeTurn(0,1,testEngine.player2)
        testEngine.executeTurn(0,2, testEngine.player2)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player2, testEngine.winner)
    }

    @Test
    fun checkVertWinner() {
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0,testEngine.player1)
        testEngine.executeTurn(1,0,testEngine.player1)
        testEngine.executeTurn(2,0, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player1, testEngine.winner)
    }

    @Test
    fun checkDiagonalWinner() {
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0,testEngine.player1)
        testEngine.executeTurn(1,1,testEngine.player1)
        testEngine.executeTurn(2,2, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player1, testEngine.winner)

        val testEngine2 = UltimateEngine()
        testEngine2.executeTurn(0,2,testEngine2.player2)
        testEngine2.executeTurn(1,1,testEngine2.player2)
        testEngine2.executeTurn(2,0, testEngine2.player2)
        assertEquals(true, testEngine2.gameOver)
        assertEquals(testEngine2.player2, testEngine2.winner)
    }

    @Test
    fun gameOverStatus() {
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0, testEngine.player1)
        assertEquals(false, testEngine.gameOver)
        testEngine.executeTurn(0,1, testEngine.player1)
        testEngine.executeTurn(0,2, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
    }
    @Test
    fun drawCheckBug(){
        val testEngine = UltimateEngine()
        testEngine.executeTurn(0,0,"Draw")
        testEngine.executeTurn(0,1,"Draw")
        testEngine.executeTurn(0,2, "Draw")
        //Test fix on 3 draws in a row ending game early bug
        assertEquals(false, testEngine.gameOver)
    }

}