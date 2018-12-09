package edu.uiowa

/*
A general design for an engine to run a Tic-Tac-Toe game. Supports functionality for everything you need to run a TTT Game.
 */
interface Engine {
/* Properties */
    // Used for storing the games current state and checking for winners
    var board : Array<Array<String>>
    // Simple flag to check if the game is won or a draw
    var gameOver : Boolean
    // Used to record the winner of games (individual and ultimate)
    var winner : String

/* Methods */
    // Handles execution of a players turn on every click or win (update board status, moves, and check for winner)
    fun executeTurn(row: Int, column: Int, player : String) : Boolean
    // Provides the ability to check for winners/draw after each move
    fun checkForWinner() : Boolean
    // Seperate Check for Draw function so that we can test it outside of checkForWinner
    fun checkForDraw() : Boolean
}