import React from "react";
import { FlatList, Text, View } from "react-native";
import CallItem from "./CallItem";
import { flatStyle } from "../../common/Styles";
import { callsData } from "../../common/Data";

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
