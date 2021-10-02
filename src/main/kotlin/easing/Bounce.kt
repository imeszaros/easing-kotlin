package easing

object Bounce : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = 1 - easeOut.ease(1 - time)
    }

    override val easeOut = object : EasingFunction {

        override fun ease(time: Double) = when {
            time < 1 / 2.75 -> 7.5625 * time * time
            time < 2 / 2.75 -> (time - 1.5  / 2.75).let { 7.5625 * it * it + .75 }
            time < 2.5 / 2.75 -> (time - 2.25  / 2.75).let { 7.5625 * it * it + .9375 }
            else -> (time - 2.625  / 2.75).let { 7.5625 * it * it + .984375 }
        }
    }

    override val easeInOut = Easing.defaultEaseInOut(easeIn, easeOut)
}