import React from "react";
import { Button, Modal } from "react-bootstrap";

const ConfirmModal = ({ onClose, onAction, title, body }) => {
  const onCancle = () => {
    onClose();
  };

  const onOk = () => {
    onAction();
    onClose();
  };

  return (
    <Modal backdrop="static" keyboard={false} show={true}>
      <Modal.Header closeButton>
        <Modal.Title>{title}</Modal.Title>
      </Modal.Header>
      <Modal.Body>{body}</Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onCancle}>
          Cancle
        </Button>
        <Button variant="primary" onClick={onOk}>
          Ok
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default ConfirmModal;
