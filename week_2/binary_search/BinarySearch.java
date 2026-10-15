package binary_search;

public class BinarySearch {


    public static int binarySearch(int[] nums, int target) {
        // устанавливаем левую и правую границы поиска
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // находим середину
            int mid = left + (right - left) / 2;

            // eсли элемент в середине равен нашему числу, то мы выходим из while
            if (nums[mid] == target) {
                return mid;
            }
            // eсли искомое число больше, чем в середине, отбрасываем левую половину
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // eсли искомое число меньше, отбрасываем правую половину
            else {
                right = mid - 1;
            }
        }

        // eсли цикл завершился, а элемент не найден
        return -1;
    }

    // тест
    public static void main(String[] args) {
        int[] nums = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23; // число, которое мы ищем

        System.out.println("Ищем число: " + target);

        int result = binarySearch(nums, target);

        if (result != -1) {
            System.out.println("Элемент найден под индексом: " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}