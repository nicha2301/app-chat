import { cameraScreenStyles } from "@/components/common/Styles";
import { Icons } from "@/components/common/Svg";
import { useNavigation } from "@react-navigation/native";
import { Camera, CameraView } from "expo-camera"; // Chỉ cần import Camera
import { CameraType, FlashMode } from "expo-camera/build/legacy/Camera.types";
import * as ImagePicker from "expo-image-picker";
import * as MediaLibrary from "expo-media-library";
import React, { useEffect, useRef, useState } from "react";
import {
    Alert,
    Image,
    Text,
    TouchableOpacity,
    View
} from "react-native";
import { CameraPreview } from "./CameraPreview";

export default function CameraScreen() {
  const [startCamera, setStartCamera] = useState(false);
  const cameraRef = useRef<CameraView | null>(null); // Sử dụng Camera từ expo-camera
  const [previewVisible, setPreviewVisible] = useState(false);
  const [capturedImage, setCapturedImage] = useState<any>(null);
  const [flashMode, setFlashMode] = useState<FlashMode>(FlashMode.off);
  const [cameraType, setCameraType] = React.useState(CameraType.back);
  const [lastPhoto, setLastPhoto] = useState<string | null>(null);
  const navigation = useNavigation();

  const __startCamera = async () => {
    const { status } = await Camera.requestCameraPermissionsAsync();
    if (status === "granted") {
      setStartCamera(true);
    } else {
      Alert.alert("Access denied");
    }
  };

  useEffect(() => {
    __getLastPhoto(); // Lấy ảnh gần nhất khi mở camera
  }, []);

  const __getLastPhoto = async () => {
    const { status } = await MediaLibrary.requestPermissionsAsync();
    if (status === "granted") {
      const album = await MediaLibrary.getAssetsAsync({
        sortBy: [MediaLibrary.SortBy.creationTime],
        mediaType: "photo",
        first: 1, // Lấy 1 ảnh gần nhất
      });
      if (album.assets.length > 0) {
        setLastPhoto(album.assets[0].uri); // Cập nhật URI ảnh gần nhất
      }
    } else {
      Alert.alert("Access to media library is required!");
    }
  };

  const __takePicture = async () => {
    if (!cameraRef) return;
    const photo = await cameraRef.current?.takePictureAsync();
    console.log(photo);
    setPreviewVisible(true);
    setCapturedImage(photo);
  };

  const __retakePicture = () => {
    setCapturedImage(null);
    setPreviewVisible(false);
    __startCamera();
  };

  // logic gửi ảnh cho đối phương sau khi chụp
  const __sendPhoto = async (navigation: any) => {
    if (!capturedImage) return;

    try {
      // logic gửi ảnh cho đối phương
      // Ví dụ: upload ảnh đến server hoặc gửi qua API
      console.log("Gửi ảnh:", capturedImage.uri);
      navigation.goBack();
    } catch (error) {
      console.error("Lỗi khi gửi ảnh:", error);
    }
  };

  const __pickFromGallery = async () => {
    let result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsMultipleSelection: true,
    });

    if (!result.canceled) {
      __handleSendSelectedPhotos(result.assets);
    }
  };

  // logic gửi ảnh cho đối phương sau khi chọn ảnh từ thư viện
  const __handleSendSelectedPhotos = (selectedPhotos: any) => {
    if (!selectedPhotos || selectedPhotos.length === 0) return;

    setStartCamera(false);

    // Logic gửi ảnh cho đối phương
    console.log("Gửi các ảnh đã chọn:", selectedPhotos);

    navigation.goBack();
  };

  const __toggleFlash = () => {
    setFlashMode((prevMode: any) =>
      prevMode === FlashMode.off ? FlashMode.on : FlashMode.off
    );
  };

  const __flipCamera = () => {
    setCameraType((prevMode: any) =>
      prevMode === CameraType.back ? CameraType.front : CameraType.back
    );
  };

  //vì 1 số lý do mà prop flash của CameraView không nhận giá trị của flashMode
  const flashToggle = (flashMode: FlashMode) => {
    return flashMode === FlashMode.off ? FlashMode.off : FlashMode.on;
  };

  return (
    <View style={{ flex: 1 }}>
      {previewVisible && capturedImage ? (
        <CameraPreview
          photo={capturedImage}
          sendPhoto={() => __sendPhoto(navigation)}
          retakePicture={__retakePicture}
        />
      ) : (
        <CameraView
          style={cameraScreenStyles.viewContainer}
          ref={cameraRef}
          flash={flashToggle(flashMode)}
          facing={cameraType}
        >
          {/* Nút trên cùng */}
          <View style={cameraScreenStyles.topBar}>
            <TouchableOpacity
              onPress={__toggleFlash}
              style={cameraScreenStyles.flashButton}
            >
              {flashMode === FlashMode.off ? (
                <Icons.FlashOn />
              ) : (
                <Icons.FlashOff />
              )}
            </TouchableOpacity>
            <TouchableOpacity
              onPress={() => navigation.goBack()}
              style={cameraScreenStyles.exitButton}
            >
              <Icons.CloseWhite />
            </TouchableOpacity>
          </View>

          {/* Nút dưới cùng */}
          <View style={cameraScreenStyles.bottomBar}>
            <TouchableOpacity
              onPress={__pickFromGallery}
              style={cameraScreenStyles.iconButton}
            >
              {lastPhoto ? (
                <Image
                  source={{ uri: lastPhoto }}
                  style={cameraScreenStyles.galleryImage}
                />
              ) : (
                <Text style={cameraScreenStyles.iconText}>Gallery</Text>
              )}
            </TouchableOpacity>
            <TouchableOpacity onPress={__takePicture}>
              <Icons.Capture />
            </TouchableOpacity>
            <TouchableOpacity onPress={__flipCamera}>
              <Icons.FlipCamera />
            </TouchableOpacity>
          </View>
        </CameraView>
      )}
    </View>
  );
}
