/** Rows of the triangle. Should have valid shape */
type TriangleData = Seq[Seq[Int]]
type Weight = Int

case class Path(weight: Weight, vertices: Seq[Weight])

object Path: 
  /** induction basis*/
  def empty = Path(0, Seq.empty)
  def choose(w: Weight, left: Path, right: Path) = 
    val candidate = if left.weight < right.weight then left else right
    Path(w + candidate.weight, w +: candidate.vertices)

@main
def computePath = 
  println("Hello")

