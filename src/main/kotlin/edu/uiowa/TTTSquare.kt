package edu.uiowa

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text

class TTTSquare(val board: TTTboard, val ultimateBoard: UltimateBoard) : StackPane() {
    var textBox = Text()
    //used for making moves in the engine
    var row: Int = 0
    var column: Int = 0

    //Initialize Each Square
    init {
        val border = Rectangle(board.wide / 3.0, board.high / 3.0)
        border.fill = null
        border.stroke = Color.BLACK
        alignment = Pos.CENTER
        textBox.font = Font.font(board.wide / 6)
        children.addAll(border, textBox)
        setOnMouseClicked { click() }
    }

    //What needs to happen from the views and engine perspective on clicks
    fun click() {
        if (board.engine.makeMove(row, column, ultimateBoard.ultimateEngine.currentPlayer)) {
            //The player will be changed in make move so use opposite
            if (ultimateBoard.ultimateEngine.currentPlayer == ultimateBoard.ultimateEngine.player1) {
                textBox.fill = Color.GREEN
                textBox.text = ultimateBoard.ultimateEngine.player1
            } else {
                textBox.fill = Color.RED
                textBox.text = ultimateBoard.ultimateEngine.player2
            }
            ultimateBoard.ultimateEngine.makeMove()
            ultimateBoard.setState(row,column)
            if (board.engine.gameOver){
                board.playWinAnimation(board.engine.winningCombo[0], board.engine.winningCombo[2])
            }
        }
    }
}