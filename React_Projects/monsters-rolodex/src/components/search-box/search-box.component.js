//import { Component } from "react";
import './search-box.styles.css';

// Functional Component Version
const SearchBox = ({ className, placeholder, onChangeHandler }) => (
  <input
      className={`search-box ${className}`}
      type='search'
      placeholder={placeholder}
      onChange={onChangeHandler}
  />
)

// Class Component Version
/* class SearchBox extends Component {
  render() {
    const { className, placeholder, onChangeHandler } = this.props;

    return (
      <input
          className={`search-box ${className}`}
          type='search'
          placeholder={placeholder}
          onChange={onChangeHandler}
      />
    )
  }
}
 */
export default SearchBox;