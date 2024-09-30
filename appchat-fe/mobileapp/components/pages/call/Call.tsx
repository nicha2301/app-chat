import { BackgroundSvg } from "@/components/common/Background";
import { BlurView } from "expo-blur";
import React from "react";
import { View } from "react-native";
import Footer from "../../common/Footer";
import Header from "../../common/Header";
import { ListCalls } from "./ListCalls";
import Nav from "../../common/Nav";
import { screenStyles } from "./Styles";

const CallListScreen: React.FC = () => {
  return (
    <View style={screenStyles.container}>
      <BackgroundSvg />
      <BlurView
        style={screenStyles.backGround}
        intensity={80}
        tint="systemThinMaterialDark"
      >
        <Header />
        <Nav />
        <ListCalls />
        {/* <Footer /> */}
      </BlurView>
    </View>
  );
};


export default CallListScreen;
