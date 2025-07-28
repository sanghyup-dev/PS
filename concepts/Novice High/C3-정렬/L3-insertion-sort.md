# 삽입정렬

모든 원소가 정렬이 되어 있다는 가정 하에서 현재 원소의 위치를 적절하게 집어넣는 정렬

```pseudo
function insertion_sort(arr[])
  set size = arr.size
  for i = 1 ... i < size
    set j = i - 1
    set key = arr[i]
    while j >= 0 && arr[j] > key
      arr[j + 1] = arr[j]
      j--
    arr[j + 1] = key
  return arr
```

시간복잡도: O(N^2)
