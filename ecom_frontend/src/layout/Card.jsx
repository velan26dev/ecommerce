import React from "react";
import style from "./card.module.css";

const Card = (props) => {
  let { prod } = props;
  return (
    <>
      <div className={style.card}>
        <img src={prod.imageUrl} alt={prod.name} />
        <h3 className={style.pname}>{prod.name}</h3>
        <div className={style.details}>
          <h3 className={style.price}>₹{prod.price}</h3>
          <h4 className={style.rating}>⭐ {prod.rating}</h4>
        </div>
      </div>
    </>
  );
};

export default Card;
