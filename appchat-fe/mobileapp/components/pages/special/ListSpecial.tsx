import { FontAwesome } from "@expo/vector-icons";
import React from "react";
import { View, Text, FlatList, StyleSheet, TouchableOpacity, Image } from "react-native";
import { flatStyle } from "../../common/Styles";
import { Message, Special } from "@/components/common/model";
import SpecialItem from "./SpecialItem";
import { specials } from "@/components/common/Data";


const RecentList: React.FC = () => {
   return (
    <View style={flatStyle.containerFlat}>
      <Text style={flatStyle.recentCallText}>Recent</Text>
      <FlatList
        data={specials}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => <SpecialItem item={item} />}
        contentContainerStyle={flatStyle.flatList}
        showsVerticalScrollIndicator={false} 
        scrollEnabled={true} 
      />
    </View>
   )
};


export default RecentList;
