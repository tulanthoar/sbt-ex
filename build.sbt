// factor out common settings into a sequence
lazy val commonSettings = Seq(
  organization := "org.myproject",
  version := "0.1.0",
// set the Scala version used for the project
  scalaVersion := "2.11.7",

  // Copy all managed dependencies to <build-root>/lib_managed/
  retrieveManaged := true,
  
  // append several options to the list of options passed to the Java compiler
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),

  // append -deprecation to the options passed to the Scala compiler
  scalacOptions ++= Seq("-deprecation", "-feature"),
  
  // set the prompt (for the current project) to include the username
  shellPrompt := { state => user + " " + (Project extract state).currentRef.project + "> " },
 
  timingFormat := {
    import java.text.DateFormat
    DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)
  }
)

lazy val runUsingInfo = taskKey[Unit]("Runs the main class with project name and my name: ")
lazy val user = System getProperty "user.name"
lazy val os = System getProperty "os.name"
lazy val arch = System getProperty "os.arch"

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    // set the name of the project
    name := "app",

 // The argument string for the first run task is ' <name> <version>'
 
    runUsingInfo := {
      import System.nanoTime
      import java.lang.InterruptedException
      import java.lang.Exception
      println("We can use System.nanoTime to time only this command.")
      println("We can use the results of Scala expressions as inputs too!")
      try {  
        val start = nanoTime
        val _ = (run in Compile).toTask( " name: " + user + " OS: " + os + " arch: " + arch ).value
        Thread sleep 1;                 
        println("Done!, elapsed time " + (nanoTime - start - 1e6).toString + " ns")
      } catch{
        case _: InterruptedException => (Thread currentThread) interrupt()
        case _: Exception => println ("unknown exception")
      }
    }


    // change the format used for printing task completion time
    
    
  )