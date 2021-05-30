package raytracer

import java.io.{File, PrintWriter}

class Canvas(val width: Int, val height: Int, fill_color: Color = Color.BLACK) {
  val pixels: Array[Array[Color]] = Array.fill(width, height)(fill_color)

    def update(i: Int, j: Int, color: Color): Unit =
        if valid_index(i, j) then
            pixels(i)(j) = color
        else
            throw new IndexOutOfBoundsException("This position is outside the canvas!")

    def apply(i: Int, j: Int): Color = pixels(i)(j)

    private def valid_index(i: Int, j: Int): Boolean =
        if (i < 0 || i >= width || j < 0 || j >= height) false else true

    def savePPM(name: String): Unit =
        val fileObject = new File(name)
        val printWriter = new PrintWriter(fileObject)
        printWriter.write(ppmHeader + ppmLines)
        printWriter.close()

    def ppmLines: String =
        pixels.transpose.map(ppmLine).flatMap(splitLongLines).mkString("\n")

    def ppmLine(pixel_row: Array[Color]): String =
        pixel_row
          .map(c => c.map(clamp))
          .map(_.asPPM)
          .mkString(" ")

    private def splitLongLines(line: String): List[String] = {
        if line.length < 70 then
            List(line)
        else
            val (left, right) = line.splitAt(line.lastIndexWhere(_.isSpaceChar, 70))
            List(left) ++ splitLongLines(right.trim)
    }

    private def clamp(intensity: Double): Double =
        math.min(math.max(math.ceil(intensity * 255), 0), 255)

    private def ppmHeader = s"P3\n$width $height\n255\n"
}
