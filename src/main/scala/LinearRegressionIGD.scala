/*
Based on:
    https://github.com/mattnedrich/GradientDescentExample/blob/master/gradient_descent_example.py
    http://spin.atomicobject.com/2014/06/24/gradient-descent-linear-regression/

Iterative Gradient Descent
[1] Fixed iterations
[2] No Stochastic restarts
[3] Just for fun

*/
package org.invisibletech.scalamlexperiments

import scala.math.pow

object LinearRegressionIGD {
  def optimizedFit(points: List[Point]): (Double, Double) = {
    (0, 0)
  }

  def y(m: Double, x: Double, b: Double): Double = m * x + b

  def totalError(m: Double, b: Double, points: List[Point]): Double = {
    Option(points.map(p => pow(p.y - y(m, p.x, b), 2)).foldLeft(0.0)(_ + _) / points.size).filter(!_.isNaN).getOrElse(0.0)
  }
}