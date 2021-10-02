package easing

object Back : Easing {

    private const val s = 1.70158
    private const val f = 1.525

    fun easeIn(s: Double) = object : EasingFunction {

        override fun ease(time: Double) = time * time * ((s + 1) * time - s)
    }

    fun easeOut(s: Double) = object : EasingFunction {

        override fun ease(time: Double) = (time - 1).let {
            it * it * ((s + 1) * it + s) + 1
        }
    }

    fun easeInOut(s: Double) = Easing.defaultEaseInOut(easeIn(s * f), easeOut(s * f))

    override val easeIn = easeIn(s)

    override val easeOut = easeOut(s)

    override val easeInOut = easeInOut(s)
}