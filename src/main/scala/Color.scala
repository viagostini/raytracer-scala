package raytracer

class Color(val red: Double, val green: Double, val blue: Double) {
  def +(that: Color): Color =
    Color(red + that.red, green + that.green, blue + that.blue)

  def -(that: Color): Color =
    Color(red - that.red, green - that.green, blue - that.blue)

  def *(scalar: Double): Color =
    Color(red * scalar, green * scalar, blue * scalar)

  // Hadamard product
  def *(that: Color): Color =
    Color(red * that.red, green * that.green, blue * that.blue)

  def map(f: Double => Double): Color = Color(f(red), f(green), f(blue))

  def asPPM: String = f"${red.toInt} ${green.toInt} ${blue.toInt}"

  override def equals(that: Any): Boolean = that match {
    case that: Color => (red ~== that.red) && (green ~== that.green) && (blue ~== that.blue)
    case _           => false
  }

  override def toString: String = f"Color($red%0.2f $green%0.2f $blue%0.2f"
}

object Color {
  val BLACK = Color(0, 0, 0)
  val RED = Color(255, 0, 0)
}
