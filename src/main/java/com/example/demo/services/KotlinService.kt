package com.example.demo.services

import com.example.demo.constant.ColorCodeConstant
import com.example.demo.constant.ColorCodeConstant.*
import com.example.demo.models.kotlin.PersonKt
import com.example.demo.models.kotlin.Rectangle
import com.example.demo.models.testModels.GFriend
import com.example.demo.services.interfaces.Windows
import org.springframework.stereotype.Service

@Service
class KotlinService {

    val serviceName = "KotlinService"

    var numberOfMethods = 1000

    val expressionIfToValue = if ("KotlinService".contentEquals(serviceName)) "hooray" else "nay"

    val createdList = arrayListOf("test")

    val stringTemplate = "Wow it can be any expressions inside this String Template. The value should be $expressionIfToValue and it really is! : ${if ("KotlinService".contentEquals(serviceName)) "hooray" else "nay"}"

    fun funExpressionBody() = println("Hello, world")

    fun explicitReturnType(): String {
        return "kook"
    }

    fun omitReturnType() = "kook"

    fun valIsValue() = "$serviceName is value and cannot be changed"

    fun varIsVariable() {
        println("now $serviceName has $numberOfMethods method")

        numberOfMethods = 1001

        println("now $serviceName has $numberOfMethods method")
    }

    fun addSomethingToList() {
        createdList.add("object that it points to may be mutable")
        createdList.forEach { value -> println(value) }
    }

    fun getExpressionVal() = println(stringTemplate)

    fun testPersonKt() {
        val personKt = PersonKt("readOnly", "editable").also {
            println(it.kotlinReadOnlyProperty)
            println(it.kotlinEditableProperty)
        }
//      personKt.kotlinReadOnlyProperty = "cannot be assigned"
    }

    fun testCreateJavaObject() {
        val gFriend = GFriend().apply {
            this.name = "Marry Jane"
        }.also {
            println(it.name)
        }

        /*
            note: lombok @Data getter and setter is not work.
             Java getter and setter boiler plate code need to be created
             in order to get value from private properties in java class
        */
    }

    fun testGetValProperty() {
        val rectangle = Rectangle(4, 4)
        println(rectangle.isSquare)
    }

    fun testWhenWithExpressionBody(colorCodeConstant: ColorCodeConstant) =
            when(colorCodeConstant) {
                RED -> "Red is hot"
                BLUE -> "Blue is ocean"
                GREEN -> "Green is wood"
                MAGENTA -> "Magenta is sweet"
                BLACK -> "Black is shadow"
            }

    fun testWhenWithMultipleBranch(colorCodeConstant: ColorCodeConstant) =
            when(colorCodeConstant) {
                RED, GREEN, BLUE -> "Main HUE"
                MAGENTA -> "Not main HUE"
                BLACK -> "All become one"
            }

    fun testSetOf(c1: ColorCodeConstant, c2: ColorCodeConstant) =
        when (setOf(c1, c2)) {
            setOf(RED, BLUE) -> MAGENTA
            setOf(RED, RED) -> RED
            else -> BLACK
        }

    fun testSmartCast(windows: Windows): String {
        return if (windows is SlideWindows) windows.status else "this is not a slide windows"
    }
}