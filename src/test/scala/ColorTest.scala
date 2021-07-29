import raytracer.Color
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ColorTests extends AnyFunSuite with Matchers {

  test("Creating a Color") {
    val color = Color(4.3, -4.2, 3.1)
    color.red shouldBe 4.3
    color.green shouldBe -4.2
    color.blue shouldBe 3.1
  }

  test("Comparing two Colors") {
    val actual = Color(3.1, 2.5, 1.6)
    val expected = Color(3.1, 2.5, 1.6)

    actual shouldBe expected
  }

  test("Adding two Colors") {
    val color = Color(3, 2, 1)
    val other = Color(5, 6, 7)

    val actual = color + other
    val expected = Color(8, 8, 8)

    actual shouldBe expected
  }

  test("Subtracting two Colors") {
    val color = Color(3, 2, 1)
    val other = Color(5, 6, 7)

    val actual = color - other
    val expected = Color(-2, -4, -6)

    actual shouldBe expected
  }

  test("Hadamard product") {
    val color = Color(1, 0.2, 0.4)
    val that = Color(0.9, 1, 0.1)

    val actual = color * that
    val expected = Color(0.9, 0.2, 0.04)

    actual shouldBe expected
  }
}
