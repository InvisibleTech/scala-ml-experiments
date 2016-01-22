package org.invisibletech.scalamlexperiments

import org.scalatest.FunSpec

import LinearRegression._

class LinearRegressionSpec extends FunSpec {
  describe("Two variable linear regression") {
    it("should find expected slope and intercept"){
        val l = List(Point(-3, -15), Point(1, 1), Point(5, 17), Point(8, 29), Point(12, 45))
        assert((4.0, -3.0) == LinearRegression.optimizedFit(l))
    }
  }
}

