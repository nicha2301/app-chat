import { Box, Stack } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { useTheme } from "@mui/material/styles";
import Header from './Header';
import Footer from './Footer';
import Message from './Message';

const Conversation = () => {
  const theme = useTheme();
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080/ws');

    socket.onmessage = (event) => {
      const newMessage = JSON.parse(event.data);
      setMessages((prevMessages) => [...prevMessages, newMessage]);
    };

    return () => {
      socket.close();
    };
  }, []);
  return (
    <Stack height={'100%'} maxHeight={'100vh'} width={'auto'}>

      {/* Chat header */}
      <Header />
      {/* Msg */}
      <Box className='scrollbar' width={"100%"} sx={{ flexGrow: 1, height: '100%', overflowY: 'scroll' }}>
        <Message menu={true}/>
      </Box>
      {/* Chat footer */}
      <Footer />
    </Stack>
  )
}

export default Conversation