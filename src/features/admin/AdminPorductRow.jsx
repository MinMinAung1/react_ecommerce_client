import { Image, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import ConfirmModal from "../../components/ui/ConfirmModal";
import { deleteProduct } from "../product/productSlice";
import { useDispatch } from "react-redux";

const AdminProductRow = ({ product }) => {
    const [showModal, setShowModal] = useState(false);

  const dispatch = useDispatch();
  const navigete = useNavigate();

  const onModalClose = () => {
    setShowModal(false);
  };
  const onDelete = () => {
    dispatch(deleteProduct(product.id));
    navigete('/admin')
  };

  return (
    <tr>
      <td>
        <Image src={product.imageName} style={{ width: "150px" }} />
      </td>
      <td>{product.name}</td>
      <td>{product.category}</td>
      <td>${product.price}</td>
      <td>${product.discount}</td>
      <td>{product.quantity}</td>
      <td>{product.code}</td>
      <td>{product.description}</td>
      <td>
        <Button
          onClick={() => {
            navigete(`/admin/product/update/${product.id}`);
          }}
          variant="secondary"
        >
          Update
        </Button>
        <Button
          onClick={() => {
            setShowModal(true);
          }}
          variant="danger"
        >
          Delete
        </Button>
      </td>
      {showModal && (
        <ConfirmModal
          onClose={onModalClose}
          onAction={onDelete}
          title="Delete confirmation"
          body="Are you sure you want to delete this product?"
        />
      )}
    </tr>
  );
};

export default AdminProductRow;
