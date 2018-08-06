package fpinscala.datastructures

import org.scalatest.{FunSpec, Matchers}

class ListSpec extends FunSpec with Matchers {
  describe("List") {
    it("evaluates the random function to 3") {
      List.aMatchFunction() should be(3)
    }
  }
}
