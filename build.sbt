name := "castle-retry"

organization := "com.box"

licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.2" % "test"
)

ivyXML :=
  <dependencies>
    <exclude org="org.slf4j" module="slf4j-log4j12"/>
    <exclude org="org.slf4j" module="slf4j-simple"/>
    <exclude org="org.slf4j" module="slf4j-nop"/>
    <exclude org="com.sun.jmx" module="jmxri"/>
    <exclude org="com.sun.jdmk" module="jmxtools"/>
    <exclude org="javax.jms" module="jms"/>
  </dependencies>


publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) {
    Some("snapshots" at nexus + "content/repositories/snapshots")
  } else {
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
}

// externalResolvers := resolvers map { rs =>
//  Resolver.withDefaultResolvers(rs, mavenCentral = true)
// }

licenses += ("Castle License", url("https://github.com/Box-Castle/retry/blob/master/LICENSE"))

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := {
  <url>https://github.com/Box-Castle/retry</url>
  <scm>
    <url>git@github.com:Box-Castle/retry.git</url>
    <connection>scm:git:git@github.com:Box-Castle/retry.git</connection>
  </scm>
  <developers>
    <developer>
      <id>denisgrenader</id>
      <name>Denis Grenader</name>
      <url>http://github.com/denisgrenader</url>
    </developer>
  </developers>
}
