package fpinscala.gettingstarted

object Module {

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))

  private def formatAbs(x: Int): String = formatResult("absolute value", x, abs)

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def formatResult(name: String, n: Int, f: Int => Int): String = {
    "The %s of %d is %d.".format(name, n, f(n))
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)
    }

    loop(0)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)
}
