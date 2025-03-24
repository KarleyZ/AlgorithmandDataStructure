public class DoubleLinkedChain {

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        head.next = node2;
        head.pre = null;
        node2.next = node3;
        node2.pre = head;
        node3.next = node4;
        node3.pre = node2;
        node4.next = null;
        node4.pre = node3;
        head = reverse(head);
        DoubleNode head2 = head;
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        while(head2.next != null){
            head2 = head2.next;
        }
        System.out.println("===========");
        while (head2 != null){
            System.out.print(head2.value + " ");
            head2 = head2.pre;
        }


    }

    //双链表反转
    public static DoubleNode reverse(DoubleNode head){
        DoubleNode before = null;
        DoubleNode after = null;
        while (head !=null){
            after = head.next;
            head.next = before;
            head.pre = after;
            before = head;
            head = after;
        }
        return before;
    }
}
