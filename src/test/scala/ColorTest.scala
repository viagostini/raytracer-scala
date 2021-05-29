import raytracer.Color
import org.scalatest.funsuite.AnyFunSuite

class ColorTests extends AnyFunSuite {

  test("Creating a Color") {
    val color = Color(4.3, -4.2, 3.1)
    assert(color.red == 4.3)
    assert(color.green == -4.2)
    assert(color.blue == 3.1)
  }

  test("Comparing two Colors") {
    val actual = Color(3.1, 2.5, 1.6)
    val expected = Color(3.1, 2.5, 1.6)

    assert(actual == expected)
  }

  test("Adding two Colors") {
    val color = Color(3, 2, 1)
    val other = Color(5, 6, 7)

    val actual = color + other
    val expected = Color(8, 8, 8)

    assert(actual == expected)
  }

  test("Subtracting two Colors") {
    val color = Color(3, 2, 1)
    val other = Color(5, 6, 7)

    val actual = color - other
    val expected = Color(-2, -4, -6)

    assert(actual == expected)
  }

  test("Hadamard product") {
    val color = Color(1, 0.2, 0.4)
    val that = Color(0.9, 1, 0.1)

    val actual = color * that
    val expected = Color(0.9, 0.2, 0.04)

    assert(actual == expected)
  }
}
