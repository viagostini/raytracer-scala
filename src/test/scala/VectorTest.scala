import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import raytracer.Vector

class VectorTests extends AnyFunSuite with Matchers {

  test("Creating a Vector") {
    val vector = Vector(4.3, -4.2, 3.1)
    vector.x shouldBe 4.3
    vector.y shouldBe -4.2
    vector.z shouldBe 3.1
    vector.w shouldBe 0
  }

  test("Comparing two Vectors") {
    val actual = Vector(3.1, 2.5, 1.6)
    val expected = Vector(3.1, 2.5, 1.6)

    actual shouldBe expected
  }

  test("Adding two Vectors") {
    val vector = Vector(3, 2, 1)
    val other = Vector(5, 6, 7)

    val actual = vector + other
    val expected = Vector(8, 8, 8)

    actual shouldBe expected
  }

  test("Subtracting two Vectors") {
    val vector = Vector(3, 2, 1)
    val other = Vector(5, 6, 7)

    val actual = vector - other
    val expected = Vector(-2, -4, -6)

    actual shouldBe expected
  }

  test("Negating a Vector") {
    val vector = Vector(1, -2, 3)

    val actual = -vector
    val expected = Vector(-1, 2, -3)

    actual shouldBe expected
  }

  test("Multiplying a vector by a scalar") {
    val vector = Vector(1, -2, 3)

    val actual = vector * 3.5
    val expected = Vector(3.5, -7, 10.5)

    actual shouldBe expected
  }

  test("Dividing a vector by a scalar") {
    val vector = Vector(1, -2, 3)

    val actual = vector / 2
    val expected = Vector(0.5, -1, 1.5)

    actual shouldBe expected
  }

  test("Computing the magnitude of a Vector") {
    val vector = Vector(1, 2, 3)

    val actual = vector.magnitude
    val expected = math.sqrt(14)

    actual shouldBe expected
  }

  test("Normalizing a Vector") {
    val vector = Vector(1, 2, 3)

    val normalized = vector.normalized

    val actual = normalized.magnitude
    val expected = 1

    actual shouldBe expected
  }

  test("Dot product") {
    val vector = Vector(1, 2, 3)
    val that = Vector(2, 3, 4)

    val actual = vector.dot(that)
    val expected = 20

    actual shouldBe expected
  }

  test("Cross product") {
    val vector = Vector(1, 2, 3)
    val that = Vector(2, 3, 4)

    var actual = vector.cross(that)
    var expected = Vector(-1, 2, -1)
    actual shouldBe expected

    actual = that.cross(vector)
    expected = Vector(1, -2, 1)
    actual shouldBe expected
  }
}
