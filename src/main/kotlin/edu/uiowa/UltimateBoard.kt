package edu.uiowa

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.scene.layout.GridPane
import javafx.util.Duration

/*
Class for creating and supporting the functionality of the Ultimate Tic-Tac-Toe "View". There is only 1 ultimate engine
that will be shared by all the individual boards.
 */
class UltimateBoard(val ultimateEngine : UltimateEngine, val mainMenu: MainMenu) : GridPane() {
/* Properties */
    //Note: There is also a ultimateEngine and mainMenu property we use throught in the primary constructor

    val window = GridPane()
    //Used for iteration in set state
    var macroBoard = arrayListOf<TTTboard>()

    // upon creation of an ultimate board need to create all the individual boards and put them in the ultimate board
    init {
        // add gap between boards so the view looks nice
        window.vgap = 15.0
        window.hgap = 15.0

        for (i in 0..2) {
            for (j in 0..2) {
                //"this" is to share one ultimateboard with every individual micro board. This allows us to access
                //the ultimate engine inside every individual board
                val board = TTTboard(TTTengine(), this)
                //Set boards location in the ultimate board as a reference for the ultimate engine
                board.boardRow = i
                board.boardColumn = j
                macroBoard.add(i*j, board)
                window.add(board.window,j,i)
        }}
    }



/* Methods */

    /*
    setState allows us to enable and disable the correct boards after each turn based on the rules of the game.
    row and column will be information from the individual squares location(in Square Class) in their individual boards.
     */
    fun setState(row: Int, column: Int){
        for (board in macroBoard) {
            //Check to see if last click (turn) sent us to this individual board
            if (board.boardRow == row && board.boardColumn == column) {
                //Sent to a board that is already finished so open all non finished games
                if (board.engine.gameOver) {
                    enableAllOpen()
                    break
                }
                //Sent to a board that is playable
                else board.enable()
            }
            else board.disable()
        }
    }

    /*
    enableAllOpen allows us to enable all playable boards if we were sent to a board that is already finished.
     */
    private fun enableAllOpen(){
        for (board in macroBoard){
            if (!board.engine.gameOver)
                board.enable()
            else
                board.disable()
        }
    }

    /*
    endMacroGame allows us to disable all windowns and play a delay to allow micro game win animations to finish
     */
    fun endMacroGame() {
        //disable all the boards because the game is over
        for (board in macroBoard){
            board.disable()
        }
        //Need a delay to let the win game animation finish before going back to the main menu.
        val timeline = Timeline()
        timeline.keyFrames.add(KeyFrame(Duration.seconds(2.0)))
        timeline.setOnFinished { transitionGame() }
        timeline.play()
    }

    /*
    transitionGame allows us to get rid of the old game window and go back to the main menu with a winner message
     */
    fun transitionGame(){
        //mainMenu at this point is the ultimateBoard view
        mainMenu.hide()
        if (ultimateEngine.winner != "Draw") {
            MainMenu().textBox.text = "Player ${ultimateEngine.winner} Wins!!!"
        }
        else {
            MainMenu().textBox.text = "Draw :("
        }
    }
    
}
