package edu.uiowa

import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.stage.Stage

class MainMenu : Stage() {
    val newGame = Button("New Game")
    val quit = Button("Quit")
    val window = Pane()

    init {
        //Setup Main Menu Window
        this.title = "Main Menu"
        window.setPrefSize(275.0,150.0)
        window.children.addAll(newGame, quit)

        //Setup NewGame Button
        newGame.setPrefSize(100.0,75.0)
        newGame.layoutX = 25.0
        newGame.layoutY = 50.0
        newGame.setOnAction { showUltimateBoard()
                              this.hide()}
        //Setup Quit Button
        quit.setPrefSize(100.0,75.0)
        quit.layoutX = 150.0
        quit.layoutY = 50.0
        quit.setOnAction { this.hide() }

        //Run Main Menu Scene
        this.scene = Scene(this.window)
        this.show()
    }

    fun showUltimateBoard() {
        val gameStage = Stage()
        gameStage.scene = Scene(UltimateBoard(UltimateEngine()).window)
        gameStage.title = "Ultimate Tic-Tac-Toe"
        gameStage.show()
    }
}