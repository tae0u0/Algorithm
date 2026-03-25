import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] inorder, postorder, inorderIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        inorderIdx = new int[n + 1]; // 노드 번호의 인덱스를 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            // 중위 순회 값의 위치를 미리 저장 (O(1) 조회를 위해)
            inorderIdx[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        // 분할 정복 시작
        getPreorder(0, n - 1, 0, n - 1);

        System.out.println(sb.toString());
    }

    public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
        // 범위를 벗어나면 종료
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        // 1. 후위 순회의 마지막 요소는 해당 트리의 루트
        int root = postorder[postEnd];
        sb.append(root).append(" ");

        // 2. 중위 순회에서 루트의 인덱스를 찾음
        int rootIdx = inorderIdx[root];

        // 3. 왼쪽 서브트리의 노드 개수 계산
        int leftSize = rootIdx - inStart;

        // 4. 전위 순회 순서인 '루트 -> 왼쪽 -> 오른쪽' 순으로 재귀 호출

        // 왼쪽 서브트리
        // 중위: 시작 ~ 루트인덱스-1
        // 후위: 시작 ~ 시작+왼쪽크기-1
        getPreorder(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);

        // 오른쪽 서브트리
        // 중위: 루트인덱스+1 ~ 끝
        // 후위: 시작+왼쪽크기 ~ 끝-1 (루트 제외)
        getPreorder(rootIdx + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}