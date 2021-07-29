import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import raytracer.Matrix

class MatrixTest extends AnyFunSuite with Matchers {
  val list4x4: List[List[Double]] = List(
    List(1, 2, 3, 4),
    List(5.5, 6.5, 7.5, 8.5),
    List(9, 10, 11, 12),
    List(13.5, 14.5, 15.5, 16.5)
  )

  val list4x4s: List[List[Double]] = List(
    List(1, 2, 3, 4),
    List(5.5, 6.5, 7.5, 8.5),
    List(9, 10, 11, 12),
    List(13.500001, 14.5, 15.5, 16.5)
  )

  test("Creating a matrix") {
    val matrix = Matrix(list4x4)

    matrix.width shouldBe 4
    matrix.height shouldBe 4

    matrix(0, 0) shouldBe 1
    matrix(0, 3) shouldBe 4
    matrix(1, 0) shouldBe 5.5
    matrix(1, 2) shouldBe 7.5
    matrix(2, 2) shouldBe 11
    matrix(3, 0) shouldBe 13.5
    matrix(3, 2) shouldBe 15.5

  }

  test("Comparing two matrices") {
    val mat1 = Matrix(list4x4)
    val mat2 = Matrix(list4x4s)

    mat1 shouldBe mat2
  }
}
