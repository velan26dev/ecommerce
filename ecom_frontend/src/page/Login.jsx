import React, { useState } from "react";
import style from "./login.module.css";
import { NavLink, useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {
  const [user, setUser] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    let { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const response = await axios.post("http://localhost:8080/auth/login", user);
    localStorage.setItem("token", response.data.token);
    navigate("/");
  };

  let navigate = useNavigate();
  return (
    <>
      <section className={style.login}>
        <div className={style.form}>
          <h1>Login User</h1>
          <form onSubmit={handleSubmit}>
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
            Don't Have Account? <NavLink to="/signup">Sign Up</NavLink>
          </p>
        </div>
      </section>
    </>
  );
};

export default Login;
