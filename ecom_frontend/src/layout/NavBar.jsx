import React from "react";
import style from "./nav.module.css";
import { Link, NavLink } from "react-router-dom";

const NavBar = () => {
  return (
    <>
      <nav className={style.nav}>
        <section>
          <Link to="/" className={style.link}>
            <h1>ECOM</h1>
          </Link>
        </section>
        <section>
          <input
            type="search"
            className={style.search}
            placeholder="Search for Products,Brands and More"
          />
        </section>
        <section>
          <ul className={style.navMenu}>
            <li>
              <NavLink to="/orders" className={style.link}>
                Orders
              </NavLink>
            </li>
            <li>
              <NavLink to="/cart" className={style.link}>
                Cart
              </NavLink>
            </li>
            <li>
              <NavLink to="/login" className={style.link}>
                <button>Login</button>
              </NavLink>
            </li>
          </ul>
        </section>
      </nav>
    </>
  );
};

export default NavBar;
