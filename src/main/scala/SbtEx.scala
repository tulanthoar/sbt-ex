import scala.language.postfixOps
import scala.collection.mutable.LinkedHashSet

/** @object App
 *  @author ${user.name}
 */
object SbtEx {

  def main( args : Array[String] ) {
    println( "Sbt Ex!" )
    println( "concat arguments = " + args.foldLeft( "()" )( _+" and "+_ ) )
    val set = new scala.collection.mutable.LinkedHashSet[Any]
    var boss = new Company()
    boss setName ("the boss")
    val pt = new BasicPoint( 5, 6 )
    set += boss // add a class
    set += boss.getName // add a string
    set += pt // add a val
    set += main _ // add a function
    set foreach ( println _ ) // call print ln on everything
  }

}
