public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        if (current == null){
            return "";
        }
        

        while (current != tail){
            sb.append(current.getElement());
        
            current = current.getNext();
        }
        sb.append(current.getElement());
        

        return sb.toString();

    }

    public E removeLast(){
    if (head == null){
        return null;
    }
    if (head.getNext() == null){
        E answer = head.getElement();
        head = null;
        tail = null;
        size--;            
        return answer;
    }

    Node<E> prev = head;
    Node<E> curr = head.getNext();
    while (curr != tail){
        prev = prev.getNext();
        curr = curr.getNext();
    }

    prev.setNext(null);
    tail = prev;
    size--;                 
    return curr.getElement();
}

    public void reverse(){  
        if (head == null){
            return;
        }
        Node<E> prev = head;
        Node<E> curr = null;
        Node<E> move = null;

        if (head.getNext() != null && head.getNext().getNext() != null){
            curr = head.getNext();
            move = head.getNext().getNext();
            prev.setNext(null); 
            tail = prev;
            while (move != null){
                curr.setNext(prev);
                prev = curr;
                curr = move;
                move = move.getNext();
            }
            curr.setNext(prev);
            prev = curr;
            head = prev;


        } else if (head.getNext() != null){
            curr = head.getNext();
            curr.setNext(prev);
            prev.setNext(null);
            head = curr;
            tail = prev;
            return;
        }




            
                 
    }
}