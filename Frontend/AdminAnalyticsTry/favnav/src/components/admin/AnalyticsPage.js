import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Bar, Pie, Doughnut } from 'react-chartjs-2';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Chart, registerables } from 'chart.js';

Chart.register(...registerables);

function AnalyticsPage() {
  const [ageChartData, setAgeChartData] = useState(null);
  const [genderChartData, setGenderChartData] = useState(null);

  useEffect(() => {
    fetchData();
    return () => {
      setAgeChartData(null);
      setGenderChartData(null);
    };
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/admin/student');
      const data = response.data;

      if (data && data.length > 0) {
        // Calculate age group distribution
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

        // Create data for age group pie chart
        const ageChart = {
          labels: Object.keys(ageGroups),
          datasets: [
            {
              label: 'Age Group',
              data: Object.values(ageGroups),
              backgroundColor: [
                'rgba(94, 252, 3, 0.5)',
                'rgba(232, 252, 3, 0.5)',
                'rgba(255, 206, 86, 0.5)',
                'rgba(75, 192, 192, 0.5)'
              ],
              borderWidth: 1
            }
          ]
        };

        setAgeChartData(ageChart);

        // Calculate gender distribution
        const genderCounts = {
          Male: 0,
          Female: 0,
          Others: 0
        };

        data.forEach(entry => {
          const gender = entry.gender.toLowerCase();
          if (gender === 'male' || gender === 'm') {
            genderCounts.Male++;
          } else if (gender === 'female' || gender === 'f') {
            genderCounts.Female++;
          } else {
            genderCounts.Others++;
          }
        });

        // Create data for gender doughnut chart
        const genderChart = {
          labels: Object.keys(genderCounts),
          datasets: [
            {
              label: 'Gender Distribution',
              data: Object.values(genderCounts),
              backgroundColor: [
                'rgba(54, 162, 235, 0.5)',
                'rgba(255, 99, 132, 0.5)',
                'rgba(255, 206, 86, 0.5)'
              ],
              borderWidth: 1
            }
          ]
        };

        setGenderChartData(genderChart);
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
        <p>Age Group and Gender analysis for students </p>
        <div className="row mt-4">
          <div className="col-md-6">
            {ageChartData ? (
              <Pie data={ageChartData} options={{ plugins: { legend: { display: true } } }} />
            ) : (
              <p>Loading age group chart...</p>
            )}
          </div>
          <div className="col-md-6">
            {genderChartData ? (
              <Doughnut data={genderChartData} options={{ plugins: { legend: { display: true } } }} />
            ) : (
              <p>Loading gender distribution chart...</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default AnalyticsPage;
