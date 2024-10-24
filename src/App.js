import { Routes,Route } from "react-router-dom";
import ShopPage from "./page/ShopPage";
import Layout from "./components/ui/Layout";
import ProductDetail from "./features/product/ProductDetail";
import AdminPage from "./page/AdmnPage";
import NewProduct from "./features/product/NewProduct";
import UpdateProduct from "./features/product/UpdateProduct"

function App() {
  return (
      <Routes>
          {/* Root Route */}
          <Route path='/' element={<Layout/>}> 
              <Route index element={<ShopPage />} />
              <Route path="admin">
                <Route index element={<AdminPage />} />
                <Route path="product">
                    <Route path="new" element={<NewProduct />}/>
                    <Route path='update/:productId' element={<UpdateProduct />}/>
                </Route>
              </Route>
              <Route path='product/:productId' element={<ProductDetail />} />
          </Route>
      </Routes>
  )
}

export default App;
