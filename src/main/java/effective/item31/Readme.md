## ITEM 31 - 한정적 와일드카드를 사용해 API 유연성을 높이자.

### 매개변수화 타입은 불공변이다. (아이템28)
List<String>은 List<Object>가 하는 일을 제대로 수행하지 못하니 하위 타입이 될 수 없다. (리스코프 치환 원칙 위배)
`Main.java -> 9번라인`

- 유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라.
- 자바는 이런 상황에 대처할 수 있는 한정적 와일드카드 타입이라는 특별한 매개변수화 타입을 지원한다.
```java
? extends E
? super E
```

### 단, 입력 매개변수가 생산자와 소비자 역할을 동시에 한다면 와일드카드 타입을 써도 좋을게 없다. (타입을 정확히 지정해야하는 상황이기 때문에)

###  ❗️ 어떤 와일드카드 타입 사용해야 하는지 기억하는데 도움이 되는 공식
#### 펙스(PECS): producer-extends, consumer-super
매개변수화 타입 T가 `생산자라면 <? extends T>`를 사용하고 `소비자라면 <? super T>`를 사용하라.