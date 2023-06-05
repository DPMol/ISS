import { useState } from 'react';
import Login from './Login'
import { Routes ,Route, Navigate } from 'react-router-dom';
import { Role, User } from './Types';
import MedicineList from './MedicineAdmin';
import MedicineListPersonnel from './MedicinePersonnel';
import OrderList from './OrderList';

function App() {
  const [user, setUser] = useState<User | null>(null);

  const handleLogin = (loggedInUser: User) => {
    setUser(loggedInUser);
  };

  const handleLogout = () => {
    setUser(null);
  };

  return (
    <div className="app-container"> {/* Apply the CSS class */}
      <Routes>
        <Route path='/'
         element={user?.role === Role.Personnel || user?.role === Role.Admin ? (
          <Navigate to="/medicines" />
        ) : user?.role === Role.Pharmacist ? (
          <Navigate to="/orders" />
        ) : (
          <Login onLogin={handleLogin} />
        )}/>
        <Route path='/medicines'
         element=
         {user?.role === Role.Admin ? (
          <div>
            <h2>Welcome, {user.username}!</h2>
            <button onClick={handleLogout}>Logout</button>
            <MedicineList />
          </div>
        ) : user?.role === Role.Personnel ? (
          <div>
            <h2>Welcome, {user.username}!</h2>
            <button onClick={handleLogout}>Logout</button>
            <MedicineListPersonnel user={user}/>
          </div>
        ) : (
          <Navigate to="/" />
        )}/>
        <Route path='/orders'
        element=
        {user?.role === Role.Pharmacist ? (
          <div>
            <h2>Welcome, {user.username}!</h2>
            <button onClick={handleLogout}>Logout</button>
            <OrderList user0={user}/>
          </div>
        ) :(
          <Navigate to="/" />
        )}/>
      </Routes>
    </div>
  );
}

export default App;