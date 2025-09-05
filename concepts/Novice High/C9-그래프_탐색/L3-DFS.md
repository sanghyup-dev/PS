# DFS(Depth First Search)

깊이 우선 탐색

최대한 깊게 탐색한 후 더 이상 도달할 수 없는 상황이라면 다시 이전으로 돌아감  
이전에 방문했던 지점은 다시 방문하지 않아야 함

```javascript
function dfs(pos) {
    visit(pos);
    for (child of pos) {
        if (visited[child] == false) dfs(child);
    }
}
```
