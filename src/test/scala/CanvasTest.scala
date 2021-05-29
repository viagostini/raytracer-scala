import org.scalatest.funsuite.AnyFunSuite
import raytracer.{Canvas, Color}
import org.scalatest.matchers.should.Matchers

class CanvasTest extends AnyFunSuite with Matchers {

  test("Create a Canvas") {
    val canvas = Canvas(10, 20)

    canvas.width shouldBe 10
    canvas.height shouldBe 20

    val pixels_flat = canvas.pixels.flatMap(_.toList)

    pixels_flat should contain only Color.BLACK
  }

  test("Write pixels to a Canvas") {
    val canvas = Canvas(10, 20)
    val red = Color(1, 0, 0)

    canvas(2, 3) = red
    canvas(2, 3) shouldBe red

    assertThrows[IndexOutOfBoundsException] {
      canvas(2, 100) = red
    }
  }

  test("Write small PPM") {
    val canvas = Canvas(5, 3)

    val c1 = Color(1.5, 0, 0)
    val c2 = Color(0, 0.5, 0)
    val c3 = Color(-0.5, 0, 1)

    canvas(0, 0) = c1
    canvas(2, 1) = c2
    canvas(4, 2) = c3

    canvas.ppmLines shouldBe """255 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                               |0 0 0 0 0 0 0 128 0 0 0 0 0 0 0
                               |0 0 0 0 0 0 0 0 0 0 0 0 0 0 255""".stripMargin
  }
}
