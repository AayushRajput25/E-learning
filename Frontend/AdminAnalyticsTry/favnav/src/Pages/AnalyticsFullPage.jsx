import React from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import AnalyticsPage from "../components/admin/AnalyticsPage";

const AnalyticsFullPage = () => {
    return(
        <div>
         <Navbar/>
         <AnalyticsPage/>
        <Footer/>
        </div>
      
    );
}

export default AnalyticsFullPage;