package fpinscala.laziness

import org.scalatest.{FunSpec, Matchers}

class StreamSpec extends FunSpec with Matchers {
  describe("toList") {
    it("streams into a list") {
      Stream("test").toList shouldBe List("test")
    }

    it("streams a multi entry stream to a list") {
      Stream("a", "b", "c").toList shouldBe List("a", "b", "c")
    }
  }

  describe("drop") {
    it("drops the first few elements") {
      Stream("a", "b").drop(1) match {
        case Cons(h, _) => h() shouldBe "b"
      }
    }
  }
}
