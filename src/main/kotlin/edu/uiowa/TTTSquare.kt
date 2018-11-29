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
        if (board.engine.executeTurn(row, column, ultimateBoard.ultimateEngine.currentPlayer)) {
            if (ultimateBoard.ultimateEngine.currentPlayer == ultimateBoard.ultimateEngine.player1)
                fillPlayer1()
            else
                fillPlayer2()

            //Check if Draw
            if (ultimateBoard.ultimateEngine.checkForDraw()) {
                ultimateBoard.endMacroGame()
            }

            if (board.engine.gameOver) {
                board.endMicroGame()
            }
            //Get Ready for Next Turn
            if (ultimateBoard.ultimateEngine.gameOver) {
                ultimateBoard.endMacroGame()
            }
            else{
                ultimateBoard.ultimateEngine.changePlayer()
                ultimateBoard.setState(row, column)
            }
        }
    }

    fun fillPlayer1() {
        textBox.fill = Color.GREEN
        textBox.text = ultimateBoard.ultimateEngine.player1
    }
    fun fillPlayer2(){
        textBox.fill = Color.RED
        textBox.text = ultimateBoard.ultimateEngine.player2
    }

}