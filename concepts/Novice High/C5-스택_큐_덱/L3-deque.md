# 덱

스택과 큐와 달리 맨 앞/뒤에서 삽입/삭제가 모두 가능

네 메소드의 시간복잡도가 모두 O(1) 

메서드: pop back, push back, pop front, push front

## Java 덱

```Java
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
    }
}
```


1. addFirst(E): 맨 앞에 데이터 E를 추가합니다.

2. addLast(E): 맨 뒤에 데이터 E를 추가합니다.

3. pollFirst(): 맨 앞에 있는 데이터를 반환합니다. 동시에 그 데이터를 deque에서 뺍니다.

4. pollLast(): 맨 뒤에 있는 데이터를 반환합니다. 동시에 그 데이터를 deque에서 뺍니다.

5. size(): 현재 deque에 들어있는 데이터의 수를 반환합니다.

6. isEmpty(): 현재 deque가 비어있다면 true, 아니라면 false를 반환합니다.

7. peekFirst(): deque의 맨 앞에 있는 데이터를 반환합니다.

8. peekLast(): deque의 맨 뒤에 있는 데이터를 반환합니다.
