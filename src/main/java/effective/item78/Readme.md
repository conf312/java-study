## ITEM 78 - 공유 중인 가변 데이터는 동기화해 사용하라.

### synchronized
- 메서드나 블록을 한 스레드가 수행하도록 `보장`한다.
- 동기화된 메서드나 블록에 들어간 스레드가 같은 `락`의 보호하에 수행된 모든 이전 수정의 최종 결과를 같게 한다. 
- `싱글 스레드 기반` 프로그램이라면 동기화를 고려하지 않아도 되지만 `멀티 스레드 기반`이라면 객체를 공유할 때 동기화를 고민해야 한다.

### 원자적(atomic)
- 자바 언어의 명세상으로 `long`과 `double` 를 제외한 변수를 읽고 쓰는 것은 원자적이다. (JLS, 174, 17.7) 
- 즉, `동기화` 없이 여러 `스레드`가 같은 변수를 수정하더라도 항상 어떤 `스레드`가 정상적으로 저장한 값을 읽어오는 것을 보장한다는 것이다.
- 하지만 `스레드`가 필드를 읽을 때 항상 `수정이 완전히 반영된` 값을 얻는다 보장하지만, 한 `스레드`가 저장한 값이 다른 `스레드`에게 `언제 어떻게 보이는가`는 보장하지 않는다. 
- 따라서 원자적 데이터를 쓸 때도 `동기화`해야 한다.

#### 이는 한 스레드가 맏든 변화가 다른 스레드에게 언제 어떻게 보이는가를 규정한 `자바의 메모리 모델` 때문이다, (JLS, 17.4)

### volatile `Volatile.java`
배타적 수행과는 상관이 없지만 항상 가장 `최근에 저장된 값`을 읽어온다. 
이론적으로는 CPU 캐시가 아닌 컴퓨터의 `메인 메모리`로부터 값을 읽기 때문에 읽기/쓰기 모두가 `메인 메모리`에서 수행된다.

- 가시성 (Visibility): volatile 변수의 값을 읽거나 쓸 때 항상 `메인 메모리`에서 읽고 쓰게 됩니다. 따라서 한 스레드에서 값을 변경하면 다른 스레드에서 즉시 그 값을 읽을 수 있습니다. 이는 변수의 변경 사항이 다른 스레드에 즉시 반영되는 것을 보장합니다.
- 순서성 (Ordering): volatile 변수를 사용하면 변수의 값을 읽고 쓰는 `순서`가 보장됩니다. 다시 말해, 하나의 스레드에서 변수를 수정한 후, 다른 스레드에서 그 값을 읽을 때 변수 변경 전에 다른 변수의 변경 사항이 반영되는 것을 보장합니다.

### volatile 의 문제점 - VolatileProblem.java
- 가시성과 순서성을 보장하지만 원자성을 보장하지 않는다.

### atomic 패키지
`java.util.concurrent.atomic` 패키지에는 락 없이도 `thread-safe` 한 클래스를 제공한다.

`volatile` 은 동기화의 효과 중 통신 쪽만 지원하지만 이 패키지는 원자성(배타적 실행)까지 지원한다. 게다가 성능도 동기화 버전보다 우수하다.

```java
private static final AtomicLong nextSerialNum = new AtomicLong();

public static long generateSerialNumber() {
    return nextSerialNum.getAndIncrement();
}
```

### 정리
- 가변 데이터는 공유하지 않는것이 동기화 문제를 피하는 가장 좋은 방법 중 하나이다. 
- 즉, 가변 데이터는 단일 스레드에서만 사용하자. 
- 한 스레드가 데이터를 수정한 후에 다른 스레드에 공유할 때는 해당 객체에서 공유하는 부분만 동기화해도 된다. 
- 다른 스레드에 이런 객체를 건네는 행위를 안전 발행(safe publication)이라고 한다. 
- 클래스 초기화 과정에서 객체를 정적 필드, `volatile` 필드, `final` 필드 혹은 보통의 락을 통해 접근하는 필드 그리고 동시성 컬렉션에 저장하면 안전하게 발행할 수 있다. 
