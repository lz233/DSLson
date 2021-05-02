package ac.cn.lz233.dslson.element

import ac.cn.lz233.dslson.utils.ktx.add
import java.lang.StringBuilder

class JsonObject : Element {
    private val children = ArrayList<Element>()
    var key = ""

    fun element(key: String, block: JsonObject.() -> Unit) {
        val jsonObject = JsonObject()
        jsonObject.key = key
        jsonObject.block()
        children.add(jsonObject)
    }

    fun array(key: String, block: JsonArray.() -> Unit) {
        val jsonArray = JsonArray()
        jsonArray.key = key
        jsonArray.block()
        children.add(jsonArray)
    }

    fun int(key: String, value: Int) = children.add(IntElement().apply {
        this.key = key
        this.value = value
    })

    fun float(key: String, value: Float) = children.add(FloatElement().apply {
        this.key = key
        this.value = value
    })

    fun boolean(key: String, value: Boolean) = children.add(BooleanElement().apply {
        this.key = key
        this.value = value
    })

    fun string(key: String, value: String) = children.add(StringElement().apply {
        this.key = key
        this.value = value
    })

    override fun json() = StringBuilder().apply {
        if (key != "") append("\"$key\":")
        append("{") //Space + 2
        for (child in children) append("${child.json()},") //delete(lastIndex, lastIndex)
        deleteCharAt(lastIndex) //Space - 2
        append("}")
    }.toString()
}