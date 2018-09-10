package fpinscala.datastructures

import fpinscala.datastructures.List._
import org.scalatest.{FunSpec, Matchers}

class ListSpec extends FunSpec with Matchers {
  describe("drop") {
    it("drops the right amount of heads") {
      drop(List(1, 2, 3, 4), 3) shouldBe List(4)
    }

    it("remains nil for a nil list") {
      drop(Nil, 1) shouldBe Nil
    }

    it("remains calm for sufficiently large n") {
      drop(List(1), 100000) shouldBe Nil
    }
  }

  describe("init") {
    it("handles .init correctly") {
      init(List(1, 2, 3, 4)) shouldBe List(1, 2, 3)
    }
  }

  describe("length") {
    it("handles nil input") {
      len(Nil: List[Int]) shouldBe 0
    }

    it("calculates length for regular lists") {
      len(List(1, 2, 3)) shouldBe 3
    }

    it("counts strings not individual characters") {
      len(List("abcde", "fghij")) shouldBe 2
    }
  }

  describe("reverse") {
    it("handles the example usage case") {
      reverse(List(1, 2, 3)) shouldBe List(3, 2, 1)
    }

    it("handles the string cases") {
      reverse(List("abc", "def", "ghi")) shouldBe List("ghi", "def", "abc")
    }
  }

  describe("appendUsingFold") {
    it("appends regular lists correctly") {
      appendUsingFold(List(0, 1), List(2, 3)) shouldBe List(0, 1, 2, 3)
    }

    it("handles two empty lists properly") {
      appendUsingFold(List[Int](), List[Int]()) shouldBe List[Int]()
    }

    it("can take an empty prefix list") {
      appendUsingFold(List[Int](), List(0)) shouldBe List(0)
    }

    it("can take an empty suffix list") {
      appendUsingFold(List(100), List[Int]()) shouldBe List(100)
    }
  }

  describe("concat") {
    it("works with trivial examples") {
      concat(List(List(0), List(1))) shouldBe List(0, 1)
    }
  }

  describe("addOne") {
    it("adds basic example") {
      addOne(List(1, 2, 3)) shouldBe List(2, 3, 4)
    }

    it("handles negative and zero case") {
      addOne(List(-100, -50, 0)) shouldBe List(-99, -49, 1)
    }
  }

  describe("doubleToString") {
    it("handles trivial case") {
      doubleToString(List(0.0)) shouldBe List("0.0")
    }
  }

  describe("map") {
    it("works to implement .addOne") {
      map(List(0, 1, 2))(_ + 1) shouldBe List(1, 2, 3)
    }

    it("works to implement .doubleToString") {
      map(List(0.0, 10.0))(_.toString) shouldBe List("0.0", "10.0")
    }
  }

  describe("filter") {
    it("can remove all odd numbers from a list") {
      filter(List(1, 2, 3, 4))(_ % 2 == 0) shouldBe List(2, 4)
    }

    it("doesn't change list if filter doesn't match") {
      filter(List(1, 2, 3, 4, 5))(_ => true) shouldBe List(1, 2, 3, 4, 5)
    }

    it("works for a stringy function") {
      filter(List("abc", "def", "ghij"))(_.length() == 3) shouldBe List("abc", "def")
    }
  }

  describe("flatMap") {
    it("handles the provided example") {
      flatMap(List(1, 2, 3))(i => List(i, i)) shouldBe List(1, 1, 2, 2, 3, 3)
    }
  }

  describe("filterWithFlatMap") {
    it("can remove all odd numbers from a list") {
      filterWithFlatMap(List(1, 2, 3, 4))(_ % 2 == 0) shouldBe List(2, 4)
    }

    it("doesn't change list if filter doesn't match") {
      filterWithFlatMap(List(1, 2, 3, 4, 5))(_ => true) shouldBe List(1, 2, 3, 4, 5)
    }

    it("works for a stringy function") {
      filterWithFlatMap(List("abc", "def", "ghij"))(_.length() == 3) shouldBe List("abc", "def")
    }
  }

  describe("zip") {
    it("handles the provided example") {
      zip(List(1, 2, 3), List(4, 5, 6)) shouldBe List(5, 7, 9)
    }
  }

  describe("zipWith") {
    it("works for the zip example") {
      zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) shouldBe List(5, 7, 9)
    }

    it("works for strings too") {
      zipWith(List("a", "b"), List("x", "y"))(_ + _) shouldBe List("ax", "by")
    }
  }

  describe("hasSubsequence") {
    it("works with the provided examples") {
      pending
      hasSubsequence(List(1, 2, 3, 4), List(1, 2)) shouldBe true
      hasSubsequence(List(1, 2, 3, 4), List(2, 3)) shouldBe true
      hasSubsequence(List(1, 2, 3, 4), List(4)) shouldBe true
    }
  }
}
