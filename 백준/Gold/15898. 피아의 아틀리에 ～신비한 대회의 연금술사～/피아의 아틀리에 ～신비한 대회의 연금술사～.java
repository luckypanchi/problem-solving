import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][][] ingredientEffects;
    static char[][][] ingredientElements;
    static int[][] initEffects;
    static char[][] initElements;
    static boolean[] isSelected;
    static int[] selected;
    static int answer;
    static int[] ingredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ingredientEffects = new int[n][4][4];
        ingredientElements = new char[n][4][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    ingredientEffects[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    ingredientElements[i][j][k] = st.nextToken().charAt(0);
                }
            }
        }

        initEffects = new int[5][5];
        initElements = new char[5][5];
        ingredients = new int[n];
        for (int i = 0; i < n; i++) {
            ingredients[i] = i;
        }

        answer = -1;
        isSelected = new boolean[n];
        selected = new int[n];
        permutation(0);

        System.out.println(answer);
    }

    private static void permutation(int index) {
        if (index == 3) {
            makeBomb(initEffects, initElements, 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                selected[index] = i;
                permutation(index + 1);
                isSelected[i] = false;
            }
        }
    }

    static void makeBomb(int[][] prevEffects, char[][] prevElements, int currIdx) {
        if (currIdx == 3) {
            answer = Math.max(answer, valuate(prevEffects, prevElements));
            return;
        }

        int i = selected[currIdx];
        int[][] ingredientEffect = ingredientEffects[i];
        char[][] ingredientElement = ingredientElements[i];

        for (int rotation = 0; rotation < 4; rotation++) {
            ingredientEffect = rotate(ingredientEffect);
            ingredientElement = rotate(ingredientElement);

            for (int sy = 0; sy < 2; sy++) {
                for (int sx = 0; sx < 2; sx++) {
                    int[][] effects = copyArray(prevEffects);
                    char[][] elements = copyArray(prevElements);

                    for (int length1 = 0; length1 < 4; length1++) {
                        for (int length2 = 0; length2 < 4; length2++) {
                            int y = sy + length1;
                            int x = sx + length2;
                            effects[y][x] += ingredientEffect[length1][length2];
                            effects[y][x] = Math.max(effects[y][x], 0);
                            effects[y][x] = Math.min(effects[y][x], 9);

                            if (ingredientElement[length1][length2] != 'W') {
                                elements[y][x] = ingredientElement[length1][length2];
                            }
                        }
                    }

                    makeBomb(effects, elements, currIdx + 1);
                }
            }
        }
    }

    static int valuate(int[][] effects, char[][] elements) {
        int[] d = new int[256];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d[elements[i][j]] += effects[i][j];
            }
        }
        return 7 * d['R'] + 5 * d['B'] + 3 * d['G'] + 2 * d['Y'];
    }

    static int[][] rotate(int[][] array) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[array.length - 1 - j][i];
            }
        }
        return result;
    }

    static char[][] rotate(char[][] array) {
        char[][] result = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[array.length - 1 - j][i];
            }
        }
        return result;
    }

    static int[][] copyArray(int[][] prevArray) {
        int[][] newArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newArray[i][j] = prevArray[i][j];
            }
        }
        return newArray;
    }

    static char[][] copyArray(char[][] prevArray) {
        char[][] newArray = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newArray[i][j] = prevArray[i][j];
            }
        }
        return newArray;
    }
}