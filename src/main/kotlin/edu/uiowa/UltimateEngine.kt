package edu.uiowa

class UltimateEngine {
    val player1 = "X"
    val player2 = "O"
    var currentPlayer = player1

    fun makeMove(){
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }
}