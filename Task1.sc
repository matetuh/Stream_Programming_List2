//class PrimeNumber constructor
class PrimeNumber(val n: Int) {
  // function calculatePrimeNumbers which calculates all prime number
  // within the range between 2 and n
  // I am using 'Sieve of Eratosthenes' algorithm

  def calculatePrimeNumbers(n: Int): Unit = {
    // X is an array of Boolean 'true' values, indexed by integers 2 to n
<<<<<<< HEAD
    val X = new Array[Boolean](this.n)
    // let A be an array of Boolean values, indexed by integers 2 to n,
    // initially all set to true.
    for ( i <- 0 to X.length - 1) {
=======
    val X = new Array[Boolean](n+1)
    // let A be an array of Boolean values, indexed by integers 2 to n,
    // initially all set to true.
    for ( i <- 2 to  X.length - 1) {
>>>>>>> v2 - Working !
      X(i) = true
    }
    //
    var p = 2
    var i = 0
    while( p*p <= n ) {
      if (X(p) == true) {
        i = p*p
<<<<<<< HEAD
        while( i <= n + 1 ){
=======
        while( i <= n  ) {
>>>>>>> v2 - Working !
          X(i) = false
          i = i + p
        }
      }
<<<<<<< HEAD
      p += 1
    }
    // printing out the prime numbers
    for ( k <- 2 to X.length  ){
      if (X(k)) { println(k)}
    }
  }

=======
      p = p + 1
    }
    // printing out the prime numbers
    for ( k <- 2 to X.length - 1  ){
      if (X(k)) { println(k)}
    }
  }
>>>>>>> v2 - Working !
}

object Test {
  def main(args: Array[String]):Unit = {
    val A = new PrimeNumber(100)
    A.calculatePrimeNumbers(100)
  }
}





