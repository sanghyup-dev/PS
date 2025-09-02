# Tabulation

바텀업 방식(bottom-up Approach)

for문을 이용해 순서대로 배열에 값을 채워나가는 방식

피보나치 수열의 n번째 원소를 구하는 코드

```Pseudo
set dp = [0, 0, 0, ...]

dp[1] = 1
dp[2] = 1

for i = 3 ... i <= n:
    dp[i] = dp[i - 1] + dp[i - 2]

print(ndp[n])
```
