package fpinscala.gettingstarted

import org.scalatest.{FunSpec, Matchers}

class FibonacciSpec extends FunSpec with Matchers {
  describe("Fibonacci") {
    it("handles the base case") {
      Fibonacci(1) should be(1)
    }
  }
}
