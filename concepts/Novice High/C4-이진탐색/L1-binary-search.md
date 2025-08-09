# 이진 탐색

## 이진탐색의 전제조건

배열은 반드시 정렬되어 있어야 합니다.  
탐색 범위가 원소 하나만 남을 때까지 반복합니다.

## 이진탐색의 진행과정

업/다운 게임과 비슷한 아이디어

현재 탐색 범위의 가운데 값(mid)과 목표값(target)을 비교하여 대소관계에 따라 탐색 범위를 좁혀나감

## 이진탐색의 구조

* `while (left <= right)`
  등호가 들어가야 **탐색 범위가 하나일 때도** 올바르게 비교할 수 있음
* `mid = (left + right) / 2`
  값이 홀수일 경우 **버림** 처리됨
* 만약 `arr[mid] == target`이면, `mid`를 반환
* 일치하지 않을 경우:

  * `target < arr[mid]` → `right = mid - 1`
  * `target > arr[mid]` → `left = mid + 1`
    → **mid 위치는 이미 확인했으므로 제외**
    → `right = mid` 혹은 `left = mid` 와 같이 작성하면 더 이상 범위가 줄어들지 않아 무한루프에 빠질 수 있음
* `while`문이 끝날 때까지 못 찾았다면 `-1`을 반환

## 코드

```Pseudo
function binary_search(arr, target)
  set left = 0
  set right = arr.size - 1
  while (left <= right)
    set mid = (left + right) / 2
    if arr[mid] == target
      return mid

    if arr[mid] > target
      right = mid - 1
    else
      left = mid + 1

  return -1
```

## 시간복잡도

O(logN) :  매 루프마다 절반씩 줄여가기 때문

루프 내부 연산은 O(1)이므로, 전체 시간 복잡도는 O(logN)

단점 : 반드시 정렬된 배열이어야 함(정렬되어 있지 않다면, 정렬 시간까지 고려해야 함)

| 상황                | 시간복잡도                      |
| ----------------- | -------------------------- |
| 정렬된 상태에서 이진탐색     | O(logN)                    |
| 정렬되지 않은 상태에서 이진탐색 | O(NlogN + logN) ≈ O(NlogN) |
| 순차탐색              | O(N)                       |

### 정리

정렬된 경우:

* 이진탐색이 훨씬 효율적  

정렬되지 않은 경우:

* 탐색이 한 번만 필요하다면 순차탐색이 더 나음
* 여러 번 탐색해야 한다면 이진탐색이 유리
