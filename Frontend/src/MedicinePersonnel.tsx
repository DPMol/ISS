import React, { useEffect, useState } from 'react';
import { Medicine, User } from './Types';
import './MedicinePersonnel.css';

interface MedicineListPersonnelProps {
  user: User;
}

const MedicineListPersonnel: React.FC<MedicineListPersonnelProps> = ({ user }) => {
  const [medicines, setMedicines] = useState<Medicine[]>([]);
  const [selectedMedicine, setSelectedMedicine] = useState<Medicine | null>(null);
  const [quantity, setQuantity] = useState('');

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

  const handleMedicineSelect = (medicine: Medicine) => {
    setSelectedMedicine(medicine);
  };

  const handleOrder = () => {
    if (!selectedMedicine || !quantity) {
      return;
    }

    const orderData = {
      username: user.username,
      medicineId: selectedMedicine.id,
      quantity: parseInt(quantity),
    };

    fetch('http://localhost:8080/order/create', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(orderData),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Order created:', data);
        fetchMedicineList();
        // Handle successful order creation if needed
      })
      .catch(error => {
        console.error('Error creating order:', error);
        // Handle error condition if needed
      });
  };

  const handleQuantityChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setQuantity(event.target.value);
  };

  return (
    <div className="medicine-list-container">
      <div className="order-form">
        <h3>Order Form</h3>
        {selectedMedicine ? (
          <div>
            <label htmlFor="quantity">Quantity:</label>
            <input type="number" id="quantity" value={quantity} onChange={handleQuantityChange} />
            <button onClick={handleOrder}>Order</button>
          </div>
        ) : (
          <p>Please select a medicine.</p>
        )}
      </div>
      <div className="medicine-list-content">
        <h2>Medicine List</h2>
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

export default MedicineListPersonnel;
