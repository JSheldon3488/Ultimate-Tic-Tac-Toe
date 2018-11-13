package edu.uiowa

import org.junit.Test

import org.junit.Assert.*

class TicTacToeTest {
    @Test
    fun checkInitialize() {
        val TTT = TicTacToe()
        assertEquals("X", TTT.player1)
        assertEquals("O", TTT.player2)
        assertEquals("X", TTT.currentPlayer)
        assertEquals(false, TTT.gameOver)
        assertEquals("Nobody", TTT.winner)
        assertEquals(0, TTT.moves)
    }
    @Test
    fun makeMove() {
        val TTT = TicTacToe()
        TTT.makeMove(0,0)
        assertEquals(TTT.board[0][0], "X")
        TTT.makeMove(1,1)
        assertEquals(TTT.board[1][1], "O")
        TTT.makeMove(1,1)
        assertEquals(TTT.board[1][1], "O")
    }
    @Test
    fun checkHorizontalWinner() {
        val TTTr1 = TicTacToe()
        TTTr1.makeMove(0,0)
        TTTr1.makeMove(1,1)
        TTTr1.makeMove(0,1)
        TTTr1.makeMove(1,2)
        TTTr1.makeMove(0,2)
        assertEquals(TTTr1.winner, "X")
        assertEquals(TTTr1.gameOver, true)
    }
    @Test
    fun checkVerticalWinner() {
        val TTT = TicTacToe()
        TTT.makeMove(1,1)
        TTT.makeMove(0,0)
        TTT.makeMove(1,2)
        TTT.makeMove(1,0)
        TTT.makeMove(2,1)
        TTT.makeMove(2,0)
        assertEquals(TTT.winner, "O")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDiagonalLRWinner() {
        val TTT = TicTacToe()
        TTT.makeMove(0,0)
        TTT.makeMove(0,1)
        TTT.makeMove(1,1)
        TTT.makeMove(1,0)
        TTT.makeMove(2,2)
        assertEquals(TTT.winner, "X")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDiagonalRLWinner() {
        val TTT = TicTacToe()
        TTT.makeMove(0,2)
        TTT.makeMove(0,1)
        TTT.makeMove(1,1)
        TTT.makeMove(1,0)
        TTT.makeMove(2,0)
        assertEquals(TTT.winner, "X")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDraw() {
        val TTT = TicTacToe()
        TTT.makeMove(0,0)
        TTT.makeMove(1,1)
        TTT.makeMove(0,1)
        TTT.makeMove(0,2)
        TTT.makeMove(2,0)
        TTT.makeMove(1,0)
        TTT.makeMove(1,2)
        TTT.makeMove(2,2)
        TTT.makeMove(2,1)
        assertEquals(TTT.winner, "Draw")
        assertEquals(TTT.gameOver, true)
    }
}