# compute the path in the triangle

Initial thoughts: 

- while the task seems like a Dejkstra algorithm (finding a path in a graph)
we're actually faced with much simple setup

- we can probably read the numbers into the structure like Seq[Seq[Int]]
and walk recursively bottom to top.

  - for any point of data we need a best path and the weight of this path