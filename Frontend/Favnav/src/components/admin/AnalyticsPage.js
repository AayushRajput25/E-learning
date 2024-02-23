import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Chart, registerables } from 'chart.js'; // Import Chart and registerables from 'chart.js'

Chart.register(...registerables); // Register all components

function AnalyticsPage() {
  const [chartData, setChartData] = useState(null);

  useEffect(() => {
    fetchData();

    // Cleanup function to destroy the chart when component is unmounted
    return () => {
      setChartData(null);
    };
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/admin/admin/student');
      const data = response.data;

      if (data && data.length > 0) {
        const ageGroups = {
          '18 to 24': 0,
          'Below 18': 0,
          '24 to 30': 0,
          'Above 30': 0
        };

        data.forEach(entry => {
          const age = entry.age;
          if (age >= 18 && age <= 24) {
            ageGroups['18 to 24']++;
          } else if (age < 18) {
            ageGroups['Below 18']++;
          } else if (age > 24 && age <= 30) {
            ageGroups['24 to 30']++;
          } else {
            ageGroups['Above 30']++;
          }
        });

        const labels = Object.keys(ageGroups);
        const values = Object.values(ageGroups);

        const newChartData = {
          labels: labels,
          datasets: [
            {
              label: 'Number of People',
              data: values,
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)'
              ],
              borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)'
              ],
              borderWidth: 1
            }
          ]
        };

        setChartData(newChartData);
      } else {
        console.error('No data fetched or data is empty');
      }
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
    <div className="container mt-4">
      <div className="card p-3 shadow">
        <h2 className="mb-3 text-center">Analytics</h2>
        <p>This is the analytics page. You can display various charts, graphs, and data analysis here.</p>
        <div className="mt-4">
          {chartData ? (
            <Bar data={chartData} />
          ) : (
            <p>Loading chart...</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default AnalyticsPage;
