import React from 'react';
import { Line } from 'react-chartjs-2';
import axios from 'axios';
import { useState } from 'react';
const MyChartTry = () => {
  // Your data in the provided format
 

  const [rawData, setrawData] = useState([]);

  React.useEffect(() => {
    axios.get(`http://localhost:8080/admin/enrollment/day`)
      .then((response) => {
        console.log(response.data);
        setrawData(response.data);
      })
      .catch((error) => {
        // Handle error
      });
  }, [rawData]);

  // Transform the data for Chart.js
  const data = {
    labels: rawData.map(entry => entry.date),
    datasets: [
      {
        label: "Count",
        data: rawData.map(entry => entry.count),
        fill: true,
        backgroundColor: "rgba(75,192,192,0.2)",
        borderColor: "rgba(75,192,192,1)"
      }
    ]
  };

  return (
    <div>
      <Line data={data} />
    </div>
  );
};

export default MyChartTry;
