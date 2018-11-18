package edu.uiowa

import sun.font.TrueTypeFont


class TicTacToe{
    //Data Structure and class properties we need to play TicTacToe
        var board = Array<Array<String>>(3) {arrayOf<String>("E", "E", "E")}
        val player1 = "X"
        val player2 = "O"
        var currentPlayer = "X"
        var gameOver = false
        var winner = "Nobody"
        var moves = 0


    //Methods needed to play TicTacToe
        fun makeMove(row: Int, column: Int){
            if (!gameOver) {
                //Make sure no one is already in this space
                if (board[row][column] != "E") {return}
                //Make move and check for winner
                board[row][column] = currentPlayer
                checkForWinner()
                //Switch player turn
                if (currentPlayer == "X") {currentPlayer = "O"}
                else {currentPlayer = "X"}
                moves++
                //Check for Draw
                if (moves == 9 && winner == "Nobody"){
                    winner = "Draw"
                    gameOver = true
                }
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
//Test push 2 no VPN