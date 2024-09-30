import React from "react";
import { FlatList, Text, View } from "react-native";
import callsData from "./CallData";
import CallItem from "./CallItem";
import { flatStyle } from "./Styles";

export const ListCalls = () => {
  return (
    <View style={flatStyle.containerFlat}>
      <Text style={flatStyle.recentCallText}>Recent</Text>
      <FlatList
        data={callsData}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => <CallItem item={item} />}
        contentContainerStyle={flatStyle.flatList}
        showsVerticalScrollIndicator={false} 
        scrollEnabled={true} 
      />
    </View>
  );
};
