package ac.cn.lz233.dslson.element

class IntElement : Element {
    var key = ""
    var value = 0

    override fun json() = if (key=="") "$value" else "\"$key\":$value"
}