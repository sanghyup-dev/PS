# 공간복잡도

C++:

- int 4 byte
- char 1 byte
- double 8 byte
- short 2 byte

int로 2천만이 대략 80MB

```
int a[2천만] : 80MB
int a[2백만] : 80 / 10 = 8MB
char a[2천만] : 80 / 4 = 20MB
double a[2천만] : 80 * 2 = 160MB
```

특정 시점에 메모리를 차지 하고 있는 값들이 가장 많을 때, 그 시점에서의 메모리 사용량을 확인
- 값이 생성되었다가 없어질 경우