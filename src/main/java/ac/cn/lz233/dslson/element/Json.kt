package ac.cn.lz233.dslson.element

import ac.cn.lz233.dslson.utils.ktx.add

fun json(block: Json.() -> Unit) = Json().apply(block).json()

class Json {
    private val children = ArrayList<Element>()

    fun element(key: String = "", block: JsonObject.() -> Unit) {
        val jsonObject = JsonObject()
        jsonObject.key = key
        jsonObject.block()
        children.add(jsonObject)
    }

    fun array(key: String = "", block: JsonArray.() -> Unit) {
        val jsonArray = JsonArray()
        jsonArray.key = key
        jsonArray.block()
        children.add(jsonArray)
    }

    fun json() = StringBuilder().apply {
        for (child in children) append("${child.json()},")
        deleteCharAt(lastIndex)
    }.toString()
}