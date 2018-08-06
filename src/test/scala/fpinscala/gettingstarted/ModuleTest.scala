package fpinscala.gettingstarted

import fpinscala.gettingstarted.Module._
import org.scalatest.{FunSpec, Matchers}

class ModuleTest extends FunSpec with Matchers {

  describe("isSorted") {
    it("handles sorted ints") {
      val as: Array[Int] = Array(1, 2, 3)
      isSorted(as, (x: Int, y: Int) => x <= y) should be(true)
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
