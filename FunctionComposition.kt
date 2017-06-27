/**
 * The composition function return a composition of two functions passed to it:
 * compose(f, g) = f(g(*)).
 * Now, you can apply it to callable references.
 */

fun main(args: Array<String>) {
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))
}

fun isOdd(x: Int) : Boolean = x % 2 != 0
fun length(s: String) : Int = s.length


/**
 * Composer function taking 2 parameters function f and function g and 
 * returns a composed function defined as f(g(x)) where x is an element
 * being applied to the composed function.
 * 
 * @param f function taking as input the output of param g (Type B) and
 * which output is returned (Type C)
 * @param g function taking as input the element being checked (Type A)
 * and which output is served as input for function f (Type B)
 * @return output of param f(g(x)) (Type C)
 */
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}
