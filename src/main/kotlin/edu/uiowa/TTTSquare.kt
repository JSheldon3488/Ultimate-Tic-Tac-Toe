package edu.uiowa

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text

/*
Square class handles creating the "view" of each individual Tic-Tac-Toe square on the baord.
Square Class also acts as the controller for this entire program. All GUI interactions are defined here.
Each Square has a reference to which board it is in and to the ultimate board.
 */
class TTTSquare(val board: TTTboard, val ultimateBoard: UltimateBoard) : StackPane() {
/* Properties */
    var textBox = Text()
    //isEmpty is used for the Hovering Functionality
    var isEmpty = true
    //row, col are used for making moves in the engine (reference to where the square is located in the board)
    var row: Int = 0
    var column: Int = 0

    init {
        //Create teh view of the square
        val border = Rectangle(board.wide / 3.0, board.high / 3.0)
        border.fill = null
        border.stroke = Color.BLACK
        alignment = Pos.CENTER
        textBox.font = Font.font(board.wide / 6)
        children.addAll(border, textBox)

        //Define all on action functionality needed for the game. (controller)
        setOnMouseClicked { click() }
        setOnMouseEntered { hover() }
        setOnMouseExited { clear() }
    }


/* View Methods */
    /*
    hover allows us to display the token for the current player inside whatever square that player is hovering over with
    the mouse. This improves the look and feel of gameplay.
     */
    fun hover() {
        //Only display for empty squares
        if (this.isEmpty) {
            if (ultimateBoard.ultimateEngine.currentPlayer == ultimateBoard.ultimateEngine.player1) {
                textBox.fill = Color.GREEN
                textBox.text = ultimateBoard.ultimateEngine.player1
            }
            else {
                textBox.fill = Color.RED
                textBox.text = ultimateBoard.ultimateEngine.player2
    } } }

    /*
    clear is used to remove the hover display as a player moves the mouse out of that square.
     */
    fun clear() {
        if (this.isEmpty) {
            textBox.text = null
    } }



/* Controller Methods */
    /*
    Click acts as the controller for this entire program. Everything that happens in the engines and from the
    "view" perspective when a player makes a turn is defined here in click.
     */
    fun click() {
        //On click attempt move on the micro board and if it succeeds execute that entire turn else wait for valid click
            //executeTurn handles everything from the models perspective when a player makes a valid turn
        if (board.engine.executeTurn(row, column, ultimateBoard.ultimateEngine.currentPlayer)) {
            fillSquare()
            updateGameState()
            prepNextTurn()
    } }

            //fillSquare provides functionality to display a players token when he chooses a square on their turn
            private fun fillSquare(){
                if (ultimateBoard.ultimateEngine.currentPlayer == ultimateBoard.ultimateEngine.player1){
                    textBox.fill = Color.GREEN
                    textBox.text = ultimateBoard.ultimateEngine.player1
                    this.isEmpty = false
                }
                else{
                    textBox.fill = Color.RED
                    textBox.text = ultimateBoard.ultimateEngine.player2
                    this.isEmpty = false
            } }

            //updateGameState provides the functionality necessary for when a micro game is won
            private fun updateGameState() {
                if (board.engine.gameOver) {
                    board.endMicroGame()
                    //Micro board ended check macro board state
                    if (ultimateBoard.ultimateEngine.gameOver) {
                        ultimateBoard.endMacroGame()
            } } }

            //prepNextTurn provides the functionality to set the boards ready for the next players turn.
            private fun prepNextTurn() {
                if (!ultimateBoard.ultimateEngine.gameOver) {
                    ultimateBoard.ultimateEngine.changePlayer()
                    //setState does all the enabling and disabling of the correct boards
                    ultimateBoard.setState(row, column)
            } }

}