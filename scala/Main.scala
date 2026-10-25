package example.scala

object Main {
  def main(args: Array[String]): Unit = {
    val names = if (args.isEmpty) Seq("world") else args.toSeq
    println(Greeting.forNames(names))
  }
}
