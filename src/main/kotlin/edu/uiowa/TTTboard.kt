package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.util.Duration

/*
Class to support functionality of the "view" of an individual Tic-Tic-Toe game. Supports creating the display of the board
as well as the functionality of the boards display as the game is played. Each board has its own individual engine as well
as a shared ultimate Engine that comes from the Ultimate Board. Both of these properties are used throughout to help with
the functionality of the display.
 */
class TTTboard(val engine : TTTengine, val ultimateBoard: UltimateBoard) : Pane() {
/* Properties */
    val window = Pane()
    //Size for the windows (needed to accurately draw game win animation)
    val wide = 200.0
    val high = 200.0
    //Properties used inside the the ultimate board so that we have a reference to this boards location
    var boardRow = 0
    var boardColumn = 0

    // init deals with the creation of the board. Including all the individual Squares which are a class themselves.
    init {
        //Setup the main window
        window.setPrefSize(wide, high)
        window.style = "-fx-border-color: black; -fx-border-width: 3;"
        //Create the TicTacToe squares for the window and initialize board
        for (i in 0..2) {
            for (j in 0..2) {
                val square = TTTSquare(this, ultimateBoard)
                // Save reference to this squares location in the board
                square.row = i
                square.column = j
                // Need for positioning squares and animation
                square.translateX = j * wide / 3
                square.translateY = i * high / 3
                window.children.add(square)
        } }
    }


/* Methods */

    /*
    Individual board won --> draw win animation and inform the ultimate board
        **Each board is an individual object so we can reference it with "this" keyword.
     */
    fun endMicroGame() {
        if (this.engine.winner != "Draw") {
            this.playWinAnimation(this.engine.winningCombo[0], this.engine.winningCombo[2])
        }
        ultimateBoard.ultimateEngine.executeTurn(this.boardRow, this.boardColumn, this.engine.winner)
    }

    /*
    disable provides the functionality in the "view" to disable an entire board. This is used for disabling any individual
    board that should not be active at the time due to the rules of the game. Also provides window style due to the state of
    each individual board.
     */
    fun disable(){
        this.window.isDisable = true
        // Set the style of the window based on the individual boards game status.
        when {
            engine.winner == "Draw" -> window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: DarkGrey"
            engine.winner == "X" -> window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: LightGreen"
            engine.winner == "O" -> window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: LightCoral"
            else -> window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: lightgrey"
        }
    }

    // enable allows boards to be enabled if a player is sent to that board for their next turn
    fun enable(){
        this.window.isDisable = false
        window.style = "-fx-border-color: black; -fx-border-width: 3; -fx-background-color: white"
    }

    /*
    playWinAnimation is only used in individual micro boards for drawing a line threw the winning combination.
    Only used for aesthetic purposes to make it more visually obvious who won what boards.
     */
    fun playWinAnimation(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        //Create a line and add it to the children on the window so it can be used
        val line = Line()
        line.startX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.startY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.endX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.endY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.strokeWidth = 4.0
        // Set the color of the line based on who the winner of the board was
        if (engine.winner == ultimateBoard.ultimateEngine.player1) {
            line.stroke = Color.GREEN
        }
        if (engine.winner == ultimateBoard.ultimateEngine.player2) {
            line.stroke = Color.RED
        }
        window.children.add(line)

        //Animation Timeline for drawing the line
        val timeline = Timeline()
        timeline.keyFrames.add(KeyFrame(Duration.seconds(1.0),
                KeyValue(line.endXProperty(), end.second.toDouble() * wide / 3 + wide / 3 * 0.5),
                KeyValue(line.endYProperty(), end.first.toDouble() * high / 3 + high / 3 * 0.5)))
        timeline.play()
    }
}