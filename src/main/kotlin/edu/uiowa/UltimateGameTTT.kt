package edu.uiowa

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.stage.Stage

/*
UltimateTTTapp is just the application launcher. All the real action is elsewhere
 */
class UltimateTTTapp: Application() {
    override fun start(primaryStage: Stage) {
        //MainMenu() Creates and runs the stages.
        UltimateBoard(UltimateEngine(),MainMenu())
    }
}

fun main(args: Array<String>) {
    Application.launch(UltimateTTTapp::class.java)
}