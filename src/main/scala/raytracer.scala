package object raytracer {
  val EPSILON: Double = 1e-5

  def almostEqual(a: Double, b: Double): Boolean =
    if (math.abs(a - b) <= EPSILON) true else false
}
