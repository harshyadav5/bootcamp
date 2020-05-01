import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import {uniqueFilter} from './Ques9';
import {singleLevelFlatten} from './Ques10';
import {LinkedList} from './Ques11';
import {harshMap,harshSet} from './Ques12';
import {Stack} from './Ques13';
import {areaOfCircle,areaOfRectangle,areaOfCylinder} from './Ques8';

//Ques 8:Import a module containing the constants and method for calculating area of circle, rectangle, cylinder.
console.log("========Ques 8 Answer============");

console.log("area of circle " + areaOfCircle(2.5));
console.log("area of rectangle " + areaOfRectangle(10,5));
console.log("area of cylinder " + areaOfCylinder(10,2.5));

//Ques 9:Import a module for filtering unique elements in an array.
console.log("===========Ques 9 Answer ===============")
const test = [10,10,10,20,20,23];
console.log(uniqueFilter(test));

//Ques10:Write a program to flatten a nested array to single level using arrow functions.
console.log("===============Ques 10 Answer===============")
const flatten =  [1, 2, [3, 4, [5, 6]]];
console.log(singleLevelFlatten(flatten));

//Ques11:Implement a singly linked list in es6 and implement addFirst() addLast(), length(), getFirst(), getLast().
console.log("==============Ques 11 Answer===================")
let list = new LinkedList();
list.addFirst(45);
list.addFirst(55);
list.addFirst(65);
console.log(list);
list.printList();
list.removeLast();
console.log(list.getFirst());
console.log(list.getLast());
console.log(list);

//Ques12: Implement Map and Set using Es6
console.log("===============Ques12 Answer================")

console.log("=============== Custom Set ================")
let newSet = new harshSet();
newSet.add(23);
newSet.add(35);
console.log(newSet);
console.log(newSet.contains(35));
newSet.remove(35);
console.log(newSet);
console.log(newSet.contains(35));

console.log("=============== Custom Map ================")
let newMap = new harshMap();
newMap.add(1,"Harsh");
newMap.add(2,"Kshitiz");
console.log(newMap);
newMap.remove(2);
console.log(newMap);

//Ques 13:Implementation of stack (using linked list)
console.log("===============Ques13 Answer================")
let newStack = new Stack();
newStack.push(23);
newStack.push(33);
newStack.push(43);
newStack.printStack();
console.log("Top Element Of Stack:"+newStack.peak());
newStack.pop();
newStack.printStack();
console.log(newStack.isEmpty());

ReactDOM.render(
  <App />,
  document.getElementById('root')
);
