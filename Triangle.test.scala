/** does some very basic input validation */
def readData(src: io.Source): TriangleData =
  val res = src.getLines().map(_.trim).filter(_.nonEmpty).zipWithIndex.map {
    (line, index) =>
      val numbers = line.split(" ").map(_.toInt)
      assert(
        numbers.length == index + 1,
        s"Wrong number of data items in line $line"
      )
      numbers.toSeq
  }
  res.toSeq

class TriangleTest extends munit.FunSuite:
  val taskData = Seq(
    Seq(7),
    Seq(6, 3),
    Seq(3, 8, 5),
    Seq(11, 2, 10, 9)
  )

  test("Building simple path") {
    val w = 10
    val left, right = Path.empty
    val res = Path.choose(w, left, right)
    assertEquals(res, Path(w, Seq(w)))
  }

  test("Single row storage") {
    val data = Seq(Seq(10, 20, 30))
    val res = Path.walkData(data)
    val expected = Seq(Path(10, Seq(10)), Path(20, Seq(20)), Path(30, Seq(30)))
    assertEquals(res, expected)
  }

  test("Task storage") {
    val res = Path.walkData(taskData)
    assertEquals(res, Seq(Path(18, Seq(7, 6, 3, 2))))
    assertEquals(
      res.head.formatForResponse,
      "Minimal path is: 7 + 6 + 3 + 2  = 18"
    )
  }

  test("Reading task data") {
    val data = """
     7
     6 3

    3 8 5
    11 2 10 9    """

    val res = readData(io.Source.fromString(data))
    assertEquals(res, taskData)

  }
