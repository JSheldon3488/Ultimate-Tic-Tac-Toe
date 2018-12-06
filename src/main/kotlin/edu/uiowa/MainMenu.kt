package edu.uiowa

import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import javafx.stage.Stage

class MainMenu : Stage() {
    val newGame = Button("New Game")
    val quit = Button("Quit")
    val window = Pane()
    var textBox = Text()
    val hBox = HBox()


    init {
        //Setup Main Menu Window
        this.title = "Main Menu"
        window.setPrefSize(275.0,150.0)
        window.children.addAll(newGame, quit, hBox)

        //Set up Hbox
        hBox.setPrefSize(275.0, 50.0)
        hBox.alignment = Pos.CENTER

        //Add text box to pane
        textBox.text = "Let's Play!!!"
        textBox.font = Font.font ("Verdana", 20.0)
        hBox.children.add(textBox)


        //Setup NewGame Button
        newGame.setPrefSize(100.0,75.0)
        newGame.layoutX = 25.0
        newGame.layoutY = 50.0
        newGame.setOnAction { showUltimateBoard() }
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
        this.scene = Scene(UltimateBoard(UltimateEngine(), this).window)
        this.title = "Ultimate Tic-Tac-Toe"
        this.show()
    }
}