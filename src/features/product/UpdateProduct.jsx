import React from 'react'
import { Button, Card, Col,Form  } from 'react-bootstrap'
import { useState } from 'react'
 import { updateProduct,getProductById } from './productSlice'
 import { useDispatch,useSelector } from 'react-redux'
 import { useParams,useNavigate } from 'react-router-dom'

function UpdateProduct() {

    const { productId } = useParams()
    const product = useSelector((state) => getProductById(state,productId))

    const [imageName,setIamgeName] = useState(product?.imageName)
    const [name,setName] = useState(product?.name)
    const [price,setPrice] = useState(product?.price)
    const [category,setCateogry] = useState(product?.category)
    const [description,setDescription] = useState(product?.description)
    const [discount,setDiscount] = useState(product?.discount)
    const [quantity,setQuantity] = useState(product?.quantity)
    const [code,setCode] = useState(product?.code)
    const [canRequest,setCanRequest] =useState(true)

    const dispatch = useDispatch()
    const navigate = useNavigate()

    const onImageNameInputChange = (e) => {setIamgeName(e.target.value)}
    const onNameInputChange = (e) => {setName(e.target.value)}
    const onPriceInputChange = (e) => {setPrice(e.target.value)}
    const onCateogryInputChange = (e) => {setCateogry(e.target.value)}
    const onDescriptionInputChange = (e) => {setDescription(e.target.value)}
    const onDiscountInputChange = (e) => {setDiscount(e.target.value)}
    const onQuantityInputChange = (e) => {setQuantity(e.target.value)}
    const onCodeInputChange = (e) => {setCode(e.target.value)}
    
    const canUpdate = [imageName,name,price,category,description,discount,quantity,code,canRequest].every(Boolean)

   const onSubmit = (event) => {
      event.preventDefault()

      if(canUpdate && product.id){
        setCanRequest(true)
         
       dispatch(updateProduct({
        id:productId,
        imageName,
        name,
        price,
        category,
        description,
        discount,
        quantity,
        code}))
        
      }
      navigate('/')
   }

   return (
    <Col md={6} className='mx-auto'>
       <Card>
           <Card.Header>
               New Product Form
           </Card.Header>
           <Card.Body>
               <Form onSubmit={onSubmit}>
                   <Form.Group>
                       <Form.Label>Image</Form.Label>
                       <Form.Control  type='url' value={imageName} onChange={onImageNameInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Title</Form.Label>
                       <Form.Control  type='text' value={name} onChange={onNameInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Price</Form.Label>
                       <Form.Control  type='text' value={price} onChange={onPriceInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Category</Form.Label>
                       <Form.Control  type='text' value={category} onChange={onCateogryInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Discount</Form.Label>
                       <Form.Control  type='number' value={discount} onChange={onDiscountInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Quantity</Form.Label>
                       <Form.Control  type='number' value={quantity} onChange={onQuantityInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Code</Form.Label>
                       <Form.Control  type='text' value={code} onChange={onCodeInputChange} required/>
                   </Form.Group>
                   <Form.Group>
                       <Form.Label>Description</Form.Label>
                       <Form.Control  type='text' value={description} onChange={onDescriptionInputChange} required/>
                   </Form.Group>
                   <Form.Group className='mt-2'>
                   <Button type='submit' variant='primary' disabled={!canUpdate}> Create</Button>
                   </Form.Group>
               </Form>
           </Card.Body>
       </Card>
    </Col>
 )
}

export default UpdateProduct