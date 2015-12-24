import scala.language.postfixOps
import scala.collection.mutable.LinkedHashSet

/** @object App
 *  @author ${user.name}
 */
object SbtEx {

  def foo( x : Array[String] ) = x.foldLeft( " ="  )( ( a, b ) => a+" and "+b )

  def main( args : Array[String] ) {
    println( "Sbt Ex!" )
    println( "concat arguments"+foo( args ) )
    println( "Hi from envy" )
      val set = new scala.collection.mutable.LinkedHashSet[Any]
          var boss = new Company()
    boss setName "company name" 
    val pt = new BasicPoint(5, 6)
  set += boss  // add a string
  set += boss.getName()                // add a number
  set += pt
  set += main _
    set foreach (println(_))
  }

}
  
