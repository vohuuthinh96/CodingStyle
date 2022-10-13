

### Packages

Package names tương tự như java: all __lower-case__, nhiều từ được nối với nhau, không có dấu gạch ngang hoặc gạch dưới:

__BAD__:

```kotlin
com.RayWenderlich.funky_widget
```

__GOOD__:

```kotlin
com.raywenderlich.funkywidget
```

### Classes & Interfaces

Viết bằng __UpperCamelCase__. Ví dụ `RadialSlider`. 

### Methods

Viết vằng  __lowerCamelCase__. Ví dụ `setValue`.

### Fields

Được viết bằng  __lowerCamelCase__

Ví dụ:

```kotlin
class MyClass {
  var publicField: Int = 0
  val person = Person()
  private var privateField: Int?
}
```

Các giá trị không đổi trong companion object được viết bằng __uppercase__, Với dấu gạch dưới để phân cách các từ:

```kotlin
companion object {
  const val THE_ANSWER = 42
}
```

### Variables & Parameters

Viết bằng __lowerCamelCase__.

Các giá trị ký tự đơn phải được tránh, ngoại trừ các biến lặp tạm thời.

### Misc

Trong mã, các từ viết tắt nên được coi như các từ. Ví dụ:

__BAD:__

```kotlin
XMLHTTPRequest
URL: String? 
findPostByID
```
__GOOD:__

```kotlin
XmlHttpRequest
url: String
findPostById
```

## Declarations

### Visibility Modifiers

Chỉ bao gồm các công cụ sửa đổi mức độ hiển thị nếu bạn cần thứ gì đó khác với mặc định là công khai.

**BAD:**

```kotlin
public val wideOpenProperty = 1
private val myOwnPrivateProperty = "private"
```

**GOOD:**

```kotlin
val wideOpenProperty = 1
private val myOwnPrivateProperty = "private"
```

### Access Level Modifiers

Các công cụ sửa đổi mức truy cập phải được định nghĩa rõ ràng cho các lớp, phương thức và các biến thành viên.

### Fields & Variables

Ưu tiên khai báo một dòng.

__GOOD:__

```kotlin
username: String
twitterHandle: String
```


### Data Type Objects

Ưu tiên sử dụng data class cho các class đơn giản.

__BAD:__

```kotlin
class Person(val name: String) {
  override fun toString() : String {
    return "Person(name=$name)"
  }
}
```

__GOOD:__

```kotlin
data class Person(val name: String)
```

### Enum Classes

Các lớp enum không có phương thức có thể được định dạng mà không có dấu ngắt dòng, như sau:

```kotlin
private enum CompassDirection { EAST, NORTH, WEST, SOUTH }
```


### Indentation

Thụt lề đang sử dụng dấu cách - không bao giờ sử dụng tab.

#### Blocks

Thụt lề cho các khối sử dụng 2 khoảng trắng (không phải 4 mặc định):

__BAD:__

```kotlin
for (i in 0..9) {
    Log.i(TAG, "index=" + i)
}
```

__GOOD:__

```kotlin
for (i in 0..9) {
  Log.i(TAG, "index=" + i)
}
```

#### Line Wraps

Indentation for line wraps should use 4 spaces (not the default 8):

__BAD:__

```kotlin
val widget: CoolUiWidget =
        someIncrediblyLongExpression(that, reallyWouldNotFit, on, aSingle, line)
```

__GOOD:__

```kotlin
val widget: CoolUiWidget =
    someIncrediblyLongExpression(that, reallyWouldNotFit, on, aSingle, line)
```

### Line Length

Lines should be no longer than 100 characters long.


### Vertical Spacing

There should be exactly one blank line between methods to aid in visual clarity and organization. Whitespace within methods should separate functionality, but having too many sections in a method often means you should refactor into several methods.

## Comments

When they are needed, use comments to explain **why** a particular piece of code does something. Comments must be kept up-to-date or deleted.

Avoid block comments inline with code, as the code should be as self-documenting as possible. *Exception: This does not apply to those comments used to generate documentation.*


## Semicolons

Semicolons ~~are dead to us~~ should be avoided wherever possible in Kotlin. 

__BAD__:

```kotlin
val horseGiftedByTrojans = true;
if (horseGiftedByTrojans) {
  bringHorseIntoWalledCity();
}
```

__GOOD__:

```kotlin
val horseGiftedByTrojans = true
if (horseGiftedByTrojans) {
  bringHorseIntoWalledCity()
}
```

## Getters & Setters

Unlike Java, direct access to fields in Kotlin is preferred. 

If custom getters and setters are required, they should be declared [following Kotlin conventions](https://kotlinlang.org/docs/reference/properties.html) rather than as separate methods.

## Brace Style

Only trailing closing-braces are awarded their own line. All others appear the same line as preceding code:

__BAD:__

```kotlin
class MyClass
{
  fun doSomething()
  {
    if (someTest)
    {
      // ...
    }
    else
    {
      // ...
    }
  }
}
```

__GOOD:__

```kotlin
class MyClass {
  fun doSomething() {
    if (someTest) {
      // ...
    } else {
      // ...
    }
  }
}
```

Conditional statements are always required to be enclosed with braces, irrespective of the number of lines required.

__BAD:__

```kotlin
if (someTest)
  doSomething()
if (someTest) doSomethingElse()
```

__GOOD:__

```kotlin
if (someTest) {
  doSomething()
}
if (someTest) { doSomethingElse() }
```

## When Statements

Unlike `switch` statements in Java, `when` statements do not fall through. Separate cases using commas if they should be handled the same way. Always include the else case.

__BAD:__

```kotlin
when (anInput) {
  1 -> doSomethingForCaseOneOrTwo()
  2 -> doSomethingForCaseOneOrTwo()
  3 -> doSomethingForCaseThree()
}
```

__GOOD:__

```kotlin
when (anInput) {
  1, 2 -> doSomethingForCaseOneOrTwo()
  3 -> doSomethingForCaseThree()
  else -> println("No case satisfied")
}
```


## Types 

Always use Kotlin's native types when available. Kotlin is JVM-compatible so **[TODO: more info]**

### Type Inference

Type inference should be preferred where possible to explicitly declared types. 

__BAD:__

```kotlin
val something: MyType = MyType()
val meaningOfLife: Int = 42
```

__GOOD:__

```kotlin
val something = MyType()
val meaningOfLife = 42
```

### Constants vs. Variables 

Constants are defined using the `val` keyword, and variables with the `var` keyword. Always use `val` instead of `var` if the value of the variable will not change.

*Tip*: A good technique is to define everything using `val` and only change it to `var` if the compiler complains!

### Companion Objects

** TODO: A bunch of stuff about companion objects **

### Nullable Types

Declare variables and function return types as nullable with `?` where a `null` value is acceptable.

Use implicitly unwrapped types declared with `!!` only for instance variables that you know will be initialized before use, such as subviews that will be set up in `onCreate` for an Activity or `onCreateView` for a Fragment.

When naming nullable variables and parameters, avoid naming them like `nullableString` or `maybeView` since their nullability is already in the type declaration.

When accessing a nullable value, use the safe call operator if the value is only accessed once or if there are many nullables in the chain:

```kotlin
editText?.setText("foo")
```



## XML Guidance

Since Android uses XML extensively in addition to Kotlin and Java, we have some rules specific to XML. These can be found in our [Java code standards](https://github.com/raywenderlich/java-style-guide#xml-guidance)


## Language

Use `en-US` English spelling. 🇺🇸

__BAD:__

```kotlin
val colourName = "red"
```

__GOOD:__

```kotlin
val colorName = "red"
```

