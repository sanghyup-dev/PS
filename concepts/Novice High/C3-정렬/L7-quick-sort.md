# 퀵 정렬

## 핵심원리 

N개의 값이 있고, 이 값들을 특정 값 이상, 미만으로 분류하는 시간 복잡도는 O(N)

배열 내 특정값을 기준으로 값을 그 값 이상, 미만으로 분류하면 자연스럽게 두개의 그룹으로 나뉘게 될 텐데, 해당 그룹에 대해 병합 정렬과 마찬가지로 재귀적으로 한번 더 퀵 정렬을 수행

## 과정

1. 피벗 선택: 일반적으로 배열의 마지막 원소를 피벗으로 설정합니다

2. 분할(Partition):
   - 두 개의 포인터(빨간색, 파란색)를 사용
   - 파란색 포인터는 빨간색 포인터가 찾은 값이 들어간 위치를 표시(교환이 발생할 때마다 전진)
   - 빨간색 포인터는 피벗보다 작은 값을 찾을 때까지 이동
   - 두 포인터가 가리키는 값을 교환하며, 작은 값은 왼쪽으로 이동
   - 마지막에는 피벗을 파란색 포인터의 다음 위치와 교환하여 정렬된 위치에 둠

재귀 호출: 피벗 기준으로 나뉜 좌/우 부분 배열에 대해 동일한 정렬 과정 수행

## 시간복잡도

평균: O(NlogN)

최악: O(N²) (편향된 분할 시 발생)

최선: O(NlogN)

보통은 다른 정렬들 보다 월등히 빠르지만 최악의 경우 O(N²)

피벗이 한쪽에 치우치면 성능이 급격히 저하되므로 좋은 피벗 선택이 중요:

- 단순 방식: 맨 앞/맨 뒤/중간 값 중 선택
- 개선된 방식: 세 값 중 중앙값(Median of Three) 사용


## 코드

```Pseudo
function partition(arr[], low, high)
  set pivot = select_pivot(arr, low, high)
  set i = low - 1
  
  for j = low ... j <= high - 1
    if arr[j] < pivot
      i += 1
      swap (arr[i], arr[j])
      
  swap (arr[i + 1], arr[high])
  return i + 1

function quick_sort(arr[], low, high)
  if low < high
    pos = partition(arr, low, high)
    
    quick_sort(arr, low, pos - 1)
    quick_sort(arr, pos + 1, high)
```
