import { LinearGradient } from "expo-linear-gradient";
import React from "react";
import { Text, View } from "react-native";
import Svg, { Path } from "react-native-svg";
import { headerStyles } from "./Styles";
import { Icons } from "./Svg";

const Header: React.FC = () => {
  return (
    <View style={headerStyles.header}>
      <Text style={headerStyles.title}>Harmony</Text>
      <View style={headerStyles.borderContainer}>
        <LinearGradient
          colors={["#34C8E8", "#6864FF"]}
          start={{ x: 0, y: 0 }}
          end={{ x: 1, y: 1 }}
          style={headerStyles.searchContainer}
        >
          <Icons.Search/>
        </LinearGradient>
      </View>
    </View>
  );
};

export default Header;
