import sbtcrossproject.{crossProject, CrossType}

lazy val bar = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .settings(scalaVersion := "2.11.8")

lazy val barJS     = bar.js
lazy val barJVM    = bar.jvm
lazy val barNative = bar.native

lazy val buzz = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .settings(scalaVersion := "2.11.8")

lazy val buzzJS     = buzz.js
lazy val buzzJVM    = buzz.jvm
lazy val buzzNative = buzz.native

lazy val foo = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .settings(scalaVersion := "2.11.8")
  .aggregate(bar, buzz)
  .dependsOn(bar, buzz)

lazy val fooJS = foo.js
lazy val fooJVM = foo.jvm
lazy val fooNative = foo.native
