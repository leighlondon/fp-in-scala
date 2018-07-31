package fpinscala.gettingstarted

import org.scalatest.{FunSpec, Matchers}

class FibonacciSpec extends FunSpec with Matchers {
  describe("Fibonacci") {
    it("handles the base case") {
      Fibonacci(1) should be(1)
    }

    it("handles the second case") {
      Fibonacci(2) should be(1)
    }

    it("handles the third case") {
      Fibonacci(3) should be(2)
    }

    it("handles the fourth case") {
      Fibonacci(4) should be(3)
    }
  }
}
