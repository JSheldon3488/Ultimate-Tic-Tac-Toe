package edu.uiowa

import org.junit.Test

import org.junit.Assert.*
///Still need to redo tests.
// The logic of our game changed so we need to redo all these tests


/*
class SingleGameTTTtest {
    @Test
    fun checkInitialize() {
        val TTT = TTTengine()
        assertEquals("X", TTT.player1)
        assertEquals("O", TTT.player2)
        assertEquals("X", TTT.currentPlayer)
        assertEquals(false, TTT.gameOver)
        assertEquals("Nobody", TTT.winner)
        assertEquals(0, TTT.moves)
    }
    @Test
    fun executeTurn() {
        val TTT = TTTengine()
        TTT.executeTurn(0,0)
        assertEquals(TTT.board[0][0], "X")
        TTT.executeTurn(1,1)
        assertEquals(TTT.board[1][1], "O")
        TTT.executeTurn(1,1)
        assertEquals(TTT.board[1][1], "O")
    }
    @Test
    fun checkHorizontalWinner() {
        val TTTr1 = TTTengine()
        TTTr1.executeTurn(0,0)
        TTTr1.executeTurn(1,1)
        TTTr1.executeTurn(0,1)
        TTTr1.executeTurn(1,2)
        TTTr1.executeTurn(0,2)
        assertEquals(TTTr1.winner, "X")
        assertEquals(TTTr1.gameOver, true)
    }
    @Test
    fun checkVerticalWinner() {
        val TTT = TTTengine()
        TTT.executeTurn(1,1)
        TTT.executeTurn(0,0)
        TTT.executeTurn(1,2)
        TTT.executeTurn(1,0)
        TTT.executeTurn(2,1)
        TTT.executeTurn(2,0)
        assertEquals(TTT.winner, "O")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDiagonalLRWinner() {
        val TTT = TTTengine()
        TTT.executeTurn(0,0)
        TTT.executeTurn(0,1)
        TTT.executeTurn(1,1)
        TTT.executeTurn(1,0)
        TTT.executeTurn(2,2)
        assertEquals(TTT.winner, "X")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDiagonalRLWinner() {
        val TTT = TTTengine()
        TTT.executeTurn(0,2)
        TTT.executeTurn(0,1)
        TTT.executeTurn(1,1)
        TTT.executeTurn(1,0)
        TTT.executeTurn(2,0)
        assertEquals(TTT.winner, "X")
        assertEquals(TTT.gameOver, true)
    }
    @Test
    fun checkDraw() {
        val TTT = TTTengine()
        TTT.executeTurn(0,0)
        TTT.executeTurn(1,1)
        TTT.executeTurn(0,1)
        TTT.executeTurn(0,2)
        TTT.executeTurn(2,0)
        TTT.executeTurn(1,0)
        TTT.executeTurn(1,2)
        TTT.executeTurn(2,2)
        TTT.executeTurn(2,1)
        assertEquals("Draw", TTT.winner)
        assertEquals(TTT.gameOver, true)
    }
}*/
