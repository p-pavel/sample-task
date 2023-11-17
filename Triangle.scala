/** Rows of the triangle. Should have valid shape */
type TriangleData = Seq[Seq[Int]]
type Weight = Int

case class Path(weight: Weight, vertices: Seq[Weight]):
  /** In actual system this method does not belong here
   * but for the task ... */
  def formatForResponse = 
    val pathString =vertices.mkString(" + ") 
    s"Minimal path is: $pathString  = $weight"

object Path: 
  /** induction basis*/
  val empty = Path(0, Seq.empty)
  def choose(w: Weight, left: Path, right: Path) = 
    val candidate = if left.weight < right.weight then left else right
    Path(w + candidate.weight, w +: candidate.vertices)
  def walkData(data: TriangleData): Seq[Path] = 
    require(data.length > 0)
    val reversed = data.reverse
    def computePaths(previous: Seq[Path], current: Seq[Weight]): Seq[Path] = 
      require(previous.length == current.length + 1)
      current.zipWithIndex.map {(weight, index) => 
        Path.choose(weight, previous(index), previous(index+1))
      }
    
    val phony: Seq[Path] = Seq.fill(reversed.head.length + 1)(empty)
    reversed.foldLeft(phony)(computePaths)
@main
def computePath = 
  println("Hello")

