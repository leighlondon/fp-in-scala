package fpinscala.errors

import org.scalatest.{FunSpec, Matchers}

import scala.{Option => _, Some => _}

class OptionSpec extends FunSpec with Matchers {
  describe("map") {
    it("works for the same type") {
      Some(1) map (_ * 2) shouldBe Some(2)
    }

    it("works for different types") {
      Some(1) map (_.toString) shouldBe Some("1")
    }

    it("works for none as well") {
      None map (_.toString) shouldBe None
    }
  }

  describe("getOrElse") {
    it("works for basic case") {
      Some(100) getOrElse None shouldBe 100
    }

    it("works with none") {
      None getOrElse None shouldBe None
    }
  }

  describe("flatMap") {
    it("works for some type") {
      Some(100) flatMap ((i: Int) => Some(i * 2)) shouldBe Some(200)
    }

    it("works with none as well") {
      Some(100000) flatMap (_ => None) shouldBe None
    }

    it("goes from none to none in five seconds") {
      None flatMap (_ => None) shouldBe None
    }
  }

  describe("orElse") {
    it("handles some type") {
      Some(1) orElse Some(200) shouldBe Some(1)
    }

    it("handles none type") {
      None orElse Some(200) shouldBe Some(200)
    }
  }

  describe("filter") {
    it("works for trivial case") {
      Some(1) filter (_ => true) shouldBe Some(1)
    }

    it("works for negative case") {
      Some(1) filter (_ => false) shouldBe None
    }

    it("works for none") {
      None filter(_ => true) shouldBe None
      None filter(_ => false) shouldBe None
    }
  }
}
