

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

Sử dụng 4 khoảng trắng (thay vì 8 như mặc định)

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

Các dòng không được vượt quá 100 ký tự.


### Vertical Spacing
Phải có chính xác một dòng trống giữa các phương thức để hỗ trợ việc tổ chức và rõ ràng về hình ảnh. Khoảng trắng bên trong các phương thức sẽ phân tách chức năng, nhưng có quá nhiều phần trong một phương thức thường có nghĩa là bạn nên cấu trúc lại thành một số phương thức khác.


## Comments

Khi cần, hãy sử dụng **why** một đoạn mã cụ thể lại làm được điều gì đó. Nhận xét phải được cập nhật hoặc xóa.

Tránh comment cùng dòng với code. * Ngoại lệ: Điều này không áp dụng cho những nhận xét được sử dụng để tạo tài liệu


## Semicolons

Dấu chấm phẩy ~~are dead to us~~ nên tránh sử dụng nó trong Kotlin. 

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

Không giống Java, truyền truy cập vào các biến của Kotlin được ưu tiên . 

Nếu các getters và setters tùy chỉnh là bắt buộc, chúng nên được khai báo [theo quy ước Kotlin] (https://kotlinlang.org/docs/reference/properties.html) chứ không phải là các phương thức riêng biệt.

## Brace Style

Chỉ có các dấu ngoặc nhọn cuối cùng mới sử dụng đòng riêng, còn lại viết cùng 1 dòng


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

Câu lệnh điều kiện luôn bắt buộc phải được đặt trong dấu ngoặc nhọn, bất kể số dòng được yêu cầu.

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

Không giống như các câu lệnh `switch` trong Java, câu lệnh` when` không nằm trong số đó. Phân tách các trường hợp bằng cách sử dụng dấu phẩy nếu chúng phải được xử lý theo cùng một cách. Luôn bao gồm trường hợp khác(else)

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



### Constants vs. Variables 

Các hằng được xác định bằng từ khóa `val` và các biến bằng từ khóa` var`. Luôn sử dụng `val` thay vì` var` nếu giá trị của biến không thay đổi.




## Language

Sử dụng tiếng anh `en-US`  🇺🇸

__BAD:__

```kotlin
val colourName = "red"
```

__GOOD:__

```kotlin
val colorName = "red"
```
## XML style rules

### 3.1 Sử dụng thẻ tự đóng
Khi một phần tử XML không có nội dung, bạn cần phải tự đóng thẻ

Nên: 

```xml

<TextView
    android:id="@+id/tvProfile"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
   
```

Không nên 

```xml

<TextView
    android:id="@+id/tvProfile"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" >
</TextView>
   
```

### 3.2 Đặt  Id

Id đặt tên theo kiểu __lowerCamelCase__

#### 3.2.1 Đặt tên ID

Các ID nên bắt đầu bằng tên phần tử. Ví dụ:

| Element              | Prefix              |
| -----------------    | -----------------   |
| `TextView`           | `tv`                |
| `ImageView`          | `img`               | 
| `Button`             | `btn`               |   
| `Menu`               | `menu`              |
| `RelativeLayout`     | `rl`                |
| `LinearLayout `      | `ln`                |


Ví dụ ImageView:

```xml

<ImageView
    android:id="@+id/imgAvatar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
    

```
#### 3.2.2 Strings

Tên chuối bắt đầu bằng một định danh. Ví dụ `registration_email_hint` hoặc `registration_name_hint`. 
Hoặc nếu không thì theo quy luật sau:

| Tiền tố             | Mô tả                           |
| -----------------  | --------------------------------------|
| `error_`             | Cho thông báo lỗi                   |
| `msg_`               | Cho một thông báo or in nhắn         |       
| `title_`             | Cho tiêu đề, vd tiêu đề dialog, activity         | 
| `action_`            | Hành vi như `Lưu`, `Sửa` , `Xóa`  |

#### 3.2.3 Styles and Themes

Khai báo theo kiểu __UpperCamelCase__.

#### 3.2.4 Thứ tự thuộc tính

Như một quy luật chung thì bạn nên nhóm các thuộc tính giống nhau lại.

1. View Id
2. Style
3. Layout width and layout height
4. Other layout attributes, sorted alphabetically
5. Remaining attributes, sorted alphabetically



