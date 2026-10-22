package sort_list;

public class SortList {
    public ListNode sortList(ListNode head) {
        // Базовый случай: если список пустой или в нем всего 1 элемент
        if (head == null || head.next == null) {
            return head;
        }

        // находим середину списка с помощью двух указателей (Fast & Slow)
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // разрываем связь, чтобы разделить список на две независимые части
        prev.next = null;

        // сортируем левую и правую части
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // сливаем два отсортированных списка в один
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Присоединяем оставшиеся элементы
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummyHead.next;
    }

    // Метод main для демонстрации работы кода
    public static void main(String[] args) {
        SortList sorter = new SortList();

        // Создаем тестовый список: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Список до сортировки: ");
        printList(head);

        // Сортируем список
        ListNode sortedHead = sorter.sortList(head);

        System.out.print("Список после сортировки: ");
        printList(sortedHead);
    }

    // Вспомогательный метод для вывода списка в консоль
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    // Обязательно делаем класс static, чтобы к нему можно было обращаться из main
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}