package sort_an_array;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public static void main(String[] args) {
        SortAnArray solution = new SortAnArray();
        int[] test = {5, 2, 3, 1};

        System.out.println("Наш массив: " + java.util.Arrays.toString(test));
        int[] sorted = solution.sortArray(test);

        System.out.print("Отсортированный массив: ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // делим левую и правую части
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // сливаем две отсортированные части
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        // Копируем элементы во временный массив
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;      // Указатель для левой части
        int j = mid + 1;   // Указатель для правой части
        int k = left;      // Указатель для исходного массива

        // Слияние двух частей обратно в nums
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        // записываем оставшиеся элементы левой части (если они есть)
        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        // записываем оставшиеся элементы правой части (если они есть)
        while (j <= right) {
            nums[k++] = temp[j++];
        }
    }
}