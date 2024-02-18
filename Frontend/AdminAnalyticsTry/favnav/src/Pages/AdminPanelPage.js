import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import AdminPanel from '../components/admin/AdminPanel';

const AdminPanelPage = () => {
  return (
    <div>
        <Navbar />
      <AdminPanel/>
      <Footer/>
    </div>
  );
};

export default AdminPanelPage;
