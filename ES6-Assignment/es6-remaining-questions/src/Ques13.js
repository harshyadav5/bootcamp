//Implementation of Stack using LinkedList
import {LinkedList} from './Ques11';
class Stack {

    constructor() {
        this.list = new LinkedList();
        this.top = -1;
    }
    push(x) {
        this.list.addLast(x);
        this.top += 1;
    }
    pop() {
        if(this.isEmpty() == false){
            this.list.removeLast();
            this.top -= 1;
        }
    }
    peak() {
        if(this.isEmpty() == false)
            return this.list.getLast();
    }

    printStack() {
        this.list.printList();
    }

    isEmpty(){
        return this.top == -1;
    }

}

export {Stack};
// //Implementation of Stack using Array
// class Stack {
//
//     constructor(){
//         this.items = [];
//     }
//     push(element) {
//       this.items.push(element);
//     }
//     pop() {
//     if (this.items.length == 0)
//         return "Underflow";
//     return this.items.pop();
//     }
//     peek() {
//     return this.items[this.items.length - 1];
//     }
//     isEmpty() {
//     return this.items.length == 0;
//     }
//     printStack() {
//       var str = "";
//       for (var i = 0; i < this.items.length; i++)
//           str += this.items[i] + " ";
//     return str;
//     }
// }
// export {Stack};
