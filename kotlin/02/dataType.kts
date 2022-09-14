// 02. 자료형
// 1. 정수형
//      - Byte (1byte)
//      - Short (2byte)
//      - Int (4byte) -> 가장 많이 사용
//      - Long (8byte)

//      Byte 자료형 -> 1byte -> 8bit
//      bit: 0과 1 -> 두 개의 데이터
/**     비트1, 비트 2 == 2 X 2 = 4
 *
 *
 *      이 외에도
 *      - UByte
 *      - UShort
 *      - UInt
 *      - ULong
 *      - Unsigned임. 즉, 양수만 표현 가능하고 숫자의 크기를 더 크게 표현 가능능
 */

// 2. 실수형
//      - FLoat -> 4Byte
//      - Double -> 8Byte

// 3. 논리형
//      - Boolean
//      - True, False -> 1Byte

// 4. 문자형
//      - 한 문자만 표현
//      - A, 가, 나 -> 1Byte
//      - 'A'
// 5. 문자열형
//      - 문자의 배열
//      - HEllo, 안녕하세요 etc -> 글자수만큼 Byte 할당
//      - "HEllo"

// 6. 자료형 추론
//   var changeYes: Int = 100 O
//   var changeYes = 100 O -> 자동으로 자료형을 추론하여 할당
//   var/val name: dataType = value -> 명시적 자료형 선언
//   var/val name = value -> 추론
//   정수의 경우 기본적으로 Int로 추론함.
//   실수의 경우 Double
//   하지만, 자료형을 명시적으로 타이핑 해주는 것이 권장된다.
//   val bigNumber: Int = 1_123_123_123
//   큰 숫자를 할당 할 때 _로 자릿수 구분을 할 수 있다.

val byteInt: Byte = 10
val shortInt: Short = 10
val integerInt: Int = 10
val longInt: Long = 10

val floatNumber: Float = 10.0f
val doubleNumber: Double = 10.0

val number1 = 10 // Int 추론
val number2 = 10.0 // Double로 추론

val yes: Boolean = true
val no: Boolean = false

val text1: Char = 'A'
val text2: Char = '가'

val string1: String = "String"
val string2: String = "가나다라"
println(byteInt)
println(shortInt)
println(integerInt)
println(longInt)
println(floatNumber)
println(doubleNumber)
println(yes)
println(no)
println(text1)
println(text2)
println(string1)
println(string2)

