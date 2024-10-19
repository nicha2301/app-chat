import React from "react";
import { View, Text, Image, TouchableOpacity, StyleSheet } from "react-native";
import { Path, Svg } from "react-native-svg";
import { ListCallItems, SpecialItems } from "../../common/Styles";
import { Special } from "@/components/common/model";


const SpecialItem: React.FC<{ item: Special }> = ({ item }) => {
  const emojiReactions = ["😘", "😆", "😭"]; //max-3
  // const emojiReactions = ["😘","😆","😭","👍","🥳","😡"];

  return (
    <TouchableOpacity style={SpecialItems.specialItem}>
      <Image source={{ uri: item.avatar }} style={SpecialItems.avatar} />
      <View style={SpecialItems.info}>
        <Text style={SpecialItems.name}>{item.name}</Text>
        <View style={SpecialItems.statusTimeContainer}>
          <Text style={SpecialItems.content} numberOfLines={1}>
            {item.message}
          </Text>
        </View>
      </View>
      <View style={SpecialItems.emojiReactions}>
        {emojiReactions.map((emoji, index) => (
          <Text key={index} style={[SpecialItems.emoji, { left: index * 17 }]}>
            {emoji}
          </Text>
        ))}
      </View>
      <View style={SpecialItems.borderBottom}/>
    </TouchableOpacity>
  );
};

export default SpecialItem;
