import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

class WebSocketService {
  constructor() {
    this.client = new Client({
      brokerURL: 'ws://localhost:8080/ws',
      connectHeaders: {
        Authorization: `Bearer ${localStorage.getItem('authToken')}`,
      },
      debug: function (str) {
        console.log(str);
      },
      reconnectDelay: 5000,
      heartbeatIncoming: 4000,
      heartbeatOutgoing: 4000,
      webSocketFactory: () => new SockJS('http://localhost:8080/ws'),
    });

  }

  connect(onMessageReceived) {
    this.client.onConnect = () => {
      console.log("Connected to WebSocket");
      this.client.subscribe('/topic/messages', (message) => {
        const receivedMsg = JSON.parse(message.body);
        console.log("Received message:", receivedMsg);
        onMessageReceived(receivedMsg);
      });
    };
    this.client.activate();
  }

  sendMessage(message) {
    if (this.client.connected) {
      this.client.publish({
        destination: '/app/chat',
        body: JSON.stringify(message),
      });
    } else {
      console.error("WebSocket is not connected");
    }
  }

  disconnect() {
    this.client.deactivate();
  }

  fetchMessages(userId) {
    return fetch(`http://localhost:8080/api/messages/${userId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch messages');
        }
        return response.json();
      });
  }

  fetchConversation(userId1, userId2) {
    return fetch(`http://localhost:8080/api/messages/conversation/${userId1}/${userId2}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch messages');
        }
        return response.json();
      });
  }
}

const webSocketService = new WebSocketService();
export default webSocketService;