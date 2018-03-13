
lazy val root = Project(
  id = "test-main",
  base = file(".")
//).settings(
//    unmanagedSources in (ThisProject, Compile, compile) := (baseDirectory.value / "submodule").**("*.scala").get,
//  unmanagedSources in (ThisProject, Compile, compile) ++= (baseDirectory.value / "project").**("*.scala").get,
)
  .aggregate(submodule)

lazy val submodule = project("submodule")
  .settings(
    unmanagedSources in Compile := (baseDirectory.value / ".." / "project").**("*.scala").get
)

def project(name: String) =
  Project(id = name, base = file(name))
