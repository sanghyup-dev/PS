# Lower bound, Upper bound

 찾는 값 target이 배열에 여러 개 있다면, 이진탐색을 돌렸을 때 어떤 위치가 나오게 될지는 아무도 모름 -> 보통 Lower Bound 사용

## Lower Bound

원하는 값 target 이상의 값이 최초로 나오는 위치

```Pseudo
function lower_bound(arr, target)
  set left = 0                         // 첫 번째 원소의 위치로 설정합니다.
  set right = arr.size - 1             // 마지막 원소의 위치로 설정합니다.
  set min_idx = arr.size               // 최소이므로, 답이 될 수 있는 값보다 더 큰 값으로 설정합니다.
  while left <= right                  // [left, right]가 유효한 구간이면 계속 수행합니다.
    set mid = (left + right) / 2       // 가운데 위치를 선택합니다.
    if arr[mid] >= target              // 만약에 선택한 원소가 target보다 같거나 크다면 
      right = mid - 1                  // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
      min_idx = min(min_idx, mid)      // 같거나 큰 값들의 위치 중 최솟값을 계속 갱신해줍니다.
    else
      left = mid + 1                   // 작은 경우라면 left를 바꿔줍니다.

  return min_idx                       // 조건을 만족하는 최소 index 값을 반환합니다.
```

 min_idx : arr[mid]가 target보다 같거나 큰 경우에 대해 가능한 mid 값들 중 최솟값

## Upper Bound

원하는 값 target을 초과하는 값이 최초로 나오는 위치

```Pseudo
function upper_bound(arr, target)
  set left = 0                         // 첫 번째 원소의 위치로 설정합니다.
  set right = arr.size - 1             // 마지막 원소의 위치로 설정합니다.
  set min_idx = arr.size               // 최소이므로, 답이 될 수 있는 값보다 더 큰 값으로 설정합니다.
  while left <= right                  // [left, right]가 유효한 구간이면 계속 수행합니다.
    set mid = (left + right) / 2       // 가운데 위치를 선택합니다.
    if arr[mid] > target               // 만약에 선택한 원소가 target보다 크다면 
      right = mid - 1                  // 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 right를 바꿔줍니다.
      min_idx = min(min_idx, mid)      // 큰 값들의 위치 중 최솟값을 계속 갱신해줍니다.
    else
      left = mid + 1                   // 같거나 작은 경우라면 left를 바꿔줍니다.

  return min_idx                       // 조건을 만족하는 최소 index 값을 반환합니다.
```

## 활용

배열 내 데이터의 수는 Lower bound 값과 Upper bound 값 사이의 차이

## Custom bound

원하는 값 target 이하의 값이 마지막으로 나오는 위치

function custom_bound(arr, target)
  set left = 0                         // 첫 번째 원소의 위치로 설정합니다.
  set right = arr.size - 1             // 마지막 원소의 위치로 설정합니다.
  set max_idx = -1                     // 최대이므로, 답이 될 수 있는 값보다 더 작은 값으로 설정합니다.
  while left <= right                  // [left, right]가 유효한 구간이면 계속 수행합니다.
    set mid = (left + right) / 2       // 가운데 위치를 선택합니다.
    if arr[mid] <= target              // 만약에 선택한 원소가 target보다 같거나 작다면 
      left = mid + 1                   // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 left를 바꿔줍니다.
      max_idx = max(max_idx, mid)      // 같거나 작은 값들의 위치 중 최댓값을 계속 갱신해줍니다.
    else
      right = mid - 1                  // 값이 더 큰 경우라면 right를 바꿔줍니다.

  return max_idx                       // 조건을 만족하는 최대 index 값을 반환합니다.
