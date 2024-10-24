import { Card, Col, Row } from "react-bootstrap"
import { useSelector } from "react-redux"
import classes from "./ProductDetail.module.css"
import { useParams } from "react-router-dom"
import { getProductById } from "./productSlice"

const ProductDetail = () => {

    const { productId } = useParams()

    const product = useSelector((state) => getProductById(state,productId))

    return (
        <Card className={classes.card}>
            <Row>
                <Col md={8}>
                    <Card.Img variant="top" src={product.imageName}/>
                </Col>
                <Col>
                    <Card.Body>
                        <h3>{product.name}</h3>
                        <h5>Price</h5>
                        <Card.Text >
                            ${product.price}
                        </Card.Text>
                        <h5>Description</h5>
                        <Card.Text>
                            {product.description}
                        </Card.Text>
                    </Card.Body>
                </Col>
            </Row>
        </Card>
    )
}

export default ProductDetail