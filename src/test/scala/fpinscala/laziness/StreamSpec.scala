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
        case _          => true should not be true
      }
    }
  }

  describe("forAll") {
    it("evaluates true when all match") {
      Stream(1, 3, 5).forAll(_ % 2 == 1) shouldBe true
    }

    it("evaluates false when there is a fail") {
      Stream(1, 2, 3).forAll(_ % 2 == 1) shouldBe false
    }
  }

  describe("headOptionWithFoldRight") {
    it("returns some when there is a head"){
      Stream(1).headOptionWithFoldRight shouldBe Some(1)
    }

    it("returns none when there is no head") {
      Empty.headOptionWithFoldRight shouldBe None
    }
  }
}
