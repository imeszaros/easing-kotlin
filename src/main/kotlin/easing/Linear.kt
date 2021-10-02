package easing

object Linear : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = time
    }

    override val easeOut = easeIn

    override val easeInOut = easeIn
}