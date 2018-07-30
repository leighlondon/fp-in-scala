package fpinscala.gettingstarted

object Module {

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))

  private def formatAbs(x: Int) =
    "The absolute value of %d is %d".format(x, abs(x))

  def abs(n: Int): Int =
    if (n < 0) -n
    else n
}
