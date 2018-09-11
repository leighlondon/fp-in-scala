package fpinscala.errors

import scala.{Either => _, Option => _, Some => _}

sealed trait Option[+A] {

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f) getOrElse None

  def map[B](f: A => B): Option[B] = this match {
    case None    => None
    case Some(a) => Some(f(a))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case None    => default
    case Some(a) => a
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

  def filter(f: A => Boolean): Option[A] = ???
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
