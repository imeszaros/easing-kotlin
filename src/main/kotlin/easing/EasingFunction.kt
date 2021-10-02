package easing

@FunctionalInterface
interface EasingFunction {

    fun ease(time: Double): Double

    fun ease(time: Double, begin: Double, change: Double, duration: Double) = change * ease(time / duration) + begin
}