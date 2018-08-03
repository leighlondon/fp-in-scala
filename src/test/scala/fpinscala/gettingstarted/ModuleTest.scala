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
}
