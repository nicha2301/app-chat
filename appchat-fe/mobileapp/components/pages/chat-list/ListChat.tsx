import { BackgroundSvg } from "@/components/common/Background";
import Carousel from "@/components/common/Carousel";
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";
import React from "react";
import { View } from "react-native";
import Nav from "../../common/Nav";
import { screenStyles } from "../call/Styles";
import MessageList from "./MessageList";

const MessageListScreen: React.FC = () => {
  return (
    <View style={[screenStyles.container, { backgroundColor: "#242C3B" }]}>
      <BackgroundSvg />
      <Header />
      <Carousel />
      <Nav />
      <MessageList />
      <Footer />
    </View>
  );
};

export default MessageListScreen;
