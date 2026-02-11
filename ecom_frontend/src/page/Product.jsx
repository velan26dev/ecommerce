import React, { useEffect, useState } from "react";
import style from "./product.module.css";
import { useParams } from "react-router-dom";
import api from "../services/api";

const Product = () => {
  let { id } = useParams();
  const [product, setProduct] = useState({});
  const [quantity, setQuantity] = useState(1);

  let increment = () => {
    setQuantity(quantity + 1);
  };

  let decrement = () => {
    if (quantity > 1) {
      setQuantity(quantity - 1);
    }
  };

  const cart = async() => {
    await api.post(`/api/cart/${id}/${quantity}`);
    setQuantity(1);
  }

  useEffect(() => {
    let loadProduct = async () => {
      let { data } = await api.get(`/api/product/${id}`);
      // console.log(data);
      setProduct(data);
    };
    loadProduct();
  }, [id]);

  return (
    <>
      <section className={style.catalog}>
        <div className={style.container}>
          <div className={style.image}>
            <img src={product.imageUrl} alt={product.name} />
          </div>

          <div className={style.details}>
            <h1 className={style.prod}>{product.name}</h1>
            <h2 className={style.prod}>
              <span className={style.price}>M.R.P.:</span> ₹{product.price}
            </h2>
            <h3 className={style.prod}>⭐ {product.rating}</h3>
            <p className={style.prod}>
              <span className={style.cat}>Category: </span>
              {product.category}
            </p>
            <p className={style.prod}>
              <span className={style.desc}>Description: </span>
              {product.description}
            </p>
            <div className={style.prod}>
              <button className={style.count} onClick={decrement}>
                -
              </button>
              <span className={style.qty}>{quantity}</span>
              <button className={style.count} onClick={increment}>
                +
              </button>
            </div>
            <button className={`${style.prod} ${style.cart}`} onClick={cart}>
              ADD TO CART
            </button>
          </div>
        </div>
      </section>
    </>
  );
};

export default Product;
