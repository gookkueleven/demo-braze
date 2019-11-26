package com.example.demo.services

import com.example.demo.constant.ColorCodeConstant
import com.example.demo.constant.ColorCodeConstant.*
import com.example.demo.models.kotlin.PersonKt
import com.example.demo.models.kotlin.Rectangle
import com.example.demo.models.testModels.GFriend
import com.example.demo.services.interfaces.Windows
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream

@Service
class KotlinService {

    val serviceName = "KotlinService"

    var numberOfMethods = 1000

    val expressionIfToValue = if ("KotlinService".contentEquals(serviceName)) "hooray" else "nay"

    val createdList = arrayListOf("test")

    val stringTemplate = "Wow it can be any expressions inside this String Template. The value should be $expressionIfToValue and it really is! : ${if ("KotlinService".contentEquals(serviceName)) "hooray" else "nay"}"

    val integerRange = 1..10

    val notInclude10Range = 1 until 10

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

    fun testWhenWithSmartCastAndBlockExpression(windows: Windows): String =
        when (windows)  {
            is SlideWindows -> {
                windows.open()
                "the windows has been ${windows.status}" //the last line is a result of this expression block
            }
            is LiftWindows -> {
                windows.close()
                "the windows has been ${windows.status}"
            }
            else -> "we don't responsible for this kind of windows"
        }

    fun testKotlinRange() {
        for (i in integerRange) {
            println(i)
        }
    }

    fun testRangeWithDownToAndStep() {
        for(i in 20 downTo 0 step 4) {
            println(i)
        }
    }

    fun testRangeWithOpenEndPoint() {
        for(i in notInclude10Range) {
            println(i)
        }
    }

    fun testUnpackingVariable() {

        val codeMapper = TreeMap<Char, String>()

        for(c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.toInt())
            codeMapper[c] = binary
        }

        for ((key, value) in codeMapper) {
            println("the key is $key and value is $value")
        }

        val stringList = arrayListOf("one", "two", "three")

        for ((index, value) in stringList.withIndex()) println("$index: $value")
    }

    fun inForCheckingElementExistence(c: Char) = c in 'A'..'F' || c in 'a'..'f'

    fun inForCheckingNonExistence(c:Char) = c !in 'X'..'Z'

    fun createListWithListOf() {
        val alphabetList = listOf('A', 'B', 'C', 'D')

        for (c in alphabetList) {
            println(c)
        }
    }

    fun functionWithDefaultParameterValue(subject: String,
                                          code: String = "101") {
        println("Today, I have $subject in the morning it is a beginner session so it's code is $code")
    }

    fun forJavaDefaultParam() {
        this.functionWithDefaultParameterValue("Yoga")
    }
}