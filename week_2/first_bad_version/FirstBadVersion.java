package first_bad_version;

public class FirstBadVersion {

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 5;
        int result = firstBadVersion(n);
        System.out.println("Всего версий нашего нового продукта: " + n);
        System.out.println("Версии 1, 2, 3 - хорошие, а с 4-й начинают ломаться");
        System.out.println("Первая плохая версия: " + result); //после нее у нас все остальные тоже плохие версии продукта
    }
}