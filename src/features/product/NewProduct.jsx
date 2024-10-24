import React from 'react'
import { Button, Card, Col,Form  } from 'react-bootstrap'
import { useState } from 'react'
import { createNewProduct } from './productSlice'
import { useDispatch } from 'react-redux'

function NewProduct() {

    const [imageName,setIamgeName] = useState('')
    const [name,setName] = useState('')
    const [price,setPrice] = useState(0.0)
    const [category,setCateogry] = useState('')
    const [description,setDescription] = useState('')
    const [discount,setDiscount] = useState(0)
    const [quantity,setQuantity] = useState(0)
    const [code,setCode] = useState('')
    const [canRequest,setCanRequest] =useState(true)

    const dispatch = useDispatch()

    const onImageNameInputChange = (e) => {setIamgeName(e.target.value)}
    const onNameInputChange = (e) => {setName(e.target.value)}
    const onPriceInputChange = (e) => {setPrice(e.target.value)}
    const onCateogryInputChange = (e) => {setCateogry(e.target.value)}
    const onDescriptionInputChange = (e) => {setDescription(e.target.value)}
    const onDiscountInputChange = (e) => {setDiscount(e.target.value)}
    const onQuantityInputChange = (e) => {setQuantity(e.target.value)}
    const onCodeInputChange = (e) => {setCode(e.target.value)}

    
    const canCreate = [imageName,name,price,category,description,discount,quantity,code,canRequest].every(Boolean)

   const onSubmit = (event) => {
      event.preventDefault()

      if(canCreate){
        setCanRequest(false)
        const product = {
        imageName,
        name,
        price,
        category,
        description,
        discount,
        quantity,
        code
   }

   dispatch(createNewProduct(product))

   setIamgeName('')
   setName('')
   setPrice(0)
   setCateogry('')
   setDescription('')
   setDescription(0)
   setQuantity(0)
   setCode('')
   setCanRequest(true)
    }


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
                    <Button type='submit' variant='primary' disabled={!canCreate}> Create</Button>
                    </Form.Group>
                </Form>
            </Card.Body>
        </Card>
     </Col>
  )
}

export default NewProduct