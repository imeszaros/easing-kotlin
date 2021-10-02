package easing

object Quad : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = time * time
    }

    override val easeOut = object : EasingFunction {

        override fun ease(time: Double) = -time * (time - 2)
    }

    override val easeInOut = Easing.defaultEaseInOut(easeIn, easeOut)
}