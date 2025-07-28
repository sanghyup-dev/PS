# 기수 정렬

맨 뒤에 있는 자릿수 부터 해당 자리수를 기준으로 정렬한 뒤, 점점 앞으로 이동하며 각 자리수를 기준으로 정렬하다가 최종적으로 가장 높은 자리수를 기준으로 정렬하는 방법

```pseudo
function radix_sort(arr, k)
  for pos = k - 1 ... pos >= 0:
    set arr_new = [10][]
    for i = 0 ... i < arr.size
      set digit = posth digit of arr[i]
      arr_new[digit].append(arr[i])

    set store_arr = []
    for i = 0 ... i < 10
      for j = 0 ... j < arr_new[i].size
        store_arr.append(arr_new[i][j])
  
    arr = store_arr

  return arr
```

시간복잡도: O(k*n)
