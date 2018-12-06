package edu.uiowa

class UltimateEngine {
    var ultimateBoard = Array<Array<String>>(3) { arrayOf<String>("E", "E", "E") }
    var winningCombo = arrayListOf<Pair<Int,Int>>()
    val player1 = "X"
    val player2 = "O"
    var currentPlayer = player1
    var gameOver = false
    var winner = "Nobody"
    var finishedBoards = 0

    fun changePlayer() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    //No need for protective programming here because this only gets called by boards that we assume were
    //already initialized correctly
    fun setBoardWinner(row: Int, column: Int, winner: String){
        ultimateBoard[row][column] = winner
        finishedBoards++
        checkForWinner()
    }

    //Change to a when statement
    fun checkForWinner() : Boolean {
        if (checkHorzWinner()){ return true }
        if (checkVertWinner()) { return true }
        if (checkDiagonalWinner()){ return true }
        if (checkForDraw()) { return true }
        return false
    }

    fun checkForDraw() : Boolean {
        if (finishedBoards == 9 && winner == "Nobody") {
            winner = "Draw"
            gameOver = true
            return true
        }
        return false
    }

    fun checkHorzWinner() : Boolean{
        for (row in 0..2) {
            if (ultimateBoard[row][0] in "XO") {
                if (ultimateBoard[row][0].equals(ultimateBoard[row][1]) && ultimateBoard[row][1].equals(ultimateBoard[row][2])) {
                    gameOver = true
                    winner = ultimateBoard[row][0]
                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(row, 0))
                    winningCombo.add(Pair(row, 1))
                    winningCombo.add(Pair(row, 2))
                    return true
                } } }
        return false
    }
    fun checkVertWinner() : Boolean{
        for (column in 0..2) {
            if (ultimateBoard[0][column] in "XO") {
                if (ultimateBoard[0][column].equals(ultimateBoard[1][column]) && ultimateBoard[1][column].equals(ultimateBoard[2][column])) {
                    gameOver = true
                    winner = ultimateBoard[0][column]
                    //Save winning combo for animation purposes
                    winningCombo.add(Pair(0, column))
                    winningCombo.add(Pair(1, column))
                    winningCombo.add(Pair(2, column))
                    return true
                } } }
        return false
    }
    fun checkDiagonalWinner() : Boolean{
        if (ultimateBoard[0][0] in "XO") {
            if (ultimateBoard[0][0].equals(ultimateBoard[1][1]) && ultimateBoard[1][1].equals(ultimateBoard[2][2])) {
                gameOver = true
                winner = ultimateBoard[0][0]
                //Save winning combo for animation purposes
                winningCombo.add(Pair(0, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(2, 2))
                return true
            } }
        if (ultimateBoard[2][0] in "XO") {
            if (ultimateBoard[2][0].equals(ultimateBoard[1][1]) && ultimateBoard[1][1].equals(ultimateBoard[0][2])) {
                gameOver = true
                winner = ultimateBoard[2][0]
                //Save winning combo for animation purposes
                winningCombo.add(Pair(2, 0))
                winningCombo.add(Pair(1, 1))
                winningCombo.add(Pair(0, 2))
                return true
            } }
        return false
    }
}