package edu.uiowa

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.stage.Stage

/*
UltimateTTTapp is just the application launcher. All the real action is elsewhere
 */
abstract class UltimateTTTapp: Application() {
    lateinit var stage: Stage

    override fun start(primaryStage: Stage) {
        stage = primaryStage

        //MainMenu() Creates and runs the stages.
        val game = Scene(UltimateBoard(UltimateEngine(),MainMenu()))
        primaryStage.scene = game
        //Still don't think I love this method
    }
}

fun main(args: Array<String>) {
    Application.launch(UltimateTTTapp::class.java)
}