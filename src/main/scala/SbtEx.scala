import scala.language.postfixOps
import java.lang.{ UnsupportedOperationException => OpError }
import java.lang.{ Exception => BaseError }
import scala.collection.mutable.LinkedHashSet

/** @object App
 *  @author ${user.name}
 */
object SbtEx {

  def main( args: Array[String] ) {
    println( "Sbt Ex!" )
    try {
      println( "cat args = " + ( args tail ).foldLeft( args head )( _ + ", " + _ ) )
    }
    catch {
      case _: OpError   => println ( "bad args" )
      case _: BaseError => println ( "unknown exception" )
    }
    val set = new LinkedHashSet[Any]
    var boss = new Company()
    boss setName ( "the boss" )
    val pt = new BasicPoint( 5, 6 )
    set += boss // add a class
    set += boss.getName // add a string
    set += pt // add a val
    set += main _ // add a function
    set foreach println: Unit // call print ln on everything
  }

}
