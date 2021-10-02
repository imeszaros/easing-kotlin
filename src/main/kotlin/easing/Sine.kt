package easing

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

object Sine : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = -cos(time * (PI / 2)) + 1
    }

    override val easeOut = object : EasingFunction {

        override fun ease(time: Double) = sin(time * (PI / 2))
    }

    override val easeInOut = object : EasingFunction {

        override fun ease(time: Double) = -.5 * (cos(time * PI) - 1)
    }
}