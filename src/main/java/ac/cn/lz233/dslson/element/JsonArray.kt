package ac.cn.lz233.dslson.element

import ac.cn.lz233.dslson.utils.ktx.add
import java.lang.StringBuilder

class JsonArray : Element {
    private val children = ArrayList<Element>()
    var key = ""

    fun element(block: JsonObject.() -> Unit) {
        val jsonObject = JsonObject()
        jsonObject.block()
        children.add(jsonObject)
    }

    fun array(block: JsonArray.() -> Unit) {
        val jsonArray = JsonArray()
        jsonArray.block()
        children.add(jsonArray)
    }

    fun int(value: Int) = children.add(IntElement().apply { this.value = value })

    fun float(value: Float) = children.add(FloatElement().apply { this.value = value })

    fun boolean(value: Boolean) = children.add(BooleanElement().apply { this.value = value })

    fun string(value: String) = children.add(StringElement().apply { this.value = value })

    override fun json() = StringBuilder().apply {
        if (key != "") append("\"$key\":")
        append("[") //Space + 2
        for (child in children) append("${child.json()},") //delete(lastIndex, lastIndex)
        deleteCharAt(lastIndex) //Space - 2
        append("]")
    }.toString()
}