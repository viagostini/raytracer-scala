import raytracer.Vector
import org.scalatest.funsuite.AnyFunSuite

class VectorTests extends AnyFunSuite {

  test("Creating a Vector") {
    val vector = Vector(4.3, -4.2, 3.1)
    assert(vector.x == 4.3)
    assert(vector.y == -4.2)
    assert(vector.z == 3.1)
    assert(vector.w == 0)
  }

  test("Comparing two Vectors") {
    val actual = Vector(3.1, 2.5, 1.6)
    val expected = Vector(3.1, 2.5, 1.6)

    assert(actual == expected)
  }

  test("Adding two Vectors") {
    val vector = Vector(3, 2, 1)
    val other = Vector(5, 6, 7)

    val actual = vector + other
    val expected = Vector(8, 8, 8)

    assert(actual == expected)
  }

  test("Subtracting two Vectors") {
    val vector = Vector(3, 2, 1)
    val other = Vector(5, 6, 7)

    val actual = vector - other
    val expected = Vector(-2, -4, -6)

    assert(actual == expected)
  }

  test("Negating a Vector") {
    val vector = Vector(1, -2, 3)

    val actual = -vector
    val expected = Vector(-1, 2, -3)

    assert(actual == expected)
  }

  test("Multiplying a vector by a scalar") {
    val vector = Vector(1, -2, 3)

    val actual = vector * 3.5
    val expected = Vector(3.5, -7, 10.5)

    assert(actual == expected)
  }

  test("Dividing a vector by a scalar") {
    val vector = Vector(1, -2, 3)

    val actual = vector / 2
    val expected = Vector(0.5, -1, 1.5)

    assert(actual == expected)
  }

  test("Computing the magnitude of a Vector") {
    val vector = Vector(1, 2, 3)

    val actual = vector.magnitude
    val expected = math.sqrt(14)

    assert(actual == expected)
  }

  test("Normalizing a Vector") {
    val vector = Vector(1, 2, 3)

    val normalized = vector.normalized

    val actual = normalized.magnitude
    val expected = 1

    assert(actual == expected)
  }

  test("Dot product") {
    val vector = Vector(1, 2, 3)
    val that = Vector(2, 3, 4)

    val actual = vector.dot(that)
    val expected = 20

    assert(actual == expected)
  }

  test("Cross product") {
    val vector = Vector(1, 2, 3)
    val that = Vector(2, 3, 4)

    var actual = vector.cross(that)
    var expected = Vector(-1, 2, -1)
    assert(actual == expected)

    actual = that.cross(vector)
    expected = Vector(1, -2, 1)
    assert(actual == expected)
  }
}
