package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.util.Duration

class TTTboard(val engine : TTTengine) : Pane() {
    val window = Pane()
    val wide = 600.0
    val high = 600.0
    init {
        //Setup the main window
        window.setPrefSize(wide, high)
        //Create the TicTacToe squares for the window and initialize board
        for (i in 0..2) {
            for (j in 0..2) {
                val square = TTTSquare(engine, this)
                square.row = i
                square.column = j
                square.translateX = j * wide / 3
                square.translateY = i * high / 3
                window.children.add(square)
        } }
    }

    fun playWinAnimation(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        //Create a line and add it to the children on the window so it can be used
        val line = Line()
        line.startX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.startY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.endX = start.second.toDouble() * wide / 3 + wide / 3 * 0.5
        line.endY = start.first.toDouble() * high / 3 + high / 3 * 0.5
        line.strokeWidth = 4.0
        if (engine.winner == engine.player1) {
            line.stroke = Color.GREEN
        }
        if (engine.winner == engine.player2) {
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