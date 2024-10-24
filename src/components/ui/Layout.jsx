import React from 'react'
import { Container } from 'react-bootstrap'
import Header from '../layout/Header'
import { Outlet } from 'react-router-dom'

const Layout = () => {
  return (
     <Container fluid>
        <Header />
        <main>
            <Outlet />
        </main>
     </Container>
  )
}

export default Layout