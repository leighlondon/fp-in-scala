package fpinscala.gettingstarted

object Fibonacci {
  def apply(n: Int): Int = {
    @annotation.tailrec
    def fib(n: Int, b: Int, a: Int): Int =
      if (n <= 0) a
      else fib(n - 1, a = a + b, b = a)

    fib(n, 1, 0)
  }
}
