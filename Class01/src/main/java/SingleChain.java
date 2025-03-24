public class SingleChain {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.next = node1;
        node1.next = node2;

        head = reverse(head);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    //单链表翻转
    public static Node reverse(Node head){
        //从一个Node开始
        //记录Node的前后节点，pre和after
        //每次将node.next = pre; after.next = node; pre = node; node = after; after = after.next
        //null-->1-->2-->3-->null
        //null<--1-->2-->3-->null
        //null<--1<--2-->3-->null
        //null<--1<--2<--3-->null
        //              pre head after

        Node pre = null;
        Node after = null;
        while(head != null){
            after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;
    }
}
