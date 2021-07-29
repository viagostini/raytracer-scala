package object raytracer {
  val EPSILON: Double = 1e-5

  extension (a: Double)
    def ~==(b: Double): Boolean =
      if (math.abs(a - b) <= EPSILON) true else false
}
