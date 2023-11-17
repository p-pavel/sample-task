class TriangleTest extends munit.FunSuite:
  test("Building simple path") {
    val w = 10
    val left,right = Path.empty
    val res = Path.choose(w, left,right)
    assertEquals(res, Path(w, Seq(w)))
  }
