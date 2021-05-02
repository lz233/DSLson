package ac.cn.lz233.dslson.element

class StringElement : Element {
    var key = ""
    var value = ""

    override fun json() = if (key=="") "\"$value\"" else "\"$key\":\"$value\""
}