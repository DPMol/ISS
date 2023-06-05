import React, { useEffect, useState } from 'react';
import { Order, Section, User } from './Types';
import './OrderList.css';

interface OrderListProps {
    user0: User;
}

const OrderList: React.FC<OrderListProps> = ({ user0 }) => {
  const [orders, setOrders] = useState<Order[]>([]);
  const [sections, setSections] = useState<Section[]>([]);
  const [selectedOrder, setSelectedOrder] = useState<Order | null>(null);
  const [user, setUser] = useState<User>(user0);

  useEffect(() => {
    fetchOrderList();
    fetchSectionList();
  }, []);

  const fetchOrderList = () => {
    // Get the section ID from the user object
    const sectionId = user?.section?.id;

    // Create the API endpoint URL with the section ID as a parameter
    const url = `http://localhost:8080/order/getall?sectionId=${sectionId}`;
    fetch(url)
      .then(response => response.json())
      .then(data => {
        const parsedOrders: Order[] = data.map((item: any) => ({
          id: item.id,
          createdBy: item.createdBy,
          date: new Date(item.date),
          quantity: item.quantity,
          medicine: item.medicine,
          section: item.section,
        }));
        setOrders(parsedOrders);
      })
      .catch(error => {
        console.error('Error fetching orders:', error);
        // Handle error condition if needed
      });
  };

  const fetchOrderList2 = (section: string) => {
    // Get the section ID from the user object
    const sectionId = section;

    // Create the API endpoint URL with the section ID as a parameter
    const url = `http://localhost:8080/order/getall?sectionId=${sectionId}`;
    fetch(url)
      .then(response => response.json())
      .then(data => {
        const parsedOrders: Order[] = data.map((item: any) => ({
          id: item.id,
          createdBy: item.createdBy,
          date: new Date(item.date),
          quantity: item.quantity,
          medicine: item.medicine,
          section: item.section,
        }));
        setOrders(parsedOrders);
      })
      .catch(error => {
        console.error('Error fetching orders:', error);
        // Handle error condition if needed
      });
  };

  const handleOrderSelect = (order: Order) => {
    setSelectedOrder(order);
  };

  const handleOrderHonor = () => {
    if (selectedOrder) {
      const orderId = selectedOrder.id;

      fetch(`http://localhost:8080/order/honor`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ orderId: orderId }),
      })
        .then(response => {
          if (response.ok) {
            console.log('Order honored successfully');
            // Perform any necessary actions after honoring the order
          } else {
            console.error('Error honoring order:', response.statusText);
            // Handle error condition if needed
          }
          fetchOrderList();
        })
        .catch(error => {
          console.error('Error honoring order:', error);
          // Handle error condition if needed
        });
    }
  };

  const fetchSectionList = () => {
    const url = 'http://localhost:8080/sections/getall';

    fetch(url)
      .then(response => response.json())
      .then(data => {
        const parsedSections: Section[] = data.map((item: Section) => ({
          id: item.id,
          name: item.name,
        }));
        setSections(parsedSections);
      })
      .catch(error => {
        console.error('Error fetching sections:', error);
        // Handle error condition if needed
      });
  };
  
  const fetchUser = () => {
    const username = user.username;

    const url = `http://localhost:8080/users/getuserdetails?username=${username}`;

    fetch(url)
      .then(response => response.json())
      .then(data => {
        const newUser: User = {
          username: data.username,
          role: data.role,
          section: data.section,
        };
        setUser(newUser);
      })
      .catch(error => {
        console.error('Error fetching user:', error);
        // Handle error condition if needed
      });
  };

  const handleSectionChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedId = event.target.value;
    console.log(selectedId);
    // Send request to honor order
    const orderData = {
      username: user.username,
      sectionId: selectedId,
    };

    fetch('http://localhost:8080/users/updatesection', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(orderData),
    })
      .then(data => {
        console.log('Order honored:', data);
        fetchUser(); // Fetch the updated user
        fetchOrderList2(selectedId);
        // Handle successful order honoring if needed
      })
      .catch(error => {
        console.error('Error honoring order:', error);
        // Handle error condition if needed
      });
  };

  return (
    <div className="order-list-container">
      <div className="order-list-content">
      <div className="section-dropdown">
          <label htmlFor="section">Select Section:</label>
          <select id="section" value={user.section.id} onChange={handleSectionChange} onClick={fetchSectionList}>
            {sections.map(section => (
              <option key={section.id} value={section.id}>
                {section.name}
              </option>
            ))}
          </select>
        </div>
        <h2>Order List</h2>
        <button onClick={handleOrderHonor} disabled={!selectedOrder}>
          Honor Order
        </button>
        {orders.length > 0 ? (
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Created By</th>
                <th>Date</th>
                <th>Quantity</th>
                <th>Medicine Id</th>
                <th>Medicine Name</th>
              </tr>
            </thead>
            <tbody>
              {orders.map(order => (
                <tr
                  key={order.id}
                  className={selectedOrder === order ? 'selected' : ''}
                  onClick={() => handleOrderSelect(order)}
                >
                  <td>{order.id}</td>
                  <td>{order.createdBy}</td>
                  <td>{order.date.toLocaleDateString()}</td>
                  <td>{order.quantity}</td>
                  <td>{order.medicine.id}</td>
                  <td>{order.medicine.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>No orders found.</p>
        )}
      </div>
    </div>
  );
};

export default OrderList;
