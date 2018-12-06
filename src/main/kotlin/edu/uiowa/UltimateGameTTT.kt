package edu.uiowa

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.stage.Stage

class UltimateTTTapp: Application() {
    override fun start(primaryStage: Stage) {
        //Main menu runs the stage. I did this becaus then I could create a new MainMenu when the games
        // ended to start a new game and no stages left behind in background
        UltimateBoard(UltimateEngine(),MainMenu())
    }
}

fun main(args: Array<String>) {
    Application.launch(UltimateTTTapp::class.java)
}