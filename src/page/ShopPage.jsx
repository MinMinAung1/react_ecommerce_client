import React,{ useEffect } from 'react'
import ProductList from '../features/product/ProductList';
import { useSelector,useDispatch } from 'react-redux';
import { fetchAllProducts } from '../features/product/productSlice';
import { getAllProducts,getStatus,getError } from '../features/product/productSlice';

const ShopPage = () => {

    const products = useSelector(getAllProducts)
    const status = useSelector(getStatus)
    const error = useSelector(getError)
    const dispatch = useDispatch()

    // useEffect(()=>{
    //     if(status === 'idle'){
    //         dispatch(fetchAllProducts())
    //     }
    // },[status,dispatch])

    let content = ''

    if(status === 'loading'){
        content = <p>Products are loading...</p>
    }

    if(status === 'success'){
        content = <ProductList products={products} />
    }

    if(error){
        content = <p> {error} </p>
    }

  return (
    <section>
        {content}
    </section>
  )
}

export default ShopPage