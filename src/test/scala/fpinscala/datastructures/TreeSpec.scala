package fpinscala.datastructures

import org.scalatest.{FunSpec, Matchers}

class TreeSpec extends FunSpec with Matchers {
  describe("size") {
    it("calculates a basic size example") {
      Tree.size(Branch(Leaf(1), Leaf(1))) shouldBe 3
    }

    it("calculates an uneven tree correctly") {
      Tree.size(Branch(Branch(Leaf(1), Leaf(1)), Leaf(1))) shouldBe 5
    }
  }
}
