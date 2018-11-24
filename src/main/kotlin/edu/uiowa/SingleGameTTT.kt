package edu.uiowa

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class TTTapp: Application(){
    override fun start(primaryStage: Stage) {
        primaryStage.scene = Scene(TTTboard(TTTengine()).window)
        primaryStage.show()
    }
}

fun main(args: Array<String>) {
    Application.launch(TTTapp::class.java)
}