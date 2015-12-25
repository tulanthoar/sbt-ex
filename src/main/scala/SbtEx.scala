import scala.language.postfixOps
import scala.collection.mutable.LinkedHashSet

/** @object App
 *  @author ${user.name}
 */
object SbtEx {

  def main( args : Array[String] ) {
    println( "Sbt Ex!" )
    try {
      println( "cat args = "+( args tail ).foldLeft( args head )( _+", "+_ ) )
    }
    catch {
      case _ : java.lang.UnsupportedOperationException => println ( "bad args" )
      case _ : java.lang.Exception                     => println ( "unknown exception" )
    }
    val set = new LinkedHashSet[Any]
    var boss = new Company()
    boss setName ( "the boss" )
    val pt = new BasicPoint( 5, 6 )
    set += boss // add a class
    set += boss.getName // add a string
    set += pt // add a val
    set += main _ // add a function
    set foreach ( println _ ) // call print ln on everything
  }

}
