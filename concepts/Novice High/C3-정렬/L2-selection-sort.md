# 선택 정렬

1. 전체 값 중 가장 작은 값을 찾음
2. 해당 값을 맨 첫번째에 배치함
3. 첫번째 값을 제외하고 가장 작은 값을 찾아 두번째에 배치함
4. 두번째, 세번째, ... n-1번째 값을 제외하고 가장 작은 값을 찾아 정해진 위치에 배치함.

```pseudo
function selection_sort(arr)
  set size = arr.size

  for i = 0 ... i < size - 1
    set minimum = i
    for k = i+1 ... k < size
      if arr[k] < arr[minimum]
        minimum = k
    set tmp = arr[i]
    arr[i] = arr[minimum]
    arr[minimum] = tmp

  return arr
```

시간 복잡도: O(N^2)
