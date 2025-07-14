# 반복문에서의 시간복잡도

시간복잡도는 일반적으로 최악을 기준으로 계산

## for문

``` pseudo
  function example(n)
  set x = 0
  for i  = 0 ... i < n/2
    x += 1
    print(x) 

```

위 와같은 식은 O(N), N = 10으로 정해져 있다면 O(1) 그러나 불분명하기에 N으로 고정. n/2만큼 수행하더라도 상수는 무시.

## while 문

```pseudo
function example(n)
  while 0 > n or n > 100
    if n < 0
      n++
    else
      n--
  return n
```

n이 0~100이라면 O(1)이지만, 최악의 상황을 고려해야하기에 무시. 따라서 위 식은 O(1∗(N−100))=O(N)
