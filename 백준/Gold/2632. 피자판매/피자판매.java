import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int target;
    static int m, n;
    static int[] pizzaA, pizzaB;
    static Map<Integer, Integer> pizzaAMap, pizzaBMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        target = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizzaA = new int[m];
        pizzaB = new int[n];

        for (int i = 0; i < m; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        pizzaAMap = new HashMap<>();
        pizzaBMap = new HashMap<>();

        createMap(m, pizzaA, pizzaAMap);
        createMap(n, pizzaB, pizzaBMap);

        int answer = 0;

        if (pizzaAMap.containsKey(target)) {
            answer += pizzaAMap.get(target);
        }

        if (pizzaBMap.containsKey(target)) {
            answer += pizzaBMap.get(target);
        }

        for (Integer pizzaASize : pizzaAMap.keySet()) {
            int pizzaBSize = target - pizzaASize;
            if (!pizzaBMap.containsKey(pizzaBSize)) {
                continue;
            }

            answer += pizzaAMap.get(pizzaASize) * pizzaBMap.get(pizzaBSize);

        }

        System.out.println(answer);
    }

    private static void createMap(int length, int[] pizza, Map<Integer, Integer> pizzaMap) {
        for (int start = 0; start < length; start++) {
            int tempSum = 0;
            for (int size = 0; size < length; size++) {
                int index = (start + size) % length;
                tempSum += pizza[index];
                if (pizzaMap.containsKey(tempSum)) {
                    pizzaMap.put(tempSum, pizzaMap.get(tempSum) + 1);
                } else {
                    pizzaMap.put(tempSum, 1);
                }
            }
        }

        pizzaMap.put(Arrays.stream(pizza).sum(), 1);
    }
}