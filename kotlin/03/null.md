# Null

- 상태를 모름, 존재하지 않는다.
- 0과는 다른 타입 val number: Int = 0과 다름
- Null을 대상으로는 연산할 수 없다.
    - Null + 3 = Null
- 0 -> 두루마리 휴지에서 심지만 남은 상태
- Null -> 두루마리 자체가 없는 것. 그냥 없어

코드 1줄 코드 2줄 코드 3줄 코드 4줄 c = a + b

# 발생 가능한 문제

- a or b가 null인 경우 error 발생

# 해결 방법

- 더하기 연산을 하기 전에, 코드 3줄에서 a or b가 null인 지 미리 check!(기존 자바 방식)

NullSafety (Null로 부터 안전해지자)

- 코틀린의 가장 큰 특징 중 하나

# 그렇다면 Null은 필요 없는 것?

- 변수에 값 + 상태도 표현할 수 있다면, 좋은 거 아닌가? (옹호자 쪽 의견)

# Null을 표현하는 방법
- val/var name: type = value
- null은 value 자리에 들어올 수 있다.
  - val/var name: type = null

# null로부터 안전하게 할당하기
- val/var name: type? = null
  - val number: Int? = null -> null 가능함
  - val number: Int = 10 -> null 할당 불가능
  