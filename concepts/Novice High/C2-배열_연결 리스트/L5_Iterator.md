## Iterator

연결 리스트와 별도로 자유 자재로 값을 순회할 수 있는 도구

list 이름을 l이라고 가정:  
```ListIterator<Character> it = l.listIterator();```

마지막 위치에서 iterator를 시작:  
```ListIterator<Character> it = l.listIterator(l.size());```


자주 사용되는 3가지 함수

1. ```.next()```, ```.previous()```
    - iterator를 앞 뒤로 움직이는 함수
    - 반드시 ```.hasNext()```, ```.hasPrevious()``` 확인 필요
2. ```it.remove()```
    - ```it.next()``` 를 진행했던 원소를 제거
3. ```it.add(E)```
    - iterator가 해당하는 위치에 원소 E 추가
