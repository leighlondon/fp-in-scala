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

  describe("flatMap") {
    it("maps from left to left") {
      Left("test").flatMap(Right(_)) shouldBe Left("test")
    }

    it("maps from right to either") {
      Right(2).flatMap((i: Int) => Right[Int](i + 2)) shouldBe Right(4)
    }
  }

  describe("orElse") {
    it("works for left") {
      Left("test").orElse(Left("error")) shouldBe Left("error")
    }

    it("works for right") {
      Right(2).orElse(Left("unused")) shouldBe Right(2)
    }
  }

  describe("sequence") {
    it("returns left if there is an error") {
      Either.sequence(List(Right(2), Left(1))) shouldBe Left(1)
    }

    it("returns a list when there are no errors") {
      Either.sequence(List(Right(2), Right(3), Right(1))) shouldBe Right(List(2, 3, 1))
    }
  }
}
