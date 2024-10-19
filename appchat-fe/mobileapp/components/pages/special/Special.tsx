import { BlurView } from "expo-blur";
import React from "react";
import { View } from "react-native";
import Header from "../../common/Header";
import Nav from "../../common/Nav";
import { screenStyles } from "../../common/Styles";
import { ListCalls } from "../call/ListCalls";
import Footer from "@/components/common/Footer";
import RecentList from "./ListSpecial";
import { Background } from "@/components/common/Svg";

const SpecialScreen: React.FC = () => {
  return (
    <View style={screenStyles.container}>
      <Background />
      <BlurView
        style={screenStyles.backGround}
        intensity={80}
        tint="systemThinMaterialDark"
      >
        <Header />
        <Nav />
        <RecentList />
        <Footer />
      </BlurView>
    </View>
  );
};

export default SpecialScreen;
