import Carousel from "@/components/common/Carousel";
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";
import React from "react";
import { View } from "react-native";
import Nav from "../../common/Nav";
import { screenStyles } from "../../common/Styles";
import MessageList from "./MessageList";
import { Background } from "@/components/common/Svg";

const MessageListScreen: React.FC = () => {
  return (
    <View style={[screenStyles.container, { backgroundColor: "#242C3B" }]}>
      <Background />
      <Header />
      <Carousel />
      <Nav />
      <MessageList />
      <Footer />
    </View>
  );
};

export default MessageListScreen;
