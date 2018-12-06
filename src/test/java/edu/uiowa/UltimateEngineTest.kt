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
        assertEquals(1, testEngine.moves)
        testEngine.changePlayer()
        assertEquals(testEngine.player1, testEngine.currentPlayer)
        assertEquals(2, testEngine.moves)
    }

    @Test
    fun setBoardWinner() {
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0, testEngine.player1)
        assertEquals(testEngine.player1, testEngine.ultimateBoard[0][0])
        assertEquals(1, testEngine.finishedBoards)
        assertEquals(false, testEngine.gameOver)
        testEngine.setBoardWinner(1,1, testEngine.player2)
        assertEquals(testEngine.player2, testEngine.ultimateBoard[1][1])
        assertEquals(2, testEngine.finishedBoards)
        assertEquals(false, testEngine.gameOver)
        testEngine.setBoardWinner(2,2, "Draw")
        assertEquals("Draw", testEngine.ultimateBoard[2][2])
        assertEquals(3,testEngine.finishedBoards)
        assertEquals(false, testEngine.gameOver)
    }

    @Test
    fun checkForWinner() {
        val testEngine = UltimateEngine()
        assertEquals(false, testEngine.checkForWinner())
        testEngine.setBoardWinner(0,0,testEngine.player1)
        testEngine.setBoardWinner(0,1, testEngine.player1)
        assertEquals(false, testEngine.checkForWinner())
        testEngine.setBoardWinner(0,2, testEngine.player1)
        assertEquals(true, testEngine.checkForWinner())
    }
    @Test
    fun checkForDraw() {
        val testEngine = UltimateEngine()
        assertEquals(false, testEngine.checkForDraw())
        testEngine.setBoardWinner(0,0,"Draw")
        testEngine.setBoardWinner(0,1,"Draw")
        testEngine.setBoardWinner(0,2, "Draw")
        testEngine.setBoardWinner(1,0,"Draw")
        testEngine.setBoardWinner(1,1,"Draw")
        testEngine.setBoardWinner(1,2, "Draw")
        testEngine.setBoardWinner(2,0,"Draw")
        testEngine.setBoardWinner(2,1,"Draw")
        testEngine.setBoardWinner(2,2, "Draw")
        assertEquals(true, testEngine.gameOver)
        assertEquals("Draw", testEngine.winner)
    }

    @Test
    fun checkHorzWinner() {
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0,testEngine.player2)
        testEngine.setBoardWinner(0,1,testEngine.player2)
        testEngine.setBoardWinner(0,2, testEngine.player2)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player2, testEngine.winner)
    }

    @Test
    fun checkVertWinner() {
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0,testEngine.player1)
        testEngine.setBoardWinner(1,0,testEngine.player1)
        testEngine.setBoardWinner(2,0, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player1, testEngine.winner)
    }

    @Test
    fun checkDiagonalWinner() {
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0,testEngine.player1)
        testEngine.setBoardWinner(1,1,testEngine.player1)
        testEngine.setBoardWinner(2,2, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
        assertEquals(testEngine.player1, testEngine.winner)

        val testEngine2 = UltimateEngine()
        testEngine2.setBoardWinner(0,2,testEngine2.player2)
        testEngine2.setBoardWinner(1,1,testEngine2.player2)
        testEngine2.setBoardWinner(2,0, testEngine2.player2)
        assertEquals(true, testEngine2.gameOver)
        assertEquals(testEngine2.player2, testEngine2.winner)
    }

    @Test
    fun gameOverStatus() {
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0, testEngine.player1)
        assertEquals(false, testEngine.gameOver)
        testEngine.setBoardWinner(0,1, testEngine.player1)
        testEngine.setBoardWinner(0,2, testEngine.player1)
        assertEquals(true, testEngine.gameOver)
    }
    @Test
    fun drawCheckBug(){
        val testEngine = UltimateEngine()
        testEngine.setBoardWinner(0,0,"Draw")
        testEngine.setBoardWinner(0,1,"Draw")
        testEngine.setBoardWinner(0,2, "Draw")
        //Test fix on 3 draws in a row ending game early bug
        assertEquals(false, testEngine.gameOver)
    }

}