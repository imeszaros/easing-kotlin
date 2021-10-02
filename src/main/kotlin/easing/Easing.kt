package easing

sealed interface Easing {

    val easeIn: EasingFunction

    val easeOut: EasingFunction

    val easeInOut: EasingFunction

    companion object {

        fun defaultEaseInOut(easeIn: EasingFunction, easeOut: EasingFunction) = object : EasingFunction {

            override fun ease(time: Double) = if (time < .5) {
                easeIn.ease(time * 2) * .5
            } else {
                easeOut.ease((time - .5) * 2) * .5 + .5
            }
        }
    }
}