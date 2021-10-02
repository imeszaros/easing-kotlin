package easing

import kotlin.math.sqrt

object Circ : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = - (sqrt(1 - time * time) - 1)
    }

    override val easeOut: EasingFunction = object : EasingFunction {

        override fun ease(time: Double) = (time - 1).let { sqrt(1 - it * it) }
    }

    override val easeInOut = Easing.defaultEaseInOut(easeIn, easeOut)
}