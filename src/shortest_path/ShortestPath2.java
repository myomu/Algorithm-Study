package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 미래 도시
 * 259p
 */
public class ShortestPath2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 노드의 개수
        int M = Integer.parseInt(input[1]); // 간선의 개수
        int C = Integer.parseInt(input[2]); // 시작 노드

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF); // 최단 거리 테이블 무한으로 초기화

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int X = Integer.parseInt(input2[0]);
            int Y = Integer.parseInt(input2[1]);
            int Z = Integer.parseInt(input2[2]);
            graph.get(X).add(new Node(Y, Z));
        }

        dijkstra(C, graph, distance);

        int count = 0;
        int totalTime = 0;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] < INF) {
                count++;
                totalTime = Math.max(totalTime, distance[i]);
            }
        }
        count--; // 메시지를 보내는 자기자신을 제외. 즉, 시작 노드를 제외해야한다.
        System.out.print(count + " " + totalTime);

    }

    private static void dijkstra(int start, List<List<Node>> graph, int[] distance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            if (distance[currentNode] < currentCost) {
                continue;
            }

            for (Node neighbor : graph.get(currentNode)) {
                int newCost = distance[currentNode] + neighbor.cost;

                if (distance[neighbor.node] > newCost) {
                    distance[neighbor.node] = newCost;
                    pq.offer(new Node(neighbor.node, newCost));
                }
            }
        }

    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}

// 한 도시에서 다른 도시까지의 최단 거리 문제로 치환할 수 있으므로 다익스트라 알고리즘을 사용했다.
// 최단 거리 테이블(distance) 에 INF 가 아닌 것 그리고 시작 도시가 아닌 것이 메시지가 전파된 도시의 수이며
// 가장 긴 거리를 찾으면 그것이 바로 총 걸리는 시간이 된다.

