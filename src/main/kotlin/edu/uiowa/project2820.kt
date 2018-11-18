package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage
import javafx.util.Duration


class TTTengine{
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
            } } }
            //Check Vertical Winners
            for (column in 0..2){
                if (board[0][column] != "E"){
                    if( board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])){
                        gameOver = true
                        winner = currentPlayer
                        return
            } } }
            //Check Diagonal Winners
            if (board[0][0] != "E"){
                if( board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
                    gameOver = true
                    winner = currentPlayer
                    return
            } }
            if (board[2][0] != "E"){
                if( board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])){
                    gameOver = true
                    winner = currentPlayer
                    return
            } }
        }
}

class TTTview: Application(){
    val window = Pane()
    var currentToken = "X"
    val engine = TTTengine()

    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(createViewBoard())
        primaryStage.show()
    }

    fun createViewBoard() : Parent {
        //Setup the main window
        window.setPrefSize(600.0, 600.0)

        //Create the TicTacToe squares for the window and initialize board
        for (i in 0..2) {
            for (j in 0..2) {
                val square = TTTSquare()
                square.row = i
                square.column = j
                square.translateX = j * 200.0
                square.translateY = i * 200.0
                square.centerX = j * 200.0 + 100
                square.centerY = i * 200.0 + 100
                window.children.add(square)
        } }
        return window
    }

    //Used to create the Tic Tac Toe squares inside of the main window
    inner class TTTSquare: StackPane() {
        var textBox = Text()
        var centerX : Double = 0.0
        var centerY : Double = 0.0
        var row: Int = 0
        var column: Int = 0

        //List of initial parameters for each Square
        init {
            val border = Rectangle(200.0,200.0)
            border.fill = null
            border.stroke = Color.BLACK
            setAlignment(Pos.CENTER)
            textBox.font = Font.font(88.0)
            children.addAll(border, textBox)
            //Sets the call on the Node itself instead of needing X and Y coordinates
            setOnMouseClicked { if (textBox.text.isEmpty() && !engine.gameOver) draw() }
        }

        //What needs to happen from the views perspective on clicks
        fun draw() {
            if (currentToken == "X"){
                textBox.fill = Color.GREEN
                textBox.text = "X"
                engine.makeMove(row,column)
                currentToken = "O"
            }
            else {
                textBox.fill = Color.RED
                textBox.text = "O"
                engine.makeMove(row,column)
                currentToken = "X"
            }
        }
    }
}
fun main(args: Array<String>) {
    Application.launch(TTTview::class.java)
}