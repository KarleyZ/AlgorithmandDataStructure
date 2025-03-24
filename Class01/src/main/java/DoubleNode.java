public class DoubleNode {
    int value;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
