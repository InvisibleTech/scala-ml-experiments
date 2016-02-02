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
  def y(m: Double, x: Double, b: Double): Double = m * x + b

  def yError(m: Double, b: Double, p: Point): Double = p.y - y(m, p.x, b)

  def totalError(m: Double, b: Double, points: List[Point]): Double = {
    Option(points.map(p => pow(yError(m, b, p), 2)).foldLeft(0.0)(_ + _) / points.size).filter(!_.isNaN).getOrElse(0.0)
  }

  def applyGradient(m: Double, b: Double, points: List[Point], learningRate: Double): (Double, Double) ={
    val derivativeC = -2.0/points.size
    val gradient: (Double, Double) = points.map(p => (derivativeC*p.x*yError(m, b, p), derivativeC*yError(m, b, p)))
                                .foldLeft((0.0, 0.0))((a, t) => (a._1+t._1, a._2+t._2))

    (m - (learningRate * gradient._1), b - (learningRate * gradient._2))                            
  }

  def optimizedFit(points: List[Point], startM: Double, startB: Double, learningRate: Double, iterations: Int): (Double, Double) = {
    var f = (startM, startB)

    var i = iterations
    while (i > 0) {
        f  =  applyGradient(f._1, f._2, points, learningRate)
        i -= 1
    }

    f
  } 

}