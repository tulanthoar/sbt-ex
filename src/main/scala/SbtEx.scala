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

    val mixedSet = new LinkedHashSet[AnyRef]
    val boss = { val c = new Company(); c setName "the boss"; c }
    mixedSet += new Company() // add a ".java" class
    mixedSet += boss toString () // add its name (a string)
    mixedSet += new BasicPoint( 5, 6 ) // add a ".scala" class
    mixedSet += main _ // add a function
    mixedSet foreach println _: Unit // call println on everything

    val megaCompany = new LinkedHashSet[AnyRef] //a mega set of 50 companies
    for ( _ <- 0 to 50 ) { megaCompany add new Company } // fill it with minions
    // print the object hash as a name (not a robust solution)
    println ( "Our generated companies are named" )
    // println each entry but fisrt apply hashCode toString to each element
    megaCompany map ( _.hashCode toString ) foreach println _

  }

}
