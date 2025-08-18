# 스택

## 스택 정의, 값 넣기/빼기

후입선출 구조 (LIFO; Last In First Out)

### 5가지 함수

1. push(x) : x를 stack의 맨 위에 올려 놓습니다
2. size() : stack 위에 쌓인 블럭의 개수를 반환
3. empty() : stack 위가 비어있다면 true, 비어있지 않다면 false를 반환
4. top() : stack의 맨 위에 있는 숫자 값을 반환합니다. 단, stack에서 그 블럭을 제거하지는 않음
5. pop() : stack의 맨 위에 있는 숫자 값을 반환합니다. 단, 동시에 stack에서 그 블럭을 제거

## 배열과 스택의 차이

배열에서 삽입과 삭제 연산이 발생하는 장소를 맨 뒤로만 제한한다면, 우리는 배열을 스택처럼 사용할 수 있음

배열을 이용한 구현

```Pseudo
function push(arr, E)
  if arr.size == maxsize          // 배열에 이미 원소들이 가득 채워져 있다면,
    throw exception()             // 에러 메세지를 던져줍니다.
  arr.append(E)                   // 정상적인 상황이라면, E를 
                                  // 마지막 위치에 추가해줍니다.

function pop(arr) 
  if arr.size == 0                // 배열에 아무런 원소도 없다면
    throw exception()             // 에러 메세지를 던져줍니다.
  set last = arr[arr.size - 1]    // 정상적인 상황이라면, 마지막 값을 변수에 저장해두고
  delete arr[arr.size - 1]        // 맨 끝에 있는 값을 실제로 제거한 뒤
  return last                     // 마지막에 있었던 값을 반환해줍니다.

```

## 재귀와 콜 스택

재귀 함수 중간 지점을 저장하는 자료구조는 스택

## 자바 스택

```Java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
    }
}
```

1. push(E) : 맨 위에 데이터 E를 추가합니다.

2. size() : 현재 stack에 들어있는 데이터의 수를 반환합니다.

3. isEmpty() : 현재 stack이 비어있다면 true, 아니라면 false를 반환합니다.

4. peek() : stack의 가장 위에 있는 데이터를 반환합니다.

5. pop() : Stack의 가장 위에 있는 데이터를 반환합니다. 동시에 그 데이터를 Stack에서 뺍니다.
