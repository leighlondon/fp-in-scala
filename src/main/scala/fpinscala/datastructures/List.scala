package fpinscala.datastructures

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// The 'List' companion object, to provide functions for creating and working
// with these lists.
object List {

  // Exercise 3.1, evaluating a match expression
  val x3: Int = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _)))          => x
    case Nil                                   => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t)                            => h + sum(t)
    case _                                     => 101
  }

  def sum(is: List[Int]): Int = is match {
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil          => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs)  => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: List[A]): List[A] = l match {
    case Nil           => Nil
    case Cons(_, tail) => tail
  }

  def setHead[A](l: List[A], head: A): List[A] = l match {
    case Nil        => Cons(head, Nil)
    case Cons(_, t) => Cons(head, t)
  }

  @tailrec
  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l
    else l match {
      case Nil        => Nil
      case Cons(_, t) => drop(t, n - 1)
    }

  @tailrec
  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t)(f)
    case _                  => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil        => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil          => Nil
    case Cons(_, Nil) => Nil
    case Cons(h, t)   => Cons(h, init(t))
  }

  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil        => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil         => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(ns: List[Int]): Int =
    foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]): Double =
    foldRight(ns, 1.0)(_ * _)

  def len[A](as: List[A]): Int =
    foldRight(as, 0)((_, z) => z + 1)

  /* Implementing sum and product with foldLeft. */
  def sum3(ns: List[Int]): Int =
    foldLeft(ns, 0)(_ + _)

  def product3(ns: List[Double]): Double =
    foldLeft(ns, 1.0)(_ * _)

  def len2[A](l: List[A]): Int =
    foldLeft(l, 0)((z, _) => z + 1)

  def reverse[A](l: List[A]): List[A] =
    foldLeft(l, List[A]())((t, h) => Cons(h, t))

  def appendUsingFold[A](h: List[A], t: List[A]): List[A] =
    foldRight(h, t)(Cons(_, _))

  /**
    * Expand a list of lists and concatenate into one list.
    *
    * @param list the list of lists
    * @tparam A the inner type
    * @return the concatenated list
    */
  def concat[A](list: List[List[A]]): List[A] =
    foldLeft(list, List[A]())(append)

  /**
    * Transform a list of ints by adding one to each, using fold.
    *
    * @param list the input ints
    * @return a new list of ints
    */
  def addOne(list: List[Int]): List[Int] =
    foldLeft(list, List[Int]())((l, a) => append(l, Cons(a + 1, Nil)))

  /**
    * Convert a list of doubles to their string representations, using fold.
    *
    * @param list the input doubles
    * @return a new list
    */
  def doubleToString(list: List[Double]): List[String] =
    foldLeft(list, List[String]())((l, d) => append(l, Cons(d.toString, Nil)))

  /**
    * Transform a list by applying a function f to each element.
    *
    * @param as the immutable input list
    * @param f  the function to apply to each element
    * @tparam A the type in the input list
    * @tparam B the type in the output list
    * @return a new list after applying the function
    */
  def map[A, B](as: List[A])(f: A => B): List[B] =
    foldLeft(as, List[B]())((l, a) => append(l, Cons(f(a), Nil)))

  /**
    * Filter a list using a function f.
    *
    * @param as the immutable input list
    * @param f  function to filter the list on
    * @tparam A the type of the input (and output)
    * @return a new list after filtering
    */
  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    foldRight(as, Nil: List[A])((h, t) => if (f(h)) Cons(h, t) else t)

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    concat(map(as)(f))

  def filterWithFlatMap[A](as: List[A])(f: A => Boolean): List[A] =
    flatMap(as)(a => if (f(a)) List(a) else Nil)

  def zip(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (Nil, _)                   => Nil: List[Int]
    case (_, Nil)                   => Nil: List[Int]
    case (Cons(a, as), Cons(b, bs)) => Cons(a + b, zip(as, bs))
  }

  def zipWith[A](as: List[A], bs: List[A])(f: (A, A) => A): List[A] = (as, bs) match {
    case (Nil, _)                   => Nil: List[A]
    case (_, Nil)                   => Nil: List[A]
    case (Cons(x, xs), Cons(y, ys)) => Cons(f(x, y), zipWith(xs, ys)(f))
  }
}
