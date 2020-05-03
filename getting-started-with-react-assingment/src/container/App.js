import React, { Component } from 'react';
import './App.css';
import Fruits from '../Fruits/Fruits';;


class App extends Component {
  
  state = {
      input : "",
      fruits : [
          { id : 1, name : "Mango", quantity : 10 },
          { id : 2, name : "Apple", quantity : 30 },
          { id : 3, name : "Banana", quantity : 45 }
      ]
  };

  inputChangeHandler = (event) => {
    const newText = event.target.value;
    this.setState( { input : newText } );
  }

  inputQuantityChangeHandler = (event) => {
    const newText = event.target.value;
    this.setState( { inputQuantity : newText } );
  }

  buttonClickHandler = () => {
    console.log("button clicked");

    const fruits = [...this.state.fruits];
    let input = this.state.input;
    let [name, quantity] = input.split('-');
    let count = fruits.length;

    let id = (count === 0) ? 1 : fruits[count-1].id + 1;

    fruits.push({
      id, name, quantity
    });

    input = "";

    this.setState({
      fruits, input
    });
  }

  deleteFruitHandler = (id)=>{
      console.log("delete clicked");

      let fruits = [...this.state.fruits];
      const deleteIndex = fruits.findIndex( (fruit) => fruit.id === id);
      fruits.splice(deleteIndex, 1);

      this.setState( { fruits } );
  }

  render() {

    let fruits = [ ...this.state.fruits ];

    let fruitList = fruits.map( (fruit) => 
        <Fruits 
            key={ fruit.id }
            name={ fruit.name } 
            quantity={ fruit.quantity }
            delete={ () => this.deleteFruitHandler(fruit.id) } 
        ></Fruits> 
    );

    return (
        <div className="App">

           {/* <form onSubmit={this.handleSubmit}>
             <label>
                FruitName:
             <input 
              type="text" 
              value={this.state.input} 
              onChange={this.inputChangeHandler(event)} /> </label>
             <label>
                FruitQuantity:
             <input 
              type="text" 
              value={this.state.inputQuantity} 
              onChange={this.inputQuantityChangeHandler(event)} /> </label>
              <button>Submit</button>
            </form> */}

            <input 
              type="text" 
              value={ this.state.input } 
              onChange={ (event) => this.inputChangeHandler(event) } 
            />
            <button 
              onClick={ () => this.buttonClickHandler() }
            > Submit </button>

            
            <table id="style">

              <thead> 
                <tr>
                  <td> Name </td>
                  <td> Quantity </td>
                  <td> Action </td>
                </tr>
              </thead>
              <tbody>{ fruitList }</tbody>

            </table>

        </div>
    );
  }
}

export default App;