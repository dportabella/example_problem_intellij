# example project that fails on IntelliJ


## Preparation: Import problematic warcbase dependency.
This project uses a dependency from the local maven repo. Extract from build.sbt:
```
resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.warcbase" % "warcbase-core" % "0.1.0-SNAPSHOT",
  "xml-apis" % "xml-apis" % "1.4.01"
)
```

So, build this warcbase dependencies and publish it to your locally:

```
$ git clone http://github.com/lintool/warcbase.git
$ cd warcbase
$ mvn install
```



## Build and run an example from the terminal
Clone this example repo, and execute:
```
$ sbt -Dspark.master=local[2] "runMain application.SparkPi 1000"

...
[info] Running org.apache.spark.examples.SparkPi 1000
16/07/18 13:13:53 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Pi is roughly 3.1418342
[success] Total time: 32 s, completed Jul 18, 2016 1:14:20 PM
```

It works fine.


## Build and run from IntelliJ

IntelliJ -> Import project -> [find spark-examples/build.sbt]

All the errors should go away once IntelliJ automatically downloads all the dependencies (this takes a while).

Menu -> Run -> Edit Configurations -> + -> Application
```
Name: SparkPi
Main class: application.SparkPi
VM Options: -Dspark.master=local[2]
Program parameters: 1000
```

Menu -> Run -> Run SparkPi

It fails on runtime with many dependencies, for instance hadoop. Adding the dependency manually, then it fails with another.

Why this work on the terminal, and not from IntelliJ?

I find a lot of similar problems on IntelliJ, and I am very fed up.

I use:
```
OSX 10.11.6

IntelliJ IDEA Ultimate 2016.2.4
Build #IU-162.2032.8, built on September 9, 2016
JRE: 1.8.0_112-release-b343 x86_64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
```
