# 동적 배열

자유롭게 길이가 줄어들고 늘어날 수 있습니다. 즉, 정확히 사용하고 싶은 만큼만 공간을 차지하여 사용하는 방식

## ArrayList

```import java.util.ArrayList``` 와, ```ArrayList<T> name = new ArrayList<>();``` 형태의 선언이 필요

```Java
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> v = new ArrayList<>();
	}
}
```

### 자주 사용되는 메서드

1. add(E): 맨 뒤에 데이터 E를 추가
2. remove(index): index 위치의 원소 삭제
3. size(): 데이터의 수를 반환
4. get(index): 인덱스 위치의 원소 조회

## SideNote

 컨테이너: 미리 만들어진 Stack, Queue, Deque 등의 자료구조, Collection으로 정의됨

iterator: 컨테이너 내의 원소 순회를 위한 반복자
- ```import.java.Iterator;``` 필요
- 정의:
  ```
  Iterator<T> iterator = (기존 컨테이너 이름).iterator();
  ```
- 메소드:
  - iterator.next(): 한칸 전진, 전진한 위치의 값 반환
  - iterator.hasnext(): 다음 값이 남아있는지 확인