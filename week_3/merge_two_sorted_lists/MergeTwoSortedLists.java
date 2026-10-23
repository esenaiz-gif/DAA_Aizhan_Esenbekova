public class MergeSortedArrays {
    public static void main(String[] args) {
        // Тест 1: отсортированные массивы
        int[] left1 = {-5, 1, 3, 7};
        int[] right1 = {-3, 2, 2, 4};
        runTest(left1, right1, 1);

        // Тест 2:массивы разной длины
        int[] left2 = {1, 5, 9};
        int[] right2 = {2, 4, 6, 8, 10};
        runTest(left2, right2, 2);

        // Тест 3: 1 из массивов пустой
        int[] left3 = {};
        int[] right3 = {1, 2, 3};
        runTest(left3, right3, 3);
    }

    public static void runTest(int[] left, int[] right, int testNumber) {
        System.out.println("Массив 1 (left):  " + java.util.Arrays.toString(left));
        System.out.println("Массив 2 (right): " + java.util.Arrays.toString(right));

        int[] sortedArray = merge(left, right);

        System.out.println("Результат слияния: " + java.util.Arrays.toString(sortedArray));
        System.out.println();
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, l = 0, r = 0;

        // сравниваем элементы обоих массивов и записываем меньший
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[i++] = left[l++];
            } else {
                result[i++] = right[r++];
            }
        }

        // дописываем оставшиеся элементы из left, если они остались
        while (l < left.length) {
            result[i++] = left[l++];
        }

        // дописываем оставшиеся элементы из right, если они остались
        while (r < right.length) {
            result[i++] = right[r++];
        }

        return result;
    }
}