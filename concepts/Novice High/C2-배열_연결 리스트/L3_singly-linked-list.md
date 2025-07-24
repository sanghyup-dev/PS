# 단일 연결 리스트 - 노드의 정의

연결 리스트: 여러개의 노드가 모여서 형성되는 구조, 탐색은 느리다 (O(N))그러나 삽입과 삭제 연산이 매우 빠르다(O(1))

노드: 정보를 담는 하나의 창구, 데이터와 다른 노드로 이동하는 경로로 일반적으로 구성됨

단일 연결 리스트: 연결 방향이 단방향인 리스트

- 노드의 Next는 다음 노드의 위치를 가리킴
- Next에 다음 노드의 주소를 넣으면 연결됨
- Null을 넣으면 분리됨

## 삽입

``` pseudo
function SLL.insert_end(num)
  set new_node = node(num)       # Step 1. 노드 만들기
  SLL.tail.next = new_node       # Step 2. 이어 붙이기
  SLL.tail = new_node            # Step 3. Tail 변경하기
```

``` pseudo
function SLL.insert_front(num)
  set new_node = node(num)       # Step 1. 노드 만들기
  new_node.next = SLL.head       # Step 2. 이어 붙이기
  SLL.head = new_node            # Step 3. Head 변경하기
```

``` pseudo
function SLL.insert_after_head(num)
  set new_node = node(num)            # Step 1. 노드 만들기
  new_node.next = SLL.head.next       # Step 2. 새로운 노드의 next 값 변경
  SLL.head.next = new_node            # Step 3. Head의 next 값 변경
```

## 삭제

삭제할 노드의 전 노드와 다음 노드를 이어주기
head 또는 tail 삭제 시에는 head tail 값 바꿔주기

## 탐색

head에서 시작해서 tail이 나올 때까지 next를 따라서 탐색