package easing

import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.pow
import kotlin.math.sin

object Elastic : Easing {

    private const val a = 1.0
    private const val p = .3
    private const val f = 1.5

    private fun calc(a: Double, p: Double) = if (a < 1) {
        1.0 to p / 4
    } else {
        a to p / (2 * PI) * asin(1 / a)
    }

    fun easeIn(a: Double, p: Double) = object : EasingFunction {

        override fun ease(time: Double) = when (time) {
            .0 -> .0
            1.0 -> 1.0
            else -> {
                val (_a, _s) = calc(a, p)
                (time - 1).let {
                    -(_a * 2.0.pow(10 * it) * sin((it - _s) * (2 * PI) / p))
                }
            }
        }
    }

    fun easeOut(a: Double, p: Double) = object : EasingFunction {

        override fun ease(time: Double) = when (time) {
            .0 -> .0
            1.0 -> 1.0
            else -> {
                val (_a, _s) = calc(a, p)
                _a * 2.0.pow(-10 * time) * sin((time - _s) * (2 * PI) / p) + 1
            }
        }
    }

    fun easeInOut(a: Double, p: Double) = Easing.defaultEaseInOut(easeIn(a, p), easeOut(a, p))

    override val easeIn = easeIn(a, p)

    override val easeOut = easeOut(a, p)

    override val easeInOut = easeInOut(a, p * f)
}