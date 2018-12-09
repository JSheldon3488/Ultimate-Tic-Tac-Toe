package edu.uiowa


/*
This class acts as the "model" for the ultimate TTT game. This class supports functionality for checking for winners and
saving the state of the game as well as functionality for changing players in the game. This is essentially a "game manager"
for the unltimate TTT game.
 */
class UltimateEngine : Engine {
/* Properties */
    // The purpose of these Properties is described in the interface
    override var board = Array<Array<String>>(3) { arrayOf<String>("E", "E", "E") }
    override var gameOver = false
    override var winner = "Nobody"


    //Variables specific to ultimate board to handle changing players
    val player1 = "X"
    val player2 = "O"
    var currentPlayer = player1


/* Methods */
    // Specific to the Ultimate Board because this is where we handle turns
    fun changePlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    // The overall purpose of the methods below are described in the interface.

    //No need for the checks in the ultimate board because it is only called on micro board wins
    override fun executeTurn(row: Int, column: Int, player: String) : Boolean{
        board[row][column] = player
        checkForWinner()
        return true
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

    override fun checkForDraw() : Boolean {
        if (board.sumBy { inner : Array<String> -> inner.count { it == "E" } } == 0 && winner == "Nobody") {
            winner = "Draw"
            gameOver = true
            return true
        }
        return false
    }



    // The ugly details of how to check for a winner in the array. Hid the complexity down here in the basement
    // Also these methods allow us to test each type of winning condition separately
            //Each case check in "XO" instead of != "E" because ultimateboards can be "Draw"
    private fun checkHorzWinner() : Boolean{
        for (row in 0..2) {
            if (board[row][0] in "XO") {
                if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
                    gameOver = true
                    winner = board[row][0]
                    return true
                } } }
        return false
    }
    private fun checkVertWinner() : Boolean{
        for (column in 0..2) {
            if (board[0][column] in "XO") {
                if (board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) {
                    gameOver = true
                    winner = board[0][column]
                    return true
                } } }
        return false
    }
    private fun checkDiagonalWinner() : Boolean{
        if (board[0][0] in "XO") {
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                gameOver = true
                winner = board[0][0]
                return true
            } }
        if (board[2][0] in "XO") {
            if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
                gameOver = true
                winner = board[2][0]
                return true
            } }
        return false
    }

}