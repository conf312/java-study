## ## ITEM 85 - 자바 직렬화 대안을 찾으라.

### 객체 직렬화
1997년, 자바에 처음으로 도입, 연구용 언어인 `모듈라-3(Modula-3)`에서나 시도되었을뿐 대중적 언어에 적용된건 처음이었다. (위험 부담이 있었다.)
- 자바가 객체를 바이트 스트림으로 인코딩하고(직렬화) 그 바이트 스트림으로부터 다시 객체를 재구성하는(역직렬화) 메커니즘이다.
- 직렬화된 객체는 다른 VM에 전송하거나 디스크에 저장한 후 나중에 역직렬화 할 수 있다.

### 여러 문제점들
1. 보이지 않는 생성자
2. API 와 구현 사이의 모호해진 경계
3. 잠재적인 정확성 문제
4. 성능, 보안, 유지보수성 대가

### 실제로 문제점들이 악용되어진 사례
2000년대 초반에 논의된 취약점들이 그 후로 십 년 이상 심각하게 악용되었다. 2016년 11월에는 샌프란시스코 시영 교통국(SFMTA)이 랜섬웨어 공격을 받아
요금 징수 시스템이 이틀간 마비되는 사태를 겪기도 했다.

직렬화의 근본적인 문제는 공격 범위가 너무 넓고 지속적으로 더 넓어져 방어하기 어렵다는 점이다.

### 로버트 시커드
자바의 역직렬화는 명백하고 현존하는 위험이다. 이 기술은 지금도 직접 혹은 자바 하부 시스템(RMI, JMX, JMX)을 통해 간접적으로 쓰이고 있기 때문이다.
신뢰할수 없는 스트림을 역직렬화하면 원격코드 실행 (remote code execution, RCE) 서비스 거부(denial-of-service, DoS) 등의 공격으로 이어질 수 있다.

```java
static byte[] bomb() {
    Set<Object> root = new HashSet<>();
    Set<Object> s1 = root;
    Set<Object> s2 = new HashSet<>();
    for (int i = 0; i < 100; i++) {
        Set<Object> t1 = new HashSet<>();
        Set<Object> t2 = new HashSet<>();
        t1.add("foo"); // t1을 t2와 다르게 만든다.
        s1.add(t1);
        s1.add(t2);
        s1 = t1;
        s2 = t2;
    }
    return serialize(root); // 간결하게 하기 위해 이 메서드의 코드는 생략함
}
```

### 정리
- 직렬화는 위험하니 피해야한다.
- JSON 이나 프로토콜 버퍼 같은 대안을 사용하자.
- 신뢰할수 없는 데이터는 역직렬화하지 말자. 해야한다면 필터링을 사용하되, 이마저도 모든 공격을 막아줄수는 없다.
- 클래스가 직렬화를 지원하도록 만들지말고, 만들어야한다면 신경써서 작성해야 한다.






