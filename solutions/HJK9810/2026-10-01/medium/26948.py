def find_best_route(boards, N):
    dp = [float('inf')] * (1 << N)

    def traking(curr, visited):
        if curr == N: return 0
        if dp[visited] < float('inf'): return dp[visited]

        result = float('inf')

        for idx in range(N):
            if (visited & (1 << idx)) != 0: continue
            cost = boards[curr][idx] + traking(curr + 1, visited | (1 << idx))
            result = min(result, cost)

        dp[visited] = result
        return result

    return traking(0, 0)

def algorithm():
    N = int(input())
    boards = [list(map(int, input().split())) for _ in range(N)]

    return find_best_route(boards, N)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    print(f"#{test_case} {algorithm()}")
