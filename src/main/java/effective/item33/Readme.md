## ITEM 33 - 타입 안전 이종 컨테이너를 고려하라.

### 이종 안전 컨테이너 패턴 (type safe heterogeneous container pattern)
- 컨테이너에 값을 넣거나 뺄 때 매개변수화한 키를 함께 제공한다.
- 이렇게 하면 제네릭 타입 시스템이 값의 타입이 키와 같음을 보장해줄 것이다.

### 타입 안전 이종 컨테이너의 사용
Map 과 같은 컬렉션은 데이터베이스 조회 결과를 담아서 반환해주는데 많이 사용된다. 

즉, 데이터베이스의 행(row)의 임의 개수 열(column)을 가질 수 있는데, 모두 열을 타입 안전하게 이용할 수 있으면 멋질 것이다.

* 데이터베이스 열은 타입을 각각 가질 수 있기 때문 (String, Integer, Datetime)

### 코드 33-1
- 이 방식이 동작하는 이유는 class 의 클래스가 제네릭이기 때문이다.
- class 의 리터럴 타입은 Class 가 아닌 Class<T> 이다.
- String.class 타입은 Class<String>, Integer.class 타입은 Class<Integer>

### Favorites 는 타입 안전 이종 컨테이너라 할 만하다.
Favorites 인스턴스는 타입 안전한다. String 을 요청했는데 Integer 를 반환하는 일은 절대 없다. 일반적인 Map 과 달리 여러가지 타입의 원소를 담을 수 있다.

### Favorite 클래스에서 타입 안전을 보장하는 비결은 cast 메서드에 있다.
cast 메서드의 반환 타입은 Class 객체의 타입 매개변수와 같다. 즉, cast 메서드는 Class 클래스가 제네릭이라는 이점을 잘 활용한다.

```java
public class Class<T> {
    T cast(Object object);
}
```

### 동적 형변환으로 타입 안정성 확보
만약, 클라이언트가 Class 객체를 (제네릭이 아닌) 로(Raw) 타입으로 넘기면 타입안정성이 깨지게 된다.

하지만, 이렇게 로 타입을 넘길경우 컴파일시 비검사 경고가 뜰 것이다.

만약, 타입 안전성을 확보하고 싶다면 값(value) 인수로 주어진 타입이 키(key)로 명시한 타입과 같은지 확인하면 된다.

이 기능은 getFavorite 메서드에 필요한 기능으로 T로 비검사 형변환하는 과정 없이도 Favorites 를 타입 안전하게 만들어준다.

### 정리
- 컬렉션 API로 대표되는 일반적인 제네릭 형태는 한 컨테이너가 다룰수 있는 `매개변수의 수가 고정적`이다.
- 하지만 컨테이너 자체가 아닌 키를 타입 매개변수로 바꾸면 이런 제약이 없는 타입 안전 이종 컨테이너를 만들 수 있다.
- 타입 이종 컨테이너는 `Class`를 키로 사용하며, 이런 식으로 쓰이는 Class 객체를 `타입 토큰`이라 한다.
- 또한 직접 구현한 키 타입도 쓸 수 있다. 예컨데 DB의 행(컨테이너)을 표현한 Database Row 타입에는 제네릭 타입인 Column<T>를 사용할 수 있다.
