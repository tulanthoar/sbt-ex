import scala.language.postfixOps
import scala.collection.mutable.LinkedHashSet
import java.lang.Exception
import java.lang.UnsupportedOperationException

/** @object SbtEx
 *  @author Nate Yonkee
 */
object SbtEx {

  def main( args: Array[String] ) {

    println( "Sbt Ex!" )
    try println( "cat args = " + ( args tail ).foldLeft ( args head ) ( _ + " " + _ ) )
    catch {
      case _: UnsupportedOperationException => println ( "bad args" )
      case _: Exception                     => println ( "unknown exception" )
    }
  }
/*
    val set = new LinkedHashSet[AnyRef]
    val boss = { val c = new Company(); c setName "the boss"; c }
    set += boss // add the result of a method
    set += boss toString () // add its name (a string)
    set += new BasicPoint( 5, 6 ) // add a class
    set += main _ // add a function
    set foreach println _: Unit // call println on everything
*/
    /*
    val megaCompany = new LinkedHashSet[AnyRef] //a mega set of 50 companies
    for ( _ <- 0 to 50 ) { megaCompany add new Company } // fill it with minions
    // assign every minion a convenient name
    println ( "Our generated companies are named" )
    megaCompany foreach ( ( c: AnyRef ) => println( c.hashCode toString ) )
  }
*/
