import { Stack } from "expo-router";
import { StatusBar } from "expo-status-bar";
import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function App() {
    return (
        <Stack>
        <Stack.Screen name="ListChat" options={{ title: "Chat list" }} />
        <Stack.Screen name="Call" options={{ title: "Call List" }} />
      </Stack>
    )
}