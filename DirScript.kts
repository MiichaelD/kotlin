import java.io.File

// for (i in args.indices) {
for (value in args) {
  println("Listing folders under ${value}:") 
  val folders = File(value).listFiles { file -> file.isDirectory() }
  folders?.forEach { folder -> println("\t${folder}") }
}