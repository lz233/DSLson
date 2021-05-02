package ac.cn.lz233.dslson.utils.ktx

import ac.cn.lz233.dslson.element.Space
import java.lang.StringBuilder

fun StringBuilder.add(string: String): StringBuilder = append("${Space.value}$string")