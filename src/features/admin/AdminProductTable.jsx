import { Table } from "react-bootstrap"
import AdminProductRow from "./AdminPorductRow"

const AdminProductTable = ({products}) => {

    return (
        <Table striped bordered hover>
            <thead>
                <tr>
                    <th>
                        Image
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Category
                    </th>
                    <th>
                        Price
                    </th>
                    <th>
                        Discount
                    </th>
                    <th>
                        Quantity
                    </th>
                    <th>
                        Code
                    </th>
                    <th>
                        Description
                    </th>
                </tr>
            </thead>
            <tbody>
                {products.map( product=> <AdminProductRow key = {product.id} product={product}/>)}
            </tbody>
        </Table>
    )
}
export default AdminProductTable