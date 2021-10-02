package easing

import kotlin.math.pow

object Expo : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = if (time == .0) {
            .0
        } else {
            2.0.pow(10 * (time - 1))
        }
    }

    override val easeOut = object : EasingFunction {

        override fun ease(time: Double) = if (time == 1.0) {
            1.0
        } else {
            -(2.0.pow(-10 * time)) + 1
        }
    }

    override val easeInOut = Easing.defaultEaseInOut(easeIn, easeOut)
}