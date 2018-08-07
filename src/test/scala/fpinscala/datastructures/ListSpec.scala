package fpinscala.datastructures

import org.scalatest.{FunSpec, Matchers}

class ListSpec extends FunSpec with Matchers {
  describe("List") {
    it("evaluates the x match expression to 3") {
      List.x should be(3)
    }

    it("drops the right amount of heads") {
      val list = List(1,2,3,4)
      List.drop(list, 3) should be(List(4))
    }

    it("remains nil for a nil list") {
      List.drop(Nil, 1) should be(Nil)
    }

    it("remains calm for sufficiently large n") {
      List.drop(List(1), 100000) should be(Nil)
    }
  }
}
