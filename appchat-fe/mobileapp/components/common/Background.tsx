import React from "react";
import Svg, { Defs, LinearGradient, Path, Stop } from "react-native-svg";

export const BackgroundSvg = () => {
  return (
    <Svg
      width="400"
      height="750"
      viewBox="0 0 400 750"
      fill="none"
      style={{ position: "absolute", bottom: 0, right: 0 }}
    >
      <Path
        d="M265.5 176.5L340.5 0.5L416.5 68.5L405 869L-8.5 853.5C98.5037 589.115 158.496 440.885 265.5 176.5Z"
        fill="url(#paint0_linear_30_21527)"
      />
      <Defs>
        <LinearGradient
          id="paint0_linear_30_21527"
          x1="203"
          y1="35"
          x2="407"
          y2="755"
          gradientUnits="userSpaceOnUse"
        >
          <Stop stopColor="#37B6E9" />
          <Stop offset="1" stopColor="#4B4CED" />
        </LinearGradient>
      </Defs>
    </Svg>
  );
};
