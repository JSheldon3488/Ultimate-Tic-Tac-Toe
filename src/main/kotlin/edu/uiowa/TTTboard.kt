package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.util.Duration

class TTTboard(val engine : TTTengine, val ultimateBoard: UltimateBoard) : Pane() {
    val window = Pane()
    val wide = 200.0
    val high = 200.0
    var boardRow = 0
    var boardColumn = 0

    init {
        //Setup the main window
        window.setPrefSize(wide, high)
        window.style = "-fx-border-color: black; -fx-border-width: 3;"
        //Create the TicTacToe squares for the window and initialize board
        for (i in 0..2) {
            for (j in 0..2) {
                val square = TTTSquare(this, ultimateBoard)
                square.row = i
                square.column = j
                square.translateX = j * wide / 3
                square.translateY = i * high / 3
                window.children.add(square)
        } }
    }

    fun disable(){
        for (square in window.children){
            square.isDisable = true
            if (engine.winner == "Draw")
                window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: DarkGrey     "
            else if (engine.winner == "X")
                window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: LightGreen     "
            else if (engine.winner == "O")
                window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: LightCoral     "
            else
                window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: lightgrey     "
        }
    }
    fun enable(){
        for (square in window.children){
            square.isDisable = false
            window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: white"

        }
    }

    fun endMicroGame() {
        ultimateBoard.ultimateEngine.setBoardWinner(this.boardRow, this.boardColumn, this.engine.winner)
        if (this.engine.winner != "Draw")
            this.playWinAnimation(this.engine.winningCombo[0], this.engine.winningCombo[2])
        ultimateBoard.ultimateEngine.checkForWinner()
        ultimateBoard.ultimateEngine.checkForDraw()
    }


    fun playWinAnimation(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        //Create a line and add it to the children on the window so it can be used
        val line = Line()
        line.startX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.startY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.endX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.endY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.strokeWidth = 4.0
        if (engine.winner == ultimateBoard.ultimateEngine.player1) {
            line.stroke = Color.GREEN
        }
        if (engine.winner == ultimateBoard.ultimateEngine.player2) {
            line.stroke = Color.RED
        }
        window.children.add(line)

        //Animation Timeline
        val timeline = Timeline()
        timeline.keyFrames.add(KeyFrame(Duration.seconds(1.0),
                KeyValue(line.endXProperty(), end.second.toDouble() * wide / 3 + wide / 3 * 0.5),
                KeyValue(line.endYProperty(), end.first.toDouble() * high / 3 + high / 3 * 0.5)))
        timeline.play()
    }
}