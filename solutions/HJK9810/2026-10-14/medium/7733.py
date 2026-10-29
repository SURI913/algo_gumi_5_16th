from collections import deque

DIR = ((1, 0), (-1, 0), (0, 1), (0, -1))

def count_cheeze(board, N, day):
    queue = deque()
    visited = [[False] * N for _ in range(N)]
    count = 0

    for row in range(N):
        for col in range(N):
            if board[row][col] <= day: visited[row][col] = True
            if visited[row][col]: continue

            count += 1
            queue.append((row, col))
            visited[row][col] = True

            while queue:
                r, c = queue.popleft()

                for (dr, dc) in DIR:
                    nr, nc = dr + r, dc + c
                    if 0 <= nr < N and 0 <= nc < N:
                        if visited[nr][nc] or board[nr][nc] <= day: continue
                        visited[nr][nc] = True
                        queue.append((nr, nc))

    return count

def algorithm():
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    max_count = 0
    day = 0
    while True:
        count = count_cheeze(board, N, day)
        if count == 0: break

        if max_count < count:
            max_count = count

        day += 1

    return max_count

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
