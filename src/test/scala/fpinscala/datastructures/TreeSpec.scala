package fpinscala.datastructures

import fpinscala.datastructures.Tree.{depth, maximum}
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

  describe("maximum") {
    it("handles a singular case") {
      maximum(Leaf(1)) shouldBe 1
    }

    it("handles branches") {
      maximum(Branch(Leaf(1), Leaf(2))) shouldBe 2
    }

    it("calculates maximum in a full tree") {
      maximum(Branch(Branch(Leaf(10), Leaf(20)), Leaf(30))) shouldBe 30
    }
  }

  describe("depth") {
    it("should be zero for a single leaf") {
      depth(Leaf(1)) shouldBe 0
    }

    it("is correct for basic branch") {
      depth(Branch(Leaf("a"), Leaf("b"))) shouldBe 1
    }
  }
}
