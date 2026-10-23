# Task 2: Linked List Cycle

## 1. Problem (Описание проблемы)
Дан корень односвязного списка. Требуется определить, содержит ли связный список цикл (то есть существует ли узел, к которому можно вернуться бесконечно двигаясь по ссылкам `next`).

## 2. Approach (Подход и трассировка)
Используется знаменитый алгоритм **«Черепаха и Заяц» (Алгоритм Флойда)**:
* Заводятся два указателя (`slow` и `fast`), стартующие с головы списка.
* `slow` (Черепаха) перемещается на **1 шаг** за итерацию.
* `fast` (Заяц) перемещается на **2 шага** за итерацию.
* Если список лишен цикла, `fast` дойдет до конца (`null`). Если цикл присутствует, `fast` пойдет по кругу и рано или поздно догонит `slow` (`slow == fast`).

## 3. Line-by-Line Code Explanation (Построчный разбор исходного кода)

Ниже приведено подробное объяснение каждой строки реализации на Java:

```java
public class LinkedListCycle {
    
    // Вложенный статический класс, описывающий узел связного списка
    static class ListNode {
        int val;       // Значение, хранящееся в узле
        ListNode next; // Ссылка на следующий узел в списке
        ListNode(int x) {
            val = x;
            next = null; // Изначально указатель на следующий узел равен null
        }
    }

    public static void main(String[] args) {
        // Создание теста 1: Список с циклом (узел -4 ссылается обратно на узел 2)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Замыкание хвоста на второй узел (создание цикла)
        runTest(head1, 1, true); // Запуск теста с ожидаемым результатом true

        // Создание теста 2: Список без цикла (обычный линейный список)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        runTest(head2, 2, false); // Ожидаемый результат false

        // Создание теста 3: Список из одного элемента без цикла
        ListNode head3 = new ListNode(1);
        runTest(head3, 3, false); // Ожидаемый результат false
    }

    // Вспомогательный метод для запуска теста, вывода результатов и проверки правильности
    public static void runTest(ListNode head, int testNumber, boolean expected) {
        System.out.println("--- Тест " + testNumber + " ---");
        boolean result = hasCycle(head); // Вызов основного алгоритма
        System.out.println("Cycle Detected: " + result);
        System.out.println("Expected Result: " + expected);
        System.out.println("Test Passed: " + (result == expected));
        System.out.println();
    }

    // Основной алгоритм «Черепаха и Заяц» для поиска цикла
    public static boolean hasCycle(ListNode head) {
        // Базовая проверка: если список пуст или состоит всего из 1 элемента без ссылки на себя, цикла нет
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head; // Указатель «Черепаха» (медленный, двигается на 1 шаг)
        ListNode fast = head; // Указатель «Заяц» (быстрый, двигается на 2 шага)

        // Цикл продолжается, пока быстрый указатель и его следующий элемент не окажутся пустыми (не дошли до конца)
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Черепаха сдвигается на 1 узел вперед
            fast = fast.next.next;     // Заяц сдвигается на 2 узла вперед

            // Если указатели встретились в одном узле, значит, Заяц обогнал Черепаху по кругу
            if (slow == fast) {
                return true; // Цикл успешно обнаружен
            }
        }

        return false; // Если цикл завершился, значит, достигнут конец списка (null) — цикла нет
    }
}