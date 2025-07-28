# 버블 정렬

첫 번째 값부터 시작해서 n-1번째 값까지 순회하며 i 와 i+1 index의 값을 비교하여 정렬한다. 모든 값이 정렬될때까지 순회를 반복한다.

시간복잡도 O(N^2)

구현하기 쉽지만 다른 O(N^2) 알고리즘에 비해서도 느림

worst case: [5 4 3 2 1]

```pseudo
function bubble_sort(arr){
    set sorted = true
    set size = arr.size

    do
        sorted = true
        for i = 0 .... i < size -1
            if arr[i] > arr[i+1]
                set tmp = arr[i]
                arr[i] = arr[i+1]
                arr[i+1] = tmp
                sorted = false
    while(!sorted)

    return arr
}
```

외부 루프는 다 정렬되도 한 번 더 순회한다. (마지막 정렬 때 변화가 있기에 sorted = false임으로)