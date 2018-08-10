package fpinscala.datastructures

import org.scalatest.{FunSpec, Matchers}

class ListSpec extends FunSpec with Matchers {
  describe("List") {
    it("evaluates the match expression to 3") {
      List.x_from_match should be(3)
    }
  }

  describe(".drop") {
    it("drops the right amount of heads") {
      val list = List(1, 2, 3, 4)
      List.drop(list, 3) should be(List(4))
    }

    it("remains nil for a nil list") {
      List.drop(Nil, 1) should be(Nil)
    }

    it("remains calm for sufficiently large n") {
      List.drop(List(1), 100000) should be(Nil)
    }
  }

  describe(".init") {
    it("handles .init correctly") {
      List.init(List(1, 2, 3, 4)) should be(List(1, 2, 3))
    }
  }

  describe(".length") {
    it("handles nil input") {
      List.length(Nil: List[Int]) should be(0)
    }

    it("calculates length for regular lists") {
      List.length(List(1, 2, 3)) should be(3)
    }

    it("counts strings not individual characters") {
      List.length(List("abcde", "fghij")) should be(2)
    }
  }

  describe(".reverse") {
    it("handles the example usage case") {
      List.reverse(List(1, 2, 3)) should be(List(3, 2, 1))
    }

    it("handles the string cases") {
      List.reverse(List("abc", "def", "ghi")) should be(List("ghi", "def", "abc"))
    }
  }

  describe(".appendUsingFold") {
    it("appends regular lists correctly") {
      List.appendUsingFold(List(0, 1), List(2, 3)) should be(List(0, 1, 2, 3))
    }

    it("handles two empty lists properly") {
      List.appendUsingFold(List[Int](), List[Int]()) should be(List[Int]())
    }

    it("can take an empty prefix list") {
      List.appendUsingFold(List[Int](), List(0)) should be(List(0))
    }

    it("can take an empty suffix list") {
      List.appendUsingFold(List(100), List[Int]()) should be(List(100))
    }
  }
}
