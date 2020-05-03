import React, { Component } from 'react';


class Fruits extends Component {
    render(){
    return (
        <tr>
            <td> { this.props.name } </td>
            <td> { this.props.quantity } </td>
            <td>
                <button onClick={ this.props.delete } > Delete-Fruit </button>
            </td>
        </tr>
    );
}
}

export default Fruits;