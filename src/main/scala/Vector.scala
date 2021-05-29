package raytracer

class Vector(val x: Double, val y: Double, val z: Double, val w: Int = 0) {
  def +(that: Vector): Vector = Vector(x + that.x, y + that.y, z + that.z)

  def -(that: Vector): Vector = Vector(x - that.x, y - that.y, z - that.z)

  def *(scalar: Double): Vector = Vector(x * scalar, y * scalar, z * scalar)

  def /(scalar: Double): Vector = Vector(x / scalar, y / scalar, z / scalar)

  def unary_- : Vector = Vector(-x, -y, -z)

  def ==(that: Vector): Boolean =
    almostEqual(x, that.x) && almostEqual(y, that.y) && almostEqual(z, that.z)

  def magnitude: Double = math.sqrt(x * x + y * y + z * z)

  def normalized: Vector = this / magnitude

  def dot(that: Vector): Double = { x * that.x + y * that.y + z * that.z }

  def cross(that: Vector): Vector = Vector(
    y * that.z - z * that.y,
    z * that.x - x * that.z,
    x * that.y - y * that.x
  )

  override def toString = s"Vector($x, $y, $z)"
}
