package BehavioralPatterns.TemplateMethodExampleKotlin

abstract class Game {
    abstract fun initialize()
    abstract fun startPlay()
    abstract fun endPlay()

    fun play() {
        initialize()
        startPlay()
        endPlay()
    }
}

class Cricket : Game() {

    override fun endPlay() {
        println("Cricket Game Finished!")
    }

    override fun initialize() {
        println("Cricket Game Initialized! Start playing.")
    }

    override fun startPlay() {
        println("Cricket Game Started. Enjoy the game!")
    }
}

class Football : Game() {

    override fun endPlay() {
        println("Football Game Finished!")
    }

    override fun initialize() {
        println("Football Game Initialized! Start playing.")
    }

    override fun startPlay() {
        println("Football Game Started. Enjoy the game!")
    }
}

fun main(args: Array<String>) {

    var game: Game = Cricket()
    game.play()
    println()

    game = Football()
    game.play()
}
