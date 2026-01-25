import React from "react";
import NavBar from "./layout/NavBar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./page/Home";
import Signup from "./page/Signup";
import Cart from "./page/Cart";
import Orders from "./page/Orders";
import Login from "./page/Login";
import Product from "./page/Product";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/login" element={<Login />} />
          <Route path="/product/:id" element={<Product />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/orders" element={<Orders />} />
        </Routes>
      </BrowserRouter>
    </>
  );
};

export default App;
