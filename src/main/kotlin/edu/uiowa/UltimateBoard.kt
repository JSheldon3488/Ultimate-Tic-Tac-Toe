package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.layout.GridPane
import javafx.util.Duration

class UltimateBoard(val ultimateEngine : UltimateEngine, val mainMenu: MainMenu) : GridPane() {
    val window = GridPane()
    var macroBoard = arrayListOf<TTTboard>()

    init {
        window.vgap = 15.0
        window.hgap = 15.0

        for (i in 0..2) {
            for (j in 0..2) {
                val board = TTTboard(TTTengine(), this)
                board.boardRow = i
                board.boardColumn = j
                macroBoard.add(i*j, board)
                window.add(board.window,j,i)
        }}

    }
    fun setState(row: Int, column: Int){
        for (board in macroBoard) {
            if (board.boardRow == row && board.boardColumn == column) {
                if (board.engine.gameOver) {
                    enableAllOpen()
                    break
                }
                else board.enable()
            }
            else board.disable()
        }
    }

    private fun enableAllOpen(){
        for (board in macroBoard){
            if (!board.engine.gameOver)
                board.enable()
            else
                board.disable()
        }
    }

    fun endMacroGame() {
        for (board in macroBoard){
            board.disable()
        }
        val timeline = Timeline()
        timeline.keyFrames.add(KeyFrame(Duration.seconds(2.0)))
        timeline.setOnFinished { transitionGame() }
        timeline.play()
    }

    fun transitionGame(){
        mainMenu.hide()
        if (ultimateEngine.winner != "Draw") {
            MainMenu().textBox.text = "Player ${ultimateEngine.winner} Wins!!!"

        }
        else {
            MainMenu().textBox.text = "Draw :("
        }
    }
}
