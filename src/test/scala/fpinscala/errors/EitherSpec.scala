package fpinscala.errors

import org.scalatest.{FunSpec, Matchers}

import scala.util.{Either => _, Left => _, Right => _}

class EitherSpec extends FunSpec with Matchers {
  describe("map") {
    it("maps left to left") {
      Left("test").map(_.toString.toUpperCase()) shouldBe Left("test")
    }

    it("maps right to right") {
      Right(2).map(_ + 2) shouldBe Right(4)
    }
  }
}
