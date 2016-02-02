package org.invisibletech.scalamlexperiments

import org.scalatest.FunSpec

import LinearRegressionIGD._

class LinearRegressionGDSpec extends FunSpec {
  import org.scalactic._
  import TripleEquals._
  implicit val doubleEquality = TolerantNumerics.tolerantDoubleEquality(0.001)

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

  describe("Gradient appply function ") {
    it("Should return a tuple of (m, b) given the correct starting point") {
      val l = List(Point(2.0, 5.0), Point(3.0, 7.0))

      // We know from test above that m = 2.0 and b = 1.0 in the correct solution
      assert((2.0, 1.0) == applyGradient(2.0, 1.0, l, 0.5))
    }

    it("Should return a tuple of (m, b) given an empty list") {
      val l = List[Point]()

      assert((2.0, 1.0) == applyGradient(2.0, 1.0, l, 0.5))
    }

    it("Should return a tuple of (19.0, 5.0) given a starting point of (0, 0) and a learning rate of 1.0") {
      val l = List(Point(5.0, 3.0), Point(2.0, 2.0))

      // We know from test above that m = 2.0 and b = 1.0 in the correct solution
      assert((19.0, 5.0) == applyGradient(0.0, 0.0, l, 1.0))
    }

    it("Should return a tuple of (1.9, 0.5) given a starting point of (0, 0) and a learning rate of 0.1") {
      val l = List(Point(5.0, 3.0), Point(2.0, 2.0))

      assert(1.9 === applyGradient(0.0, 0.0, l, 0.1)._1)
      assert(0.5 === applyGradient(0.0, 0.0, l, 0.1)._2)
    }
  }

  describe("Optimized Fit should come close given a step size of 0.01 and 1500 iterations") {
    it("Should come close") {
      val l = List(Point(-3, -15), Point(1, 1), Point(5, 17), Point(8, 29), Point(12, 45))

      val (m, b) = optimizedFit(l, 0.0, 0.0, 0.01, 1500)
      assert(4.0 === m)
      assert(-3.0 === b)
    }
  }
}
