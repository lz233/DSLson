package ac.cn.lz233.dslson.element

object Space {
    var value = ""
    operator fun plus(int: Int) = repeat(int) { value = "$value " }
    operator fun minus(int: Int) = value.removeRange((value.lastIndex - int)..value.lastIndex)
}