import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import raytracer.{Point, Vector}

class PointTests extends AnyFunSuite with Matchers {
  test("Creating a Point") {
    val point = new Point(4.3, -4.2, 3.1)

    point.x shouldBe 4.3
    point.y shouldBe -4.2
    point.z shouldBe 3.1
    point.w shouldBe 0
  }

  test("Comparing two Points") {
    val actual = Point(3, -2, 5)
    val expected = Point(3, -2, 5)

    actual shouldBe expected
  }

  test("Adding two points") {
    val point = Point(3, -2, 5)
    val vector = Vector(-2, 3, 1)

    val actual = point + vector
    val expected = Point(1, 1, 6)

    actual shouldBe expected
  }

  test("Subtracting a vector from a point") {
    val point = Point(3, 2, 1)
    val other = Vector(5, 6, 7)

    val actual = point - other
    val expected = Point(-2, -4, -6)

    actual shouldBe expected
  }

  test("Subtracting two points") {
    val point = Point(3, 2, 1)
    val other = Point(5, 6, 7)

    val actual = point - other
    val expected = Vector(-2, -4, -6)

    actual shouldBe expected
  }

  test("Negating a Point") {
    val point = Point(1, -2, 3)

    val actual = -point
    val expected = Point(-1, 2, -3)

    actual shouldBe expected
  }

  test("Multiplying a point by a scalar") {
    val point = Point(1, -2, 3)

    val actual = point * 3.5
    val expected = Point(3.5, -7, 10.5)

    actual shouldBe expected
  }

  test("Dividing a point by a scalar") {
    val point = Point(1, -2, 3)

    val actual = point / 2
    val expected = Point(0.5, -1, 1.5)

    actual shouldBe expected
  }
}
