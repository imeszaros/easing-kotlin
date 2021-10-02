package easing

object Cubic : Easing {

    override val easeIn = object : EasingFunction {

        override fun ease(time: Double) = time * time * time
    }

    override val easeOut = object : EasingFunction {

        override fun ease(time: Double) = (time - 1).let { it * it * it + 1 }
    }

    override val easeInOut = Easing.defaultEaseInOut(easeIn, easeOut)
}