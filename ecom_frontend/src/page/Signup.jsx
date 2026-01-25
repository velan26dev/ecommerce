import React, { useState } from "react";
import style from "./signup.module.css";
import { NavLink, useNavigate } from "react-router-dom";
import axios from "axios";

const Signup = () => {
  const [user, setUser] = useState({
    name: "",
    address: "",
    phone: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    let { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    await axios.post("http://localhost:8080/auth/register", user);
    navigate("/");
  };

  let navigate = useNavigate();
  return (
    <>
      <section className={style.sign}>
        <div className={style.form}>
          <h1>Sign Up</h1>
          <form onSubmit={handleSubmit}>
            <div className={style.form_items}>
              <label htmlFor="name">Name : </label>
              <input
                type="text"
                id="name"
                name="name"
                value={user.name}
                onChange={handleChange}
                required
              />
            </div>
            <div className={style.form_items}>
              <label htmlFor="address">Address : </label>
              <input
                type="text"
                id="address"
                name="address"
                value={user.address}
                onChange={handleChange}
                required
              />
            </div>
            <div className={style.form_items}>
              <label htmlFor="phone">Phone : </label>
              <input
                type="tel"
                id="phone"
                name="phone"
                value={user.phone}
                onChange={handleChange}
                required
              />
            </div>
            <div className={style.form_items}>
              <label htmlFor="email">Email : </label>
              <input
                type="email"
                id="email"
                name="email"
                value={user.email}
                onChange={handleChange}
                required
              />
            </div>
            <div className={style.form_items}>
              <label htmlFor="password">Password : </label>
              <input
                type="text"
                id="password"
                name="password"
                value={user.password}
                onChange={handleChange}
                required
              />
            </div>
            <div className={style.form_items}>
              <button type="submit" id={style.submit}>
                Submit
              </button>
              <button onClick={() => navigate("/")} id={style.cancel}>
                Cancel
              </button>
            </div>
          </form>
          <p>
            Already Have Account? <NavLink to="/login">Login</NavLink>
          </p>
        </div>
      </section>
    </>
  );
};

export default Signup;
