import React, { useEffect, useState } from 'react';
import { Medicine } from './Types';
import './MedicineAdmin.css';

const MedicineList: React.FC = () => {
  const [medicines, setMedicines] = useState<Medicine[]>([]);
  const [selectedMedicine, setSelectedMedicine] = useState<Medicine | null>(null);
  const [newMedicineName, setNewMedicineName] = useState('');

  useEffect(() => {
    fetchMedicineList();
  }, []);

  const fetchMedicineList = () => {
    fetch('http://localhost:8080/medicine/getall')
      .then(response => response.json())
      .then(data => {
        const parsedMedicines: Medicine[] = data.map((item: any) => ({
          id: item.id,
          name: item.name,
        }));
        setMedicines(parsedMedicines);
      })
      .catch(error => {
        console.error('Error fetching medicines:', error);
        // Handle error condition if needed
      });
  };

  const handleNewMedicineChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setNewMedicineName(event.target.value);
  };

  const handleCreateMedicine = () => {
    fetch('http://localhost:8080/medicine/create', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ name: newMedicineName }),
    })
      .then(data => {
        console.log('Medicine created:', data);
        setNewMedicineName('');
        fetchMedicineList(); // Reload the medicine list after successful creation
      })
      .catch(error => {
        console.error('Error creating medicine:', error);
        // Handle error condition if needed
      });
  };

  const handleMedicineSelect = (medicine: Medicine) => {
    setSelectedMedicine(medicine);
  };

  return (
    <div className="medicine-list-container">
      <div className="medicine-list-content">
        <h2>Medicine List</h2>
        <div className="medicine-form">
          <input
            type="text"
            value={newMedicineName}
            onChange={handleNewMedicineChange}
            placeholder="Enter medicine name"
          />
          <button onClick={handleCreateMedicine}>Create Medicine</button>
        </div>
        {medicines.length > 0 ? (
          <table className="medicine-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
              </tr>
            </thead>
            <tbody>
              {medicines.map(medicine => (
                <tr
                  key={medicine.id}
                  className={selectedMedicine === medicine ? 'selected' : ''}
                  onClick={() => handleMedicineSelect(medicine)}
                >
                  <td>{medicine.id}</td>
                  <td>{medicine.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>No medicines found.</p>
        )}
      </div>
    </div>
  );
};

export default MedicineList;
