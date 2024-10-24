import { useDispatch, useSelector } from "react-redux"
import AdminProductTable from "../features/admin/AdminProductTable"
import { useEffect } from "react"
import { fetchAllProducts } from "../features/product/productSlice"
import { getAllProducts,getStatus,getError } from "../features/product/productSlice"
import { Button } from "react-bootstrap"
import { useNavigate } from "react-router-dom"

const AdminPage = () => {

    const navigate = useNavigate()

    const products = useSelector(getAllProducts)
    const status = useSelector(getStatus)
    const error = useSelector(getError)
    const dispatch = useDispatch()

    useEffect(()=>{
        if(status==='idle'){
            dispatch(fetchAllProducts())
        }
    },[status,dispatch])

    let content = ''

    if(status==='loading'){
        content = <p>Products are Loading...</p>
    }

    if(status==='success'){
        content = <AdminProductTable products={products}/>
    }

    if(status==='error'){
        content = <p>{error}</p>
    }

    return (
        <section>
            <Button variant="primary" onClick={() => {navigate('/admin/product/new')}}>Create Product</Button>
            {content}
        </section>
    )
}

export default AdminPage