// import { Component } from 'react';
import { useState, useEffect } from 'react';
import CardList from './components/card-list/card-list.component.js';
import SearchBox from './components/search-box/search-box.component.js';

import './App.css';

// Functional Component Version
const App = () => {
  const [searchField, setSearchField] = useState('');
  const [monsters, setMonsters] = useState([]);
  const [filteredMonsters, setFilteredMonsters] = useState(monsters);

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/users')
    .then((response) => response.json())
    .then((users) => setMonsters(users))
  }, []);
  
  useEffect(() => {
    const newFilteredMonsters = monsters.filter((monster) => {
      return monster.name.toLocaleLowerCase().includes(searchField);
    });

    setFilteredMonsters(newFilteredMonsters);
  }, [monsters, searchField]);
  
  const onSearchChange = (event) => {
    const searchFieldString = event.target.value.toLocaleLowerCase();
    setSearchField(searchFieldString);
  };
  
  return (      
    <div className="App">
      <h1 className='app-title'>Monsters Rolodex</h1>
      
      <SearchBox 
      className='monster-search-box'
      placeholder='search monsters'
      onChangeHandler={onSearchChange}
      />

      <CardList monsters={filteredMonsters} />
   </div>
  );
}

// Class Component Version
/* class App extends Component {
  constructor() {
    super();

    this.state = {
      monsters: [],
      searchField: '',
    };
  }

  componentDidMount() {
    fetch('https://jsonplaceholder.typicode.com/users')
      .then((response) => response.json())
      .then((users) =>
        this.setState(
          () => {
            return { monsters: users };
          },
          () => {
            console.log(this.state);
          }
        ))
  }

  onSearchChange = (event) => {
    const searchField = event.target.value.toLocaleLowerCase();
    this.setState(
      () => { return { searchField }; }
    );
  }

  render() {
    const { monsters, searchField } = this.state;
    const { onSearchChange } = this;

    const filteredMonsters = monsters.filter((monster) => {
      return monster.name.toLocaleLowerCase().includes(searchField);
    });

    return (
      <div className="App">
        <h1 className='app-title'>Monsters Rolodex</h1>
        
        <SearchBox 
        className='monster-search-box'
        placeholder='search monsters'
        onChangeHandler={onSearchChange} 
        />

        <CardList monsters={filteredMonsters}/>
      </div>
    );
  }
} */

export default App;
