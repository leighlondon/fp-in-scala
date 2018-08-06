package fpinscala.gettingstarted

import fpinscala.gettingstarted.Module._
import org.scalatest.{FunSpec, Matchers}

class ModuleSpec extends FunSpec with Matchers {

  def sortedInts(x: Int, y: Int): Boolean = x < y

  describe("isSorted") {
    it("handles sorted ints") {
      val as: Array[Int] = Array(1, 2, 3)
      isSorted(as, (x: Int, y: Int) => x <= y) should be(true)
    }

    it("returns true for a single entry") {
      val data: Array[Array[Int]] = (0 to 10).map(x => Array(x)).toArray
      data foreach (oneNumber =>
        isSorted(oneNumber, sortedInts) should be(true))
    }

    it("handles negatives properly") {
      val as: Array[Int] = Array(-1, 0, 1)
      isSorted(as, sortedInts) should be(true)
    }
  }

  describe("fib") {
    it("handles standard cases") {
      val data = Map(
        0 -> 1,
        1 -> 1,
        2 -> 2,
        3 -> 3,
        4 -> 5,
        5 -> 8,
        6 -> 13
      )
      data foreach { case (num: Int, value: Int) =>
        fib(num) should be(value)
      }
    }
  }
}
