import React from 'react'
import ProductItem from './ProductItem'
import { Container, Row } from 'react-bootstrap'

const ProductList = ({ products }) => {
  return (
    <Container>
      <Row>
    {
        products.map(product => <ProductItem 
            key={product.id}
            id={product.id}
            imageName={product.imageName}
            name={product.name}
            price={product.price}
        />)
    }
    </Row>
    </Container>
  )
}

export default ProductList