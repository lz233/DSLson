package ac.cn.lz233.dslson.element

class BooleanElement : Element {
    var key = ""
    var value = false

    override fun json() = if (key=="") "$value" else "\"$key\":$value"
}