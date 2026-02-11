import React, { useEffect, useState } from "react";
import api from "../services/api";
import style from "./cart.module.css";
import { useNavigate } from "react-router-dom";


const Cart = () => {
  const [cart, setCart] = useState([]);

  const total = cart.reduce((sum, item) => {
    return sum + (item.price * item.quantity);
  },0)

   useEffect(() => {
     let loadProduct = async () => {
       let { data } = await api.get("/api/cart");
       console.log(data);
       setCart(data);
     };
     loadProduct();
   }, []);
  
  const removeItem = async(id) => {
    await api.delete(`/api/cart/${id}`);
    setCart(cart.filter(item => item.product.id !== id));
  }
  
  let navigate = useNavigate();
  const handleCheckout = async() => {
    let { order } = await api.post("/api/order");
    navigate("/");
  }
  
  return (
    <>
      <section className={style.cart}>
        {cart.map(({ product, price, quantity, id }) => (
          <div key={id} className={style.item}>
            <img src={product.imageUrl} alt={product.name} />
            <div className={style.details}>
              <h1>{product.name}</h1>
              <h4>{product.category}</h4>
              <h4>⭐ {product.rating}</h4>
            </div>
            <div className={style.price}>
              <h2>₹ {price}</h2>
              <h3>Qty: {quantity}</h3>
            </div>
            <button className={style.btn} onClick={()=> removeItem(product.id)}>remove</button>
          </div>
        ))}
        <div className={style.checkout}>
          <h1>Total: ₹ {total}</h1>
          <h2>No. of Items: {cart.length}</h2>
          <button className={style.order} onClick={handleCheckout}>CHECKOUT</button>
        </div>
      </section>
    </>
  );
};

export default Cart;
