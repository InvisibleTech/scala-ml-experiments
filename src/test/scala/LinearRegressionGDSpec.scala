package org.invisibletech.scalamlexperiments

import org.scalatest.FunSpec

import LinearRegressionIGD._

class LinearRegressionGDSpec extends FunSpec {
  describe("Error function for scoring candidate slope and intercept") {
    it("Should return 0.0 for empty lists of Points") {
      val l = List[Point]()

      assert(0.0 == totalError(1.0, 1.0, l))
    }

    it("Should return y^2/1 for m=0 b=0") {
      val l = List(Point(100.0, 2.0))

      assert(4.0 == totalError(0.0, 0.0, l))
    }

    it("Should return x^2/1 for m=1.0 b=0 y=0") {
      val l = List(Point(10.0, 0.0))

      assert(100.0 == totalError(1.0, 0.0, l))
    }

    it("Should return 0 for m=2.0 b=1.0 y=f(x)") {
      val l = List(Point(2.0, 5.0), Point(3.0, 7.0))

      assert(0.0 == totalError(2.0, 1.0, l))
    }
  }
}
