class Node {
    constructor(x) {
        this.x = x;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.length = 0;
    }
    addLast(x) {
        let node = new Node(x);
        let currentNode;
        if (this.head == null) {
            this.head = node;
        }
        else {
            currentNode = this.head; 
            while (currentNode.next) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        this.length++;
    }
    addFirst(x) {
        let node = new Node(x);
        node.next = this.head;
        this.head = node;
        this.length++;
    }
    getFirst() {
        let currentNode = this.head;
        if(this.getLength() != 0)
            return currentNode.x;
    }

    getLast() {
        let currentNode = this.head;
        if(this.getLength() != 0){
            while(currentNode.next) {
                currentNode = currentNode.next;
            }
            return currentNode.x;
        }
    }

    getLength() {
        return this.length;
    }

    printList() {
    let currentNode = this.head;
    while (currentNode) {
        console.log(currentNode.x);
        currentNode = currentNode.next;
        }
    }

    removeLast(){
        let prevNode = null;
        let currentNode = this.head;

        if(!currentNode)
            return;

        if(!currentNode.next){
            this.head = null;
            return;
        }

        while (currentNode && currentNode.next) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            }
        prevNode.next=null;
    }

}

export {LinkedList};
