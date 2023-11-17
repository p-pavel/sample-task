class TriangleTest extends munit.FunSuite:
  test("Building simple path") {
    val w = 10
    val left,right = Path.empty
    val res = Path.choose(w, left,right)
    assertEquals(res, Path(w, Seq(w)))
  }

  test("Single row storage") {
    val data = Seq(Seq(10,20,30))
    val res = Path.walkData(data)
    val expected = Seq(Path(10, Seq(10)), Path(20, Seq(20)), Path(30, Seq(30)))
    assertEquals(res, expected)
  }
  
  
