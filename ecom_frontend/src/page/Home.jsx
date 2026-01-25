import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../layout/Card";
import style from "./home.module.css";
import { Link } from "react-router-dom";

const Home = () => {
  const [product, setProduct] = useState([]);

  useEffect(() => {
    let loadProduct = async () => {
      let { data } = await axios.get("http://localhost:8080/api/product");
      // console.log(data);
      setProduct(data);
    };
    loadProduct();
  }, []);

  return (
    <>
      <section className={style.home}>
        {product.map((prod) => (
          <Link to={`/product/${prod.id}`} key={prod.id} className={style.link}>
            <Card prod={prod} />
          </Link>
        ))}
      </section>
    </>
  );
};

export default Home;
