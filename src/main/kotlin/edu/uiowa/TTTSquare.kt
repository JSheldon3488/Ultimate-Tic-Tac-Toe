package edu.uiowa

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text

class TTTSquare(val engine : TTTengine, val board: TTTboard) : StackPane() {
    var textBox = Text()
    //used for making moves in the engine
    var row: Int = 0
    var column: Int = 0

    //Initialize Each Square
    init {
        val border = Rectangle(board.wide / 3.0, board.high / 3.0)
        border.fill = null
        border.stroke = Color.BLACK
        setAlignment(Pos.CENTER)
        textBox.font = Font.font(board.wide / 6)
        children.addAll(border, textBox)
        setOnMouseClicked { draw() }
    }

    //What needs to happen from the views and engine perspective on clicks
    fun draw() {
        if (engine.makeMove(row, column)) {
            //The player will be changed in make move so use opposite
            if (engine.currentPlayer == engine.player2) {
                textBox.fill = Color.GREEN
                textBox.text = engine.player1

            } else {
                textBox.fill = Color.RED
                textBox.text = engine.player2
            }
            if (engine.gameOver){
                board.playWinAnimation(engine.winningCombo[0], engine.winningCombo[2])
            }
        }
    }
}