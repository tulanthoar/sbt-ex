// factor out common settings into a sequence
lazy val commonSettings = Seq(
  organization := "com.github.tulanthoar",
  // package version
  version := "0.1.0",
  // set the Scala version used for the project
  scalaVersion := "2.11.7",
  // Cache all managed dependencies to <build-root>/lib_managed/
  retrieveManaged := true,
  // append several options to the list of options passed to the Java compiler
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  // append -deprecation and -featur to the options passed to the Scala compiler
  scalacOptions ++= Seq("-deprecation", "-feature"),
  // set the prompt (for the current project) to include the username and +projectname
  shellPrompt := { state => user + " " + (Project extract state).currentRef.project + "> " },
  // change the format of how sbt prints time
  timingFormat := {
    import java.text.{DateFormat => DForm}
    DForm.getDateTimeInstance(DForm.SHORT, DForm.SHORT)
  }
)

// this is an alternavive to "run" that input user name, os type, and achitecture
import System.{getProperty => sysProp}
lazy val runUsingInfo = taskKey[Unit]("Runs the main class with project name and my name: ")
val user = sysProp("user.name")
val os = sysProp("os.name")
val arch = sysProp("os.arch")

lazy val sbtEx = (project in file(".")). // build project in directory "."
  settings(commonSettings: _*). // use common settings
  settings(
    // set the name of the project
    name := "sbtEx",
    // define our custom function
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
  )