package raytracer

class Point(val x: Double, val y: Double, val z: Double, val w: Int = 0) {
  def +(that: Vector): Point = Point(x + that.x, y + that.y, z + that.z)
  def -(that: Point): Vector = Vector(x - that.x, y - that.y, z - that.z)
  def -(that: Vector): Point = Point(x - that.x, y - that.y, z - that.z)

  def *(scalar: Double): Point = Point(x * scalar, y * scalar, z * scalar)
  def /(scalar: Double): Point = Point(x / scalar, y / scalar, z / scalar)

  def unary_- : Point = Point(-x, -y, -z)

  override def equals(that: Any): Boolean = that match {
    case that: Point => (x ~== that.x) && (y ~== that.y) && (z ~== that.z)
    case _           => false
  }

  override def toString = s"Point($x, $y, $z)"
}
