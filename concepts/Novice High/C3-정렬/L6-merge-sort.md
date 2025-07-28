# 병합정렬

배열을 반씩 나누며 재귀적으로 정렬한 뒤, 정렬된 배열을 병합하는 분할 정복 기반의 정렬 알고리즘

## 배심 원리: 정렬된 두 배열을 합쳐 하나의 배열로 만들기

- 두개의 배열의 처음부터 시작하여, 두개의 값 중 더 작은 값을 배열에 넣고, 다시 남은 값을 비교하는 방식으로 채우기
- 시간복잡도: O(N) -> 두 배열의 원소를 합치면 N개라고 가정한다면, 각 원소는 단 한번만 이동

## 배열 쪼개기

- 재귀적으로 배열을 N/2로 쪼개다보면 원소 하나의 배열이 나옴(이미 정렬된 상태)
- 역순으로 합쳐주면 됨
- 위와 같은 방식을 분할 정복이라고 부름(Divide and Conquer)

## 시간복잡도

- 원소가 N개인 배열을 절반으로 재귀적으로 나누어 각 요소의 길이를 1로 만들기 위해서 logN번 나누어야함
- 각 단계마다 O(N)의 시간이 걸림
- 총 시간복잡도: O(NlogN)

## 코드

```pseudo
function merge_sort(arr[], low, high)
  if low < high // 등호 없어야함!!!
    set mid = (low + high) / 2
    merge_sort(arr, low, mid)
    merge_sort(arr, mid+1, high)
    merge(arr, low, mid, high)


set merged_arr = []

function merge(arr[], low, mid, high)
  set i = low, j = mid + 1

  set k = low
  while i <= mid && j <= high
    if arr[i] <= arr[j]
      merged_arr[k] = arr[i]
      k += 1; i += 1
    else
      merged_arr[k] = arr[j]
      k += 1; j += 1
  
  while i <= mid
    merged_arr[k] = arr[i]
    k += 1; i += 1

  while j <= high
    merged_arr[k] = arr[j]
    k += 1; j += 1
  
  for k = low ... k <= high
    arr[k] = merged_arr[k]
  
  return arr 
```
