package week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static week4.LinkedList.ListNode;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("addFirst 테스트")
    void addFirstTest() {
        // Given
        LinkedList list = new LinkedList();
        ListNode node = new ListNode(10);
        ListNode node2 = new ListNode(20);

        // When
        ListNode add = list.add(list.getHead(), node, 0); // position:1
        ListNode add1 = list.add(list.getHead(), node2, 0); // position:0


        // Then
        assertEquals(10, add.getData());
        assertEquals(1, add.getPosition());

        assertEquals(20, add1.getData());
        assertEquals(0, add1.getPosition());

        assertEquals(10, list.getTail().getData()); // tail이 잘 들어갔는지?
    }

    @Test
    @DisplayName("addLast 테스트")
    void addLastTest() {
        // Given
        LinkedList list = new LinkedList();
        ListNode node = new ListNode(10);
        ListNode node1 = new ListNode(20);
        list.add(list.getHead(), node, 0); // [10] head == tail

        // When
        list.add(list.getHead(), node1, 1);

        // Then
        assertEquals(node, list.getHead());
        assertEquals(0, list.getHead().getPosition());
        assertEquals(10, list.getHead().getData());

        assertEquals(node1, list.getTail());
        assertEquals(1, list.getTail().getPosition());
        assertEquals(20, list.getTail().getData());
    }

    @Test
    @DisplayName("addPosition 테스트")
    void addPositionTest() {
        // Given
        LinkedList list = new LinkedList();
        ListNode node = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        list.add(list.getHead(), node, 0);
        list.add(list.getHead(), node1, 1);

        // When
        list.add(list.getHead(), node2, 1);

        // Then
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getTail().getPosition());
        assertEquals(20, list.getTail().getData());

        assertEquals(30, list.findByPosition(1).getData());
        assertEquals(1, list.findByPosition(1).getPosition());
    }

    @Test
    @DisplayName("contains 테스트")
    void containsTest() {
        // Given
        LinkedList list = new LinkedList();
        ListNode node = new ListNode(10);
        ListNode node1 = new ListNode(20);
        list.add(list.getHead(), node, 0); // node 만 추가함

        // When & Then
        assertTrue(list.contains(list.getHead(), node));
        assertFalse(list.contains(list.getHead(), node1));
    }
}