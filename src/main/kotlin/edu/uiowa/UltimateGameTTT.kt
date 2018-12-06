package edu.uiowa

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.stage.Stage

class UltimateTTTapp: Application() {
    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(UltimateBoard(UltimateEngine()).window)
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(UltimateTTTapp::class.java)
}