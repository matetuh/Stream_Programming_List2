// imported libraries
import java.lang
import scala.util.control.Breaks._
import scala.collection.immutable.Range
import scala.collection.mutable.ArrayBuffer
//class PascalTriangleRow constructor
class PascalTriangleRow (n: Int){
  // calculates all numbers of Pascal's triangle at n's row
  def calculate (n: Int): ArrayBuffer[Int] = {
    // X is an array of numbers of Pascal's triangle
    val X = new ArrayBuffer[Int]()
    // we set the first element of this array to 1
    X += 1
    // than we calculate this expression: https://en.wikipedia.org/wiki/Pascal%27s_triangle#Calculating_a_row_or_diagonal_by_itself
    // we append each number to the array
    for (i <- 0 to n - 1) {
      X += X(i) * (n - i) / (i + 1)
    }
    // we are returning that array
    return X
  }

  // definition of factor function
  // we are returning the m'th item of the N array
  def factor(m: Int):Unit ={
    var N = new ArrayBuffer[Int](this.n)
    N = calculate(this.n)
    print(m)
    print(" - ")
    println(N(m))
  }
}

// we create Test2 object
object Test2 {
  // with a method main which for the first argument creates a Pascal's triangle
  // line and then for the nest arguments prints the appropriate values of this line
  def main(args: Array[String]): Unit = {
    // we are creating an input array of length equals the number of input numbers
    var inp = new Array[Int](args.length)

    // definition of function isNumeric that's check if the input string is number of text
    def isNumeric(str: String) = try {
      // if we can transform the string to int, we return true
      str.toInt
      true
    } catch {
      // on the other situation we return false
      case e: NumberFormatException =>
        false
    }
    // now we loop throught all of arguments of input
    for (i <- 0 until args.length) {
      // and we check if it is numeric
      if (isNumeric(args(i))) {
        // if yes, than
        // we set all input values as convertion string arguments to Integer
        inp(i) = args(i).toInt
        // we are creating an new class A of PascalTriangleRow
        val A = new PascalTriangleRow(inp(0))
        // we check if input is smaller than 0 or greater than argument of PascalTriangleRow function
        if(inp(i) < 0 || inp(i) > inp(0)) {
          // if yes we print the elements
          print(args(i))
          println(" - out of range number ")
          // if the first argument is smaller than 0, then we break the loop, because it has no sense anymore
          if( inp(0) < 0 ) {break}
        }
       // if no, than
       else {
         // if the i is greater than one
         // it means we call the factor method from PascalTr.. class after first argument
         if ( i > 0) { A.factor(inp(i)) }
       }
      }
      // or not numeric
      else if (!isNumeric(args(i))) {
        // than we print that
        print(args(i))
        println(" - invalid argument ")
      }
    }
  }
}

