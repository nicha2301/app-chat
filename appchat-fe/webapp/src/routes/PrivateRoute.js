import React, { useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children }) => {
  const authToken = localStorage.getItem('authToken');
  const [isValidToken, setIsValidToken] = useState(null);

  useEffect(() => {
    const checkTokenValidity = async () => {
      if (!authToken) {
        setIsValidToken(false);
        return;
      }

      try {
        const response = await fetch('http://localhost:8080/api/auth/introspect', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${authToken}`
          },
          body: JSON.stringify({ token: authToken })
        });

        if (!response.ok) {
          throw new Error('Failed to validate token');
        }

        const data = await response.json();

        setIsValidToken(data.result.valid);

        if (!data.result.valid) {
          localStorage.removeItem('authToken');
        }
      } catch (error) {
        console.error('Error validating token:', error);
        setIsValidToken(false);
        localStorage.removeItem('authToken');
      }
    };

    checkTokenValidity();
  }, [authToken]);

  if (isValidToken === null) {
    return null;
  }

  return isValidToken ? children : <Navigate to="/auth/login" />;
};

export default PrivateRoute;
