package example.scala

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class GreetingTest extends AnyFlatSpec with Matchers {
  "Greeting" should "capitalize and join names" in {
    Greeting.forNames(Seq("bazel", "world")) mustBe "Hello, Bazel, World!"
  }
}
