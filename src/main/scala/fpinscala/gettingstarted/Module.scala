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
}
