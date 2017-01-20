try {

def file = new File(basedir, 'target')
assert !file.exists()

// We expect that ScalaStyle _will not_ run on the parent, but that it _will_ run
// on the child. Thus, we should see _both_ the skip message from the parent run
// and the warning from the sub-module run.
assert new File(basedir, "build.log").readLines().grep(~/.*Skipping Scalastyle:check for packaging pom.*/).size() == 1
assert new File(basedir, "build.log").readLines().grep(~/.*warning.*Foobar.scala message=File length exceeds.*/).size() == 1

return true

} catch(Throwable e) {
  e.printStackTrace()
  return false
}
