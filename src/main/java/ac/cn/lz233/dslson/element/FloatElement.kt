package ac.cn.lz233.dslson.element

class FloatElement : Element {
    var key = ""
    var value = 0.0f

    override fun json() = if (key=="") "$value" else "\"$key\":$value"
}