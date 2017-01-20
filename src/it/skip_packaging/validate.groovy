try {

def file = new File(basedir, 'target')
assert !file.exists()

// We don't expect ScalaStyle to run, but rather we expect a message about it
// being skipped due to the packaging type being pom and `skipPackaging` being
// set.
assert new File(basedir, "build.log").readLines().grep(~/.*Skipping Scalastyle:check for packaging pom.*/).size() == 1

return true

} catch(Throwable e) {
  e.printStackTrace()
  return false
}
