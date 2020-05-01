function demoInheritance(){
  let obj = ProCoder("firstName","lastName","id","salary","skills");
  obj.displayProcoderInfo();
}
class Person{
  constructor(firstName,lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }
  static displayInfo(){
    console.log(firstName+" "+lastName);
  }
}
class Coder extends Person{
  constructor(firstName,lastName,id,salary){
    super(firstName,lastName);
    this.id=id;
    this.salary=salary;
  }
  static displayCoderInfo(){
    displayInfo();
    console.log(id+" "+salary);
  }
}
class ProCoder extends Coder{
  constructor(firstName,lastName,id,salary,skills){
    super(firstName,lastName,id,salary)
    this.skills=skills;
  }
  static displayProcoderInfo(){
    displayInfo();
    displayCoderInfo();
    console.log(Skills);
  }
}
