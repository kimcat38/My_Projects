import { Outlet, Link } from "react-router-dom";
import { Fragment, useContext } from "react";

import { signOutUser } from "../../utils/firebase/firebase.utils.js";

import { UserContext } from "../../contexts/user.context";
import { CartContext } from "../../contexts/cart.context.jsx";

import CartIcon from "../../component/cart-icon/cart-icon.component.jsx";
import CartDropdown from "../../component/cart-dropdown/cart-dropdown.component.jsx";

import {
  NavigationContainer,
  LogoContainer,
  NavLinks,
  NavLink,
} from "./navigation.styles.jsx";

import { ReactComponent as CrwnLogo } from "../../assets/crown.svg";

const Navigation = () => {
  const { currentUser } = useContext(UserContext);
  const { isCartOpen } = useContext(CartContext);

  return (
    <Fragment>
      <NavigationContainer>
        <LogoContainer to="/">
          <CrwnLogo className="logo" />
        </LogoContainer>

        <NavLinks>
          <Link className="nav-link" to="/shop">
            SHOP
          </Link>

          {currentUser ? (
            <NavLink as="span" onClick={signOutUser}>
              SIGN OUT
            </NavLink>
          ) : (
            <NavLink to="/auth">SIGN IN</NavLink>
          )}

          <CartIcon />
        </NavLinks>
        {isCartOpen && <CartDropdown />}
      </NavigationContainer>
      <Outlet />
    </Fragment>
  );
};

export default Navigation;