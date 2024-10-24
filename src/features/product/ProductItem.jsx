import React from "react";
import { Card, Col } from "react-bootstrap";
import classes from './Product.module.css'
import { useNavigate } from "react-router-dom";

const ProductItem = ({ id,imageName,name,price }) => {

  const navigate = useNavigate()

  const navigateDetailsPage = () => {
    navigate(`/product/${id}`)
  }

  return (
    <Col sm="12" md="3" lg="3" xl="2">
    <Card className={classes.card} onClick={navigateDetailsPage}>
      <Card.Img
        className={classes.thumbnail}
        variant="top"
        src={imageName}
      />
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>{price}</Card.Text>
      </Card.Body>
    </Card>
    </Col>
  );
};

export default ProductItem;
