import { Box, Stack } from '@mui/material'
import React, { useEffect, useState } from 'react';
import { Chat_History } from '../../data'
import { DocMsg, LinkMsg, MediaMsg, ReplyMsg, TextMsg, TimeLine } from './MsgTypes';
import webSocketService from '../../services/WebSocketService';

const Message = ({ menu }) => {
  const [messages, setMessages] = useState([]);

  useEffect(() => {
    // Gọi API để lấy tin nhắn
    webSocketService.fetchConversation("66d280ce6f7ec43b067db479", "66d5810e4d02c06fe652b40b")
      .then(data => {
        setMessages(data.result);
      })
      .catch(error => {
        console.error('Error fetching messages:', error);
      });

  }, []);

  return (
    <Box p={3}>
      <Stack spacing={3}>
        {messages.map((el) => {
          switch (el.messageType) {
            case 'img':
              return <MediaMsg el={el} menu={menu} />
            case 'doc':
              return <DocMsg el={el} menu={menu} />
            case 'link':
              return <LinkMsg el={el} menu={menu} />
            case 'reply':
              return <ReplyMsg el={el} menu={menu} />

            default:
              return <TextMsg el={el} menu={menu} />
          }
        })}
      </Stack>
    </Box>
  )
}

export default Message