// imported libraries
import java.lang
import scala.util.control.Breaks._
import scala.collection.immutable.Range
import scala.collection.mutable.ArrayBuffer
//class PrimeNumber constructor
class PrimeNumber(n : Int){
  // function calculatePrimeNumbers which calculates all prime number
  // within the range between 2 and n
  // I am using 'Sieve of Eratosthenes' algorithm
  def calculatePrimeNumbers(n: Int): ArrayBuffer[Int] = {
    // X is an array of Boolean 'true' values, indexed by integers 2 to n
    val X = new Array[Boolean](n+1)
    // let A be an array of Boolean values, indexed by integers 2 to n,
    // initially all set to true.
    for ( i <- 2 to  X.length - 1) {
      X(i) = true
    }
    // let the variable p equal 2, this is the first prime number
    var p = 2
    var i = 0
    // we are starting from p^2, counting up in increments of p and
    // we mark each of these numbers greater than or equal to p^2
    // these numbers will be p(p+1), p(p+2), p(p+3)..
    while( p*p <= n ) {
      // if X[p] is not changed, then it is prime
      if (X(p) == true) {
        // we set the i variable to be p * p
        i = p*p
        while( i <= n  ) {
          // we update all multiples of p greater than or equal to the square of it
          // numbers which are multiple of p and are less than p^2 already been marked
          X(i) = false
          i = i + p
        }
      }
      // we increase the p variable to p + 1
      p = p + 1
    }
    var Out = new ArrayBuffer[Int]()
    // we append all prime numbers to the Out ArrayBuffer
    for ( k <- 2 to X.length - 1  ){
      // if in array X(k) we found true variable
      // than we append the iterator k to the Out ArrayBuffer
      if (X(k)) {
        Out += k
      }
    }
    return Out
  }
  // the number function which prints the prime nnumbers
  def number(n: Int):Unit ={
    var m = calculatePrimeNumbers(this.n)
    print(n)
    print(" - ")
    println(m(n))
  }
}

// the Test object
object Test {
  // we define the main function
  def main(args: Array[String]): Unit = {
    // we define the inp variable to be array of length of input args array
    var inp = new Array[Int](args.length)
    // we define function that chech if the input strings to agrgs array are numbers of plain text
    def isNumeric(str: String) = try {
      // if we can convert the string to integer than return true
      str.toInt
      true
    } catch {
          // else return false
      case e: NumberFormatException =>
        false
    }
    // we are looping throught the args array (input variables as string)
    for (i <- 1 to args.length - 1) {
      // we check if they are numbers
      if (isNumeric(args(i))) {
        // if yes, we create an new PrimeNumber class of n = to first string input
        val A = new PrimeNumber(args(0).toInt)
        // then we converts all another number to integer
        inp(i) = args(i).toInt
        // if the input is numbers are less than zero
        // or the numbers are greater than the length of 'Out'.lenght from 'calculatePrimeNumbers'
        if(inp(i) < 0 || A.calculatePrimeNumbers(args(0).toInt).length <= inp(i)) {
          print(args(i))
          println(" - out of range number ")
          // if the first argument of input is less than zero than break the program
          if(args(0).toInt < 0) { break }
        }
        else {
          // if all is OK, than print the prime numbers
          if( i > 0) {A.number(inp(i))}
        }
      }
        // if the numbers aren't numbers
      else if (!isNumeric(args(i))) {
        print(args(i))
        println(" - invalid argument ")
      }
    }
  }
}






