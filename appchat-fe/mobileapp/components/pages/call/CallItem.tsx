import React from "react";
import { Image, Text, TouchableOpacity, View } from "react-native";
import { Path, Svg } from "react-native-svg";
import { ListCallItems } from "../../common/Styles";
import { CallItem } from "@/components/common/model";
import { Icons } from "@/components/common/Svg";

const CallItems: React.FC<{ item: CallItem }> = ({ item }) => {
  const getCallIcon = () => {
    switch (item.callType) {
      case "incoming":
        return <Icons.Incoming />;
      case "outgoing":
        return <Icons.Outgoing />;
      case "missed":
        return <Icons.Missed />;
      default:
        return null;
    }
  };

  return (
    <TouchableOpacity style={ListCallItems.callItem}>
      <Image source={{ uri: item.avatar }} style={ListCallItems.avatar} />
      <View style={ListCallItems.info}>
        <Text style={ListCallItems.name}>{item.name}</Text>
        <View style={ListCallItems.statusTimeContainer}>
          <View>{getCallIcon()}</View>
          <Text style={ListCallItems.time}>{item.time}</Text>
        </View>
      </View>
      <View style={ListCallItems.icons}>
        <TouchableOpacity
          style={{ marginRight: 15 }}
          onPress={() => console.log("Call Pressed")}
        >
          <Icons.Call />
        </TouchableOpacity>
        <TouchableOpacity onPress={() => console.log("Video Call Pressed")}>
          <Icons.VideoCall />
        </TouchableOpacity>
      </View>
      <View style={ListCallItems.borderBottom}></View>
    </TouchableOpacity>
  );
};

export default CallItems;
