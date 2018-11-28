package edu.uiowa

class TTTengine {
    //Data Structure and class properties we need to play TicTacToe
    var board = Array<Array<String>>(3) { arrayOf<String>("E", "E", "E") }
    var winningCombo = arrayListOf<Pair<Int,Int>>()
    var gameOver = false
    var winner = "Nobody"
    var moves = 0

//Could refactor Make move into smaller chunks
    //Methods needed to play TicTacToe
    fun makeMove(row: Int, column: Int, player : String) : Boolean {
        if (!gameOver) {
            //Make sure no one is already in this space
            if (board[row][column] == "E") {
                //Make move and check for winner
                board[row][column] = player
                moves++
                checkForWinner(player)
//Need to do something different on draws
                //Check for Draw
                if (moves == 9 && winner == "Nobody") {
                    winner = "Draw"
                    gameOver = true
                }
                //Move was successfully made
                return true
            }
        }
        //Move was not made
        return false
    }

    fun checkForWinner(player : String) {
        //Check Horizontal Winners
        for (row in 0..2) {
            if (board[row][0] != "E") {
                if (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])) {
                    gameOver = true
                    winner = player
                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(row, 0))
                    winningCombo.add(Pair(row, 1))
                    winningCombo.add(Pair(row, 2))
                    return
        } } }
        //Check Vertical Winners
        for (column in 0..2) {
            if (board[0][column] != "E") {
                if (board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])) {
                    gameOver = true
                    winner = player
                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(0, column))
                    winningCombo.add(Pair(1, column))
                    winningCombo.add(Pair(2, column))
                    return
        } } }
        //Check Diagonal Winners
        if (board[0][0] != "E") {
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                gameOver = true
                winner = player
                //Save winning combo for animation purposes
                winningCombo.add(Pair(0, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(2, 2))
                return
        } }
        if (board[2][0] != "E") {
            if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
                gameOver = true
                winner = player
                //Save winning combo for animation purposes
                winningCombo.add(Pair(2, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(0, 2))
                return
        } }
    }
}