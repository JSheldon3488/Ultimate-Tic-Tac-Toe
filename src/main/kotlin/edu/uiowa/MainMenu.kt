package edu.uiowa

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage

/*
MainMenu provides the functionality of creating a Main Menu for the player to interact with.
 */
class MainMenu : Stage() {
/* Properties */
    val newGame = Button("New Game")
    val quit = Button("Quit")
    val window = Pane()
    var mainTextBox = Text()
    var ruleTextBox = Text()
    val gameMessage = HBox()
    val buttons = HBox()
    val rules = HBox()


/* The Setup */
    init {
        //Setup Main Menu Window
        this.title = "Main Menu"
        window.setPrefSize(450.0,500.0)
        window.children.addAll(gameMessage, buttons, rules)

        //Set up gameMessage
        gameMessage.setPrefSize(450.0, 100.0)
        gameMessage.alignment = Pos.CENTER
        //Add text box to gameMessage
        mainTextBox.text = "Ultimate Tic-Tac-Toe!!!"
        mainTextBox.font = Font.font ("Verdana", 24.0)
        gameMessage.children.add(mainTextBox)

        //Setup Buttons box
        buttons.setPrefSize(450.0, 100.0)
        buttons.layoutY = 100.0
        buttons.alignment = Pos.CENTER
        buttons.spacing = 25.0
        //Setup NewGame Button
        newGame.setPrefSize(100.0,75.0)
        newGame.setOnAction { showUltimateBoard() }
        buttons.children.add(newGame)
        //Setup Quit Button
        quit.setPrefSize(100.0,75.0)
        quit.setOnAction { this.hide() }
        buttons.children.add(quit)

        //Setup Rules Box
        rules.setPrefSize(350.0, 300.0)
        rules.layoutY = 250.0
        ruleTextBox.text = "  Rules: \n\t" +
                "- Each small 3x3 tic-tac-toe board is referred to as a local \n\t" +
                "  board and the larger board is the global board.\n\t" +
                "- The goal is to win 3 local boards so that you create a\n\t" +
                "  tic-tac-toe win on the global board.\n\t" +
                "- The game ends when a player wins the global board\n\t" +
                "  or no moves remain, in which case the game is a draw." +
                "\n\n   Additional Rules:\n\t" +
                "- Each move on a local board sends your opponent to the\n\t" +
                "  corresponding board at that location on the global board.\n\t" +
                "- If you send your opponent to a finished game they will be\n\t" +
                "  allowed to play their next turn in any open board.\n\t" +
                "- HAVE FUN!!!"
        ruleTextBox.font = Font.font("Verdana", 13.0)
        rules.children.add(ruleTextBox)

    //Run Main Menu Scene
        this.scene = Scene(this.window)
        this.show()
    }
    /*
    showUltimateBoard provides the functionality of activating the ultimate board scene when a player clicks play game
     */
    fun showUltimateBoard() {
        this.scene = Scene(UltimateBoard(UltimateEngine(), this).window)
        this.title = "Ultimate Tic-Tac-Toe"
        this.show()
    }
}