/**
 * Delegates.lazy() is a function that returns a delegate that implements a lazy property:
 * the first call to get() executes the lambda expression passed to lazy() as an argument
 * and remembers the result, subsequent calls to get() simply return the remembered result.
 * If you want thread safety, use blockingLazy() instead: it guarantees that the values will
 * be computed only in one thread, and that all threads will see the same value.
 */

class LazySample {
    val lazyStr: String by lazy(mode = LazyThreadSafetyMode.PUBLICATION) {
        println("computed! by ${Thread.currentThread()}")
        "my lazy string"
    }
}

class LazyThread(val sample : LazySample?) : Thread() {
    override fun run() {
        println("Thread: lazyStr = ${sample?.lazyStr}")
     }
}

fun main(args: Array<String>) {
    val sample = LazySample()
    
    Thread({  
      println("\tThread ${Thread.currentThread()}: lazyStr = ${sample.lazyStr}")
    }).start()

    Thread({  
      println("\tThread ${Thread.currentThread()}: lazyStr = ${sample.lazyStr}")
    }).start()

    println("\tMain ${Thread.currentThread()}: lazyStr = ${sample.lazyStr}")
    println("\tMain ${Thread.currentThread()}: lazyStr = ${sample.lazyStr}")
}