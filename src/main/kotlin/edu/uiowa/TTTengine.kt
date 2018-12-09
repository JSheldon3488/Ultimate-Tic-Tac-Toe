package edu.uiowa


/*
This is the "model" for each individual TTT game inside the larger ultimate TTT game. This class acts as sort of a game
manager for the individual boards and essentially just handles the functionality of checking for winners and being able to
save the state of winners in the game.
 */
class TTTengine : Engine {
/* Properties */
    // The purpose off these methods is described in the interface
    override var board = Array<Array<String>>(3) { arrayOf<String>("E", "E", "E") }
    override var gameOver = false
    override var winner = "Nobody"


    // Specific to individual boards for animation purposes
    var winningCombo = arrayListOf<Pair<Int,Int>>()

/* Methods */
    // The overall purpose of the methods below are described in the interface

    override fun executeTurn(row: Int, column: Int, player : String) : Boolean {
        // Make sure game is not over before you allow a move in this board
        if (!gameOver) {
            // Make sure no one is already in this space before executing move
            if (board[row][column] == "E") {
                // All checks are satisfied make move and return that move successful
                board[row][column] = player
                checkForWinner()
                return true
            }
        }
        // Return that the move was not successful
        return false
    }


    override fun checkForWinner() : Boolean {
        when {
            checkHorzWinner() -> return true
            checkVertWinner() -> return true
            checkDiagonalWinner() -> return true
            checkForDraw() -> return true
            else -> return false
        }
    }

    override fun checkForDraw() : Boolean{
        if (board.sumBy { inner : Array<String> -> inner.count { it == "E" } } == 0 && winner == "Nobody") {
            winner = "Draw"
            gameOver = true
            return true
        }
        return false
    }



    // The ugly details of how to check for a winner in the array. Hid the complexity down here in the basement
    // Also these methods allow us to test each type of winning condition separately
    private fun checkDiagonalWinner() : Boolean {
        if (board[0][0] != "E") {
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                gameOver = true
                winner = board[0][0]

                //Save winning combo for animation purposes
                winningCombo.add(Pair(0, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(2, 2))

                return true
            }
        }
        if (board[2][0] != "E") {
            if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
                gameOver = true
                winner = board[2][0]

                //Save winning combo for animation purposes
                winningCombo.add(Pair(2, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(0, 2))

                return true
            }
        }
        return false
    }
    private fun checkVertWinner(): Boolean {
        for (column in 0..2) {
            if (board[0][column] != "E") {
                if (board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) {
                    gameOver = true
                    winner = board[0][column]

                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(0, column))
                    winningCombo.add(Pair(1, column))
                    winningCombo.add(Pair(2, column))

                    return true
        } } }
        return false
    }
    private fun checkHorzWinner(): Boolean {
        for (row in 0..2) {
            if (board[row][0] != "E") {
                if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
                    gameOver = true
                    winner = board[row][0]

                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(row, 0))
                    winningCombo.add(Pair(row, 1))
                    winningCombo.add(Pair(row, 2))

                    return true
        } } }
        return false
    }

}