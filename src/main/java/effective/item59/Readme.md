## ITEM 59 - 라이브러리를 익히고 사용하라.

### 표준 라이브러리 사용의 이점
1. 표준 라이브러리를 사용하면 그 코드를 작성한 전문가의 지식과 여러분보다 앞서 사용한 다른 프로그래머들의 경험을 활용할 수 있다.
2. 핵심적인 일과 크게 관련 없는 문제를 해결하느라 시간을 허비하지 않아도 된다.
3. 따로 노력하지 않아도 성능이 지속해서 개선된다. (업계 표준 벤치마크를 통해 제작자가 꾸준한 성능 확인 및 개선)
4. 기능이 점점 많아진다.
5. 작성한 표준 라이브러리 코드가 많은 사람에게 낯익은 코드가 된다. (유지보수, 재활용)

### Java 7 부터는 Random 대신 ThreadLocalRandom 으로 대체하자.
`java.util.Random` 은 멀티 쓰레드 환경에서 하나의 인스턴스에서 전역적으로 `의사 난수(pseudo random)`를 반환한다.

따라서 같은 시간에 동시 요청이 들어올 경우 경합 상태에서 성능에 문제가 생길 수 있다. 

반면 JDK 7부터 도입된 `java.util.concurrent.ThreadLocalRandom` 은 `java.util.Random` 를 상속하여 멀티 쓰레드 환경에서 서로 다른 인스턴스들에 의해 의사 난수를 반환하므로 동시성 문제에 안전하다.

### 라이브러리가 너무 방대해서 익히기 어렵다면, `java.lang`, `java.util`, `java.io` 만큼은 익숙해지자.

### 정리
- 바퀴를 다시 발명하지 말자. 나만의 기능이 아니라면 라이브러리로 구현되어있을 가능성이 크다.
- 라이브러리의 코드는 직접 작성한 것보다 품질이 좋고, 개선될 가능성이 크다. (개인이 작성하는 것보다 주목을 많이 받으므로)
