package fpinscala.gettingstarted

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class FibonacciSpec extends FunSpec with Matchers {
  describe("Fibonacci") {
    it("handles the base case") {
      Fibonacci(1) should be(1)
    }
  }
}
