import { createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { createAsyncThunk } from "@reduxjs/toolkit";

const BASE_URL = 'http://localhost:8383/product'
const FETCH_URL = `${BASE_URL}/all`
const CREATE_URL = `${BASE_URL}/create`
const UPDATE_URL = `${BASE_URL}/update`

export const deleteProduct = createAsyncThunk('deleteProduct',async (productId) => {
    try {
        const response = await axios.delete(
            `${BASE_URL}/${productId}/delete`,
        )

        if(response.status === 200){
            console.log('seccessfully deleted product')
        }

        return response.data
    } catch (error) {
        console.error(error)
    }
    
})

export const updateProduct = createAsyncThunk('updateProduct',async (product) => {
    try {
        const response = await axios.put(
            UPDATE_URL,
            product,
            {
                headers:{
                    'Content-Type':'application/json',
                }
            }
        )

        if(response.status === 200){
            console.log('seccessfully updated product')
        }

        return response.data
    } catch (error) {
        console.error(error)
    }
    
})

export const createNewProduct = createAsyncThunk('createNewProduct',async (product) => {
    try {
        const response = await axios.post(
            CREATE_URL,
            product,
            {
                headers:{
                    'Content-Type':'application/json',
                }
            }
        )

        if(response.status === 200){
            console.log('seccessfully post requested is done')
        }

        return response.data
    } catch (error) {
        console.error(error)
    }
    
})

export const fetchAllProducts = createAsyncThunk('fetchAllProducts', async () => {
    try {
        const response = await axios.get(FETCH_URL)
        if(response.status === 200){
            return response.data
        }
    } catch (error) {
        console.error(error)
    }  
     
})

const initialState = {
    products : [],
    status : 'idle',
    error : null
}

const productSlice = createSlice({
    name : 'productSlice',
    initialState,
    reducers : {

    },
    extraReducers(builder){
        builder
        .addCase(fetchAllProducts.pending,(state) => {
            state.status = 'loading'
        })
        .addCase(fetchAllProducts.fulfilled,(state,action) => {
            state.products = action.payload
            state.status = 'success'
        })
        .addCase(fetchAllProducts.rejected,(state,action) => {
            state.status = 'failed'
            state.error = action.error
        })
        .addCase(createNewProduct.fulfilled,(state,action)=>{
            state.products = [action.payload,...state.products]
        })
        .addCase(updateProduct.fulfilled,(state,action) => {
            const updatedProduct = action.payload
            const filteredProducts = state.products.filter(p => p.id !== updatedProduct.id)
            state.products = [updatedProduct,...filteredProducts]
        })
        .addCase(deleteProduct.fulfilled,(state,action) => {
            const deletedId = action.payload
            const filteredProducts = state.products.filter(p => p.id !== deletedId)
            state.products = filteredProducts
        })
    }
})

export default productSlice.reducer
export const getAllProducts = state => state.products.products
export const getStatus = state => state.products.status
export const getError = state => state.products.error
export const getProductById = (state,productId)=> state.products.products.find(p => p.id === Number(productId))