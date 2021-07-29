package raytracer

case class Matrix(cells: List[List[Double]]) {
  val height: Int = cells.length
  val width: Int = if cells.isEmpty then 0 else cells.head.length

  def apply(i: Int, j: Int): Double = cells(i)(j)

  override def equals(that: Any): Boolean = that match {
    case that: Matrix => {
      val a = for {
        i <- 0 until height
        j <- 0 until width
      } yield this(i, j) ~== that(i, j)

      a.forall(_ == true)
    }
    case _ => false
  }
}
