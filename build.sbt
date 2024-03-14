
 //scalaVersion := "2.13.8"
scalaVersion := "2.13.10"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xfatal-warnings",
  "-language:reflectiveCalls",
)


/*
val chiselVersion = "3.5.6"
addCompilerPlugin("edu.berkeley.cs" %% "chisel3-plugin" % chiselVersion cross CrossVersion.full)
libraryDependencies += "edu.berkeley.cs" %% "chisel3" % chiselVersion
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "0.5.6"
*/

val chiselVersion = "3.6.0"
addCompilerPlugin("edu.berkeley.cs" %% "chisel3-plugin" % chiselVersion cross CrossVersion.full)
libraryDependencies += "edu.berkeley.cs" %% "chisel3" % chiselVersion
libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "0.6.2"


//val chiselVersion = "5.1.0"
//addCompilerPlugin("org.chipsalliance" % "chisel-plugin" % chiselVersion cross CrossVersion.full)
//libraryDependencies += "org.chipsalliance" %% "chisel" % chiselVersion
//libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "5.0.2"


/*
val chiselVersion = "6.0.0-RC1"
addCompilerPlugin("org.chipsalliance" % "chisel-plugin" % chiselVersion cross CrossVersion.full)
libraryDependencies += "org.chipsalliance" %% "chisel" % chiselVersion
// libraryDependencies += "edu.berkeley.cs" %% "chiseltest" % "5.0.2"
*/
