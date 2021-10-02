# Robert Penner's Easing Functions in Kotlin

Kotlin implementation of the well-known easing functions from [Robert Penner](http://robertpenner.com/easing/).

## Usage

Include the library in your build:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.imeszaros:easing-kotlin:v0.1'
}
```

### The EasingFunction interface

The `EasingFunction` interface defines a single abstract function that maps a `Double` in the range `0..1` to an 'eased'
value - usually also closely in the range `0..1` (some styles may map outside, e.g. `Back`, `Elastic`):

```kotlin
interface EasingFunction {

    fun ease(time: Double): Double
    fun ease(time: Double, begin: Double, change: Double, duration: Double) = change * ease(time / duration) + begin
}
```

The second function makes it possible to ease a value specifying an elapsed `time`, a `begin` value, a `change` value
and a `duration` to get an appropriately mapped value back.

### The Easing interface

The `Easing` interface defines three easing functions for each easing style:

```kotlin
sealed interface Easing {

    val easeIn: EasingFunction
    val easeOut: EasingFunction
    val easeInOut: EasingFunction
}
```

### Calling

To call an easing function, simply address it by the easing style, select the easing function and call one of its
methods according to your needs:

```kotlin
fun main() {
    val eased1 = Linear.easeIn.ease(.5) // .5
    val eased2 = Linear.easeIn.ease(500.0, 120.0, 120.0, 1000.0) // 180, halfway between 120 and 240
}
```
## Available easing styles

- Back
- Bounce
- Circ
- Cubic
- Elastic
- Expo
- Linear
- Quad
- Quart
- Quint
- Sine

See them at [https://easings.net/](https://easings.net/).