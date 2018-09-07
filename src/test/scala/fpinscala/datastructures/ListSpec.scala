package fpinscala.datastructures

import fpinscala.datastructures.List._
import org.scalatest.{FunSpec, Matchers}

class ListSpec extends FunSpec with Matchers {
  describe("List") {
    it("evaluates the match expression to 3") {
      x_from_match should be(3)
    }
  }

  describe("drop") {
    it("drops the right amount of heads") {
      drop(List(1, 2, 3, 4), 3) should be(List(4))
    }

    it("remains nil for a nil list") {
      drop(Nil, 1) should be(Nil)
    }

    it("remains calm for sufficiently large n") {
      drop(List(1), 100000) should be(Nil)
    }
  }

  describe("init") {
    it("handles .init correctly") {
      init(List(1, 2, 3, 4)) should be(List(1, 2, 3))
    }
  }

  describe("length") {
    it("handles nil input") {
      len(Nil: List[Int]) should be(0)
    }

    it("calculates length for regular lists") {
      len(List(1, 2, 3)) should be(3)
    }

    it("counts strings not individual characters") {
      len(List("abcde", "fghij")) should be(2)
    }
  }

  describe("reverse") {
    it("handles the example usage case") {
      reverse(List(1, 2, 3)) should be(List(3, 2, 1))
    }

    it("handles the string cases") {
      reverse(List("abc", "def", "ghi")) should be(List("ghi", "def", "abc"))
    }
  }

  describe("appendUsingFold") {
    it("appends regular lists correctly") {
      appendUsingFold(List(0, 1), List(2, 3)) should be(List(0, 1, 2, 3))
    }

    it("handles two empty lists properly") {
      appendUsingFold(List[Int](), List[Int]()) should be(List[Int]())
    }

    it("can take an empty prefix list") {
      appendUsingFold(List[Int](), List(0)) should be(List(0))
    }

    it("can take an empty suffix list") {
      appendUsingFold(List(100), List[Int]()) should be(List(100))
    }
  }

  describe("concat") {
    it("works with trivial examples") {
      concat(List(List(0), List(1))) should be(List(0, 1))
    }
  }

  describe("addOne") {
    it("adds basic example") {
      addOne(List(1, 2, 3)) should be(List(2, 3, 4))
    }

    it("handles negative and zero case") {
      addOne(List(-100, -50, 0)) should be(List(-99, -49, 1))
    }
  }

  describe("doubleToString") {
    it("handles trivial case") {
      doubleToString(List(0.0)) should be(List("0.0"))
    }
  }

  describe("map") {
    it("works to implement .addOne") {
      map(List(0, 1, 2))(_ + 1) should be(List(1, 2, 3))
    }

    it("works to implement .doubleToString") {
      map(List(0.0, 10.0))(_.toString) should be(List("0.0", "10.0"))
    }
  }

  describe("filter") {
    it("can remove all odd numbers from a list") {
      filter(List(1, 2, 3, 4))(_ % 2 == 0) should be(List(2, 4))
    }

    it("doesn't change list if filter doesn't match") {
      filter(List(1, 2, 3, 4, 5))(_ => true) should be(List(1, 2, 3, 4, 5))
    }

    it("works for a stringy function") {
      filter(List("abc", "def", "ghij"))(_.length() == 3) should be(List("abc", "def"))
    }
  }

  describe("flatMap") {
    it("handles the provided example") {
      flatMap(List(1, 2, 3))(i => List(i, i)) should be(List(1, 1, 2, 2, 3, 3))
    }
  }

  describe("filterWithFlatMap") {
    it("can remove all odd numbers from a list") {
      filterWithFlatMap(List(1, 2, 3, 4))(_ % 2 == 0) should be(List(2, 4))
    }

    it("doesn't change list if filter doesn't match") {
      filterWithFlatMap(List(1, 2, 3, 4, 5))(_ => true) should be(List(1, 2, 3, 4, 5))
    }

    it("works for a stringy function") {
      filterWithFlatMap(List("abc", "def", "ghij"))(_.length() == 3) should be(List("abc", "def"))
    }
  }

  describe("zip") {
    it("handles the provided example") {
      pending
      zip(List(1, 2, 3), List(4, 5, 6)) should be(List(5, 7, 9))
    }
  }
}
