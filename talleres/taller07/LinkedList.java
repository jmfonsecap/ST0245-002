class Node {

    Node link = null;
    int data = 0;

    public Node() {
        link = null;
        data = 0;
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = null;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}

class SinglyLinkedListImpl {

    Node start = null;
    Node end = null;
    int size = 0;

    public SinglyLinkedListImpl() {
        start = null;
        end = null;
        size = 0;
    }

    //La complejidad de agregar n abejas es de O(n)
    public void insertAtStart(int data) {
        Node nptr = new Node(data, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLink(start);
            start = nptr;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node nptr = new Node(data, null);
        if (start == null) {
            start = nptr;
            end = nptr;
        } else {
            end.setLink(nptr);
            end = nptr;
        }
        size++;
    }

    public void insertAtPosition(int position, int data) {
        Node nptr = new Node(data, null);
        Node ptr = start;
        position = position - 1;
        for (int i = 1; i < size; i++) {
            if (i == position) {
                Node temp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(temp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }
    public void deleteAtPosition(int position) {
        if (start == null) {
            System.out.println("Empty!");
            return;
        }

        if (position == size) {
            Node startPtr = start;
            Node endPtr = start;
            while (startPtr != null) {
                endPtr = startPtr;
                startPtr = startPtr.getLink();
            }
            end = endPtr;
            end.setLink(null);
            size--;
            return;
        }

        Node ptr = start;
        position = position - 1;
        for (int i = 1; i < size; i++) {

            if (i == position) {
                Node temp = ptr.getLink();
                temp = temp.getLink();
                ptr.setLink(temp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    public void searchElementByPosition(int position) {
        if (position == 1) {
            System.out.println("Element at " + position + " is : " + start.getData());
            return;
        }

        if (position == size) {
            System.out.println("Element at " + position + " is : " + end.getData());
            return;
        }

        Node ptr = start;
        for (int i = 1; i < size; i++) {
            if (i == position) {
                System.out.println("Element at " + position + " is : " + ptr.getData());
                break;
            }
            ptr = ptr.getLink();
        }
    }
