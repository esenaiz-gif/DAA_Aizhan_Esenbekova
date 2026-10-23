public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        // test3:cписок с циклом (узел -4 указывает обратно на узел 2)
        // Список: 3 -> 2 -> 0 -> -4
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Создаем цикл на узел со значением 2
        runTest(head1, 1, true);

        // test2:
        // Список: 1 -> 2 -> 3 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        runTest(head2, 2, false);

        // test1:
        // Список: 1 -> null
        ListNode head3 = new ListNode(1);
        runTest(head3, 3, false);
    }

    public static void runTest(ListNode head, int testNumber, boolean expected) {
        System.out.println("--- Тест " + testNumber + " ---");
        boolean result = hasCycle(head);
        System.out.println("Cycle Detected: " + result);
        System.out.println("Expected Result: " + expected);
        System.out.println("Test Passed: " + (result == expected));
        System.out.println();
    }

    // Черепаха и Заяц
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head; // Черепаха (двигается на 1 шаг)
        ListNode fast = head; // Заяц (двигается на 2 шага)

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // есть цикл
            }
        }

        return false; // конец списка (null) = цикла нет
    }
}