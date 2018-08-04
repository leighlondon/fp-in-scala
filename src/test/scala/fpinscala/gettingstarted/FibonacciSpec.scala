package fpinscala.gettingstarted

import fpinscala.gettingstarted.Module.fib
import org.scalatest.{FunSpec, Matchers}

class FibonacciSpec extends FunSpec with Matchers {
  describe("fib") {
    it("handles the base case") {
      fib(1) should be(1)
    }

    it("handles the second case") {
      fib(2) should be(1)
    }

    it("handles the third case") {
      fib(3) should be(2)
    }

    it("handles the fourth case") {
      fib(4) should be(3)
    }
  }
}
