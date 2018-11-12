package edu.uiowa


class TicTacToe{
    //Data Structure and class properties we need to play TicTacToe
        //First we need a board which for now is going to be filled with strings
        //Later baord will be Buttons in JavaFX
    var board = Array<Array<String>>(3, {arrayOf<String>("E")})
        //We are going to need an X player and an O player
    val player1 = "X"
    val player2 = "O"
        //We will need a variable to track who the current player is to display winner
            //Maybe in future flip for who goes first or something like that
    var currentPlayer = "X"
        //We will need a flag to stop the game once its over
    var gameOver = false
    var winner = "Nobody"


    //Methods needed to play TicTacToe
    fun draw(row: Int, column: Int){
        if (!gameOver) {
            board[row][column] = currentPlayer
            checkForWinner()
            if (currentPlayer == "X") {currentPlayer = "O"}
            else {currentPlayer = "X"}
        }
    }

    fun checkForWinner(){
        //Check Horizontal Winners
        for (row in 0..2){
            if (board[row][0] != "E"){
                if( board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])){
                    gameOver = true
                    winner = currentPlayer
                    return
                }
            }
        }
        //Check Vertical Winners
        for (column in 0..2){
            if (board[0][column] != "E"){
                if( board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])){
                    gameOver = true
                    winner = currentPlayer
                    return
                }
            }
        }
        //Check Diagonal Winners
        if (board[0][0] != "E"){
            if( board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
                gameOver = true
                winner = currentPlayer
                return
            }
        }
        if (board[2][0] != "E"){
            if( board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])){
                gameOver = true
                winner = currentPlayer
                return
            }
        }
    }
}

fun main(args: Array<String>) {
    //List of to do's:
        //Write Unit Tests for this current Code
        //Potentially a print board so play in the terminal or just skip to JavaFX
        //Would be nice to keep track of what combo won so we can draw animation over it
}