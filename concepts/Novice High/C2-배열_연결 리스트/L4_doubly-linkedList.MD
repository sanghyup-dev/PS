## 이중 연결 리스트

노드를 앞 뒤로 연결한 리스트: 단일 연결 리스트에 prev 추가

### 자바 리스트

``` Java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
    }
}
```

list를 이용할 때 자주 사용되는 것은 다음 8가지 입니다.

- addFirst(E): 맨 앞에 데이터 E를 추가합니다.

- addLast(E): 맨 뒤에 데이터 E를 추가합니다.

- pollFirst(): 맨 앞에 있는 데이터를 반환합니다. 동시에 그 데이터를 list에서 뺍니다.

- pollLast(): 맨 뒤에 있는 데이터를 반환합니다. 동시에 그 데이터를 list에서 뺍니다.

- size(): 현재 list에 들어있는 데이터의 수를 반환합니다.

- isEmpty(): 현재 list가 비어있다면 true, 아니라면 false를 반환합니다.

- peekFirst(): list의 맨 앞에 있는 데이터를 반환합니다.

- peekLast(): list의 맨 뒤에 있는 데이터를 반환합니다.