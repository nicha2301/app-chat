// icons.js (hoặc icons.tsx nếu dùng TypeScript)
import React from "react";
import {
  Svg,
  Path,
  Defs,
  LinearGradient,
  Stop,
  Circle,
  G,
  ClipPath,
  Rect,
} from "react-native-svg";

export const Incoming = () => (
  <Svg width="15" height="15" viewBox="0 0 15 15" fill="none">
    <Path
      d="M12.1093 5.39909L10.6907 5.39909C9.90717 5.39909 9.27201 4.77861 9.27201 4.01321V2.62733M13.528 1.24146L9.98134 4.70615M13.528 11.188V12.3285C13.528 13.0939 12.8929 13.7144 12.1093 13.7144C5.84128 13.7144 0.76001 8.75053 0.76001 2.62733C0.76001 1.86193 1.39517 1.24146 2.17868 1.24146H3.34619C3.92629 1.24146 4.44795 1.58647 4.66339 2.11263L5.24054 3.52217C5.51457 4.19139 5.21773 4.95409 4.55779 5.27643L4.30668 5.39909C4.30668 5.39909 4.66134 7.13144 6.08001 8.51732C7.49868 9.9032 9.27201 10.2497 9.27201 10.2497L9.39757 10.0044C9.72754 9.35967 10.5083 9.06969 11.1933 9.33738L12.6362 9.9012C13.1748 10.1117 13.528 10.6213 13.528 11.188Z"
      stroke="#139C6F"
      strokeWidth="1.2"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Outgoing = () => (
  <Svg width="15" height="15" viewBox="0 0 15 15" fill="none">
    <Path
      d="M10.6907 1.49268H12.1093C12.8929 1.49268 13.528 2.11315 13.528 2.87855V4.26443M9.27201 5.65031L12.8187 2.18562M13.528 11.4392V12.5797C13.528 13.3451 12.8929 13.9656 12.1093 13.9656C5.84128 13.9656 0.76001 9.00175 0.76001 2.87855C0.76001 2.11315 1.39517 1.49268 2.17868 1.49268H3.34619C3.92629 1.49268 4.44795 1.83769 4.66339 2.36385L5.24054 3.77339C5.51457 4.44261 5.21773 5.20531 4.55779 5.52766L4.30668 5.65031C4.30668 5.65031 4.66134 7.38266 6.08001 8.76854C7.49868 10.1544 9.27201 10.5009 9.27201 10.5009L9.39757 10.2556C9.72754 9.61089 10.5083 9.32091 11.1933 9.5886L12.6362 10.1524C13.1748 10.3629 13.528 10.8725 13.528 11.4392Z"
      stroke="#5F40DC"
      strokeWidth="1.2"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Missed = () => (
  <Svg width="15" height="14" viewBox="0 0 15 14" fill="none">
    <Path
      d="M12.8187 4.33176L9.98134 1.56M13.528 2.94588C13.528 4.09398 12.5753 5.0247 11.4 5.0247C10.2247 5.0247 9.27201 4.09398 9.27201 2.94588C9.27201 1.79778 10.2247 0.867065 11.4 0.867065C12.5753 0.867065 13.528 1.79778 13.528 2.94588ZM13.528 10.8136V11.9541C13.528 12.7195 12.8928 13.34 12.1093 13.34C5.84128 13.34 0.76001 8.37614 0.76001 2.25294C0.76001 1.48754 1.39517 0.867065 2.17868 0.867065H3.34619C3.92629 0.867065 4.44795 1.21208 4.66339 1.73824L5.24054 3.14778C5.51457 3.817 5.21773 4.5797 4.55779 4.90205L4.30668 5.0247C4.30668 5.0247 4.66134 6.75705 6.08001 8.14293C7.49868 9.52881 9.27201 9.87528 9.27201 9.87528L9.39757 9.62996C9.72754 8.98528 10.5083 8.6953 11.1933 8.96299L12.6362 9.52681C13.1748 9.73727 13.528 10.2469 13.528 10.8136Z"
      stroke="#EA3736"
      strokeWidth="1.2"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Call = () => (
  <Svg width="26" height="26" viewBox="0 0 26 26" fill="none">
    <Path
      d="M16.3278 17.1626L16.184 17.8987C16.5121 17.9628 16.8431 17.8019 16.9954 17.5043L16.3278 17.1626ZM8.87981 9.88672L8.55065 9.21281C8.24328 9.36295 8.07645 9.70203 8.14506 10.0371L8.87981 9.88672ZM9.25649 9.70274L9.58565 10.3766L9.25649 9.70274ZM10.2806 7.07133L10.9747 6.78714L10.9747 6.78714L10.2806 7.07133ZM9.41489 4.95703L8.72082 5.24123L9.41489 4.95703ZM21.3741 16.6399L21.1012 17.3384L21.3741 16.6399ZM19.2098 15.7942L19.4828 15.0956L19.2098 15.7942ZM16.5162 16.7946L17.1838 17.1363L17.1838 17.1363L16.5162 16.7946ZM17.7058 11.9655C17.7058 12.3798 18.0416 12.7155 18.4558 12.7155C18.87 12.7155 19.2058 12.3798 19.2058 11.9655H17.7058ZM18.1318 10.3745L18.8223 10.0817L18.1318 10.3745ZM15.8285 8.12438L16.1098 7.42915L15.8285 8.12438ZM14.1998 7.0579C13.7856 7.0579 13.4498 7.39369 13.4498 7.8079C13.4498 8.22212 13.7856 8.5579 14.1998 8.5579V7.0579ZM21.9618 11.9655C21.9618 12.3798 22.2976 12.7155 22.7118 12.7155C23.126 12.7155 23.4618 12.3798 23.4618 11.9655H21.9618ZM22.0639 8.78342L22.7544 8.49064V8.49064L22.0639 8.78342ZM17.4572 4.28323L17.7385 3.58799V3.58799L17.4572 4.28323ZM14.1998 2.90027C13.7856 2.90027 13.4498 3.23605 13.4498 3.65027C13.4498 4.06448 13.7856 4.40027 14.1998 4.40027V2.90027ZM21.9618 18.57V20.2808H23.4618V18.57H21.9618ZM5.68781 4.40027H7.43909V2.90027H5.68781V4.40027ZM16.3278 17.1626C16.4716 16.4265 16.4718 16.4265 16.472 16.4266C16.4721 16.4266 16.4723 16.4266 16.4724 16.4266C16.4726 16.4267 16.4728 16.4267 16.4729 16.4267C16.4731 16.4268 16.4732 16.4268 16.4732 16.4268C16.4731 16.4268 16.4723 16.4266 16.471 16.4264C16.4683 16.4258 16.4631 16.4247 16.4555 16.4231C16.4405 16.4198 16.4159 16.4144 16.3827 16.4065C16.3163 16.3907 16.2154 16.3652 16.0861 16.3281C15.827 16.2536 15.4561 16.133 15.0215 15.9511C14.1485 15.5856 13.0408 14.9819 12.0639 14.0276L11.0157 15.1006C12.1668 16.2251 13.4531 16.9206 14.4422 17.3347C14.9386 17.5425 15.3656 17.6818 15.6718 17.7697C15.8251 17.8138 15.9486 17.8451 16.036 17.8659C16.0797 17.8763 16.1144 17.884 16.1393 17.8894C16.1518 17.8921 16.1618 17.8942 16.1693 17.8957C16.173 17.8965 16.1761 17.8971 16.1786 17.8976C16.1798 17.8978 16.1809 17.898 16.1818 17.8982C16.1822 17.8983 16.1826 17.8984 16.183 17.8985C16.1832 17.8985 16.1834 17.8986 16.1835 17.8986C16.1838 17.8986 16.184 17.8987 16.3278 17.1626ZM12.0639 14.0276C11.0876 13.0738 10.4712 11.9938 10.0986 11.1445C9.91303 10.7215 9.7901 10.3606 9.71435 10.109C9.67652 9.98336 9.6506 9.88544 9.63461 9.82122C9.62662 9.78913 9.62112 9.7655 9.61786 9.75108C9.61623 9.74387 9.61516 9.73897 9.61462 9.73648C9.61436 9.73523 9.61422 9.73458 9.61421 9.73455C9.61421 9.73453 9.61424 9.73466 9.6143 9.73496C9.61433 9.7351 9.61437 9.73528 9.61441 9.73551C9.61444 9.73562 9.61448 9.73582 9.61449 9.73587C9.61453 9.73608 9.61457 9.73629 8.87981 9.88672C8.14506 10.0371 8.1451 10.0374 8.14515 10.0376C8.14517 10.0377 8.14523 10.038 8.14527 10.0382C8.14534 10.0386 8.14543 10.039 8.14553 10.0394C8.14572 10.0404 8.14594 10.0414 8.1462 10.0427C8.14672 10.0452 8.14738 10.0483 8.14819 10.052C8.14979 10.0595 8.15197 10.0694 8.15476 10.0817C8.16033 10.1064 8.16834 10.1406 8.17905 10.1837C8.20047 10.2697 8.23274 10.391 8.27803 10.5414C8.36853 10.842 8.5116 11.2607 8.725 11.7471C9.15042 12.7169 9.86404 13.9755 11.0157 15.1006L12.0639 14.0276ZM9.20898 10.5606L9.58565 10.3766L8.92732 9.02883L8.55065 9.21281L9.20898 10.5606ZM10.9747 6.78714L10.109 4.67284L8.72082 5.24123L9.58655 7.35553L10.9747 6.78714ZM21.6471 15.9413L19.4828 15.0956L18.9368 16.4927L21.1012 17.3384L21.6471 15.9413ZM15.8485 16.4529L15.6602 16.8209L16.9954 17.5043L17.1838 17.1363L15.8485 16.4529ZM19.4828 15.0956C18.1053 14.5574 16.5232 15.1348 15.8485 16.4529L17.1838 17.1363C17.499 16.5204 18.2591 16.2279 18.9368 16.4927L19.4828 15.0956ZM9.58565 10.3766C10.9216 9.72411 11.5392 8.16577 10.9747 6.78714L9.58655 7.35553C9.84412 7.98458 9.57119 8.71434 8.92732 9.02883L9.58565 10.3766ZM7.43909 4.40027C8.01294 4.40027 8.51608 4.74122 8.72082 5.24123L10.109 4.67284C9.66736 3.59437 8.60553 2.90027 7.43909 2.90027V4.40027ZM23.4618 18.57C23.4618 17.4028 22.7349 16.3664 21.6471 15.9413L21.1012 17.3384C21.6292 17.5448 21.9618 18.0372 21.9618 18.57H23.4618ZM20.5838 21.6096C11.5793 21.6096 4.30981 14.4832 4.30981 5.72909H2.80981C2.80981 15.3445 10.7841 23.1096 20.5838 23.1096V21.6096ZM20.5838 23.1096C22.1567 23.1096 23.4618 21.8596 23.4618 20.2808H21.9618C21.9618 20.9983 21.3615 21.6096 20.5838 21.6096V23.1096ZM4.30981 5.72909C4.30981 5.01164 4.91014 4.40027 5.68781 4.40027V2.90027C4.11497 2.90027 2.80981 4.15034 2.80981 5.72909H4.30981ZM19.2058 11.9655C19.2058 11.3186 19.0754 10.6784 18.8223 10.0817L17.4414 10.6673C17.6161 11.0794 17.7058 11.5205 17.7058 11.9655H19.2058ZM18.8223 10.0817C18.5693 9.48503 18.199 8.94404 17.7334 8.48915L16.6852 9.56214C17.0099 9.87939 17.2666 10.2551 17.4414 10.6673L18.8223 10.0817ZM17.7334 8.48915C17.2677 8.0343 16.7159 7.67439 16.1098 7.42915L15.5472 8.81962C15.9738 8.99226 16.3604 9.24485 16.6852 9.56214L17.7334 8.48915ZM16.1098 7.42915C15.5038 7.18391 14.8548 7.0579 14.1998 7.0579V8.5579C14.6626 8.5579 15.1205 8.64698 15.5472 8.81962L16.1098 7.42915ZM23.4618 11.9655C23.4618 10.7726 23.2213 9.59178 22.7544 8.49064L21.3734 9.0762C21.762 9.99278 21.9618 10.9745 21.9618 11.9655H23.4618ZM22.7544 8.49064C22.2875 7.38955 21.6037 6.39022 20.7428 5.54926L19.6946 6.62225C20.4146 7.32557 20.9847 8.15959 21.3734 9.0762L22.7544 8.49064ZM20.7428 5.54926C19.882 4.70833 18.861 4.04218 17.7385 3.58799L17.1759 4.97847C18.1189 5.36005 18.9746 5.91889 19.6946 6.62225L20.7428 5.54926ZM17.7385 3.58799C16.6161 3.13382 15.4137 2.90027 14.1998 2.90027V4.40027C15.2215 4.40027 16.2329 4.59688 17.1759 4.97847L17.7385 3.58799Z"
      fill="#989E9C"
    />
  </Svg>
);

export const VideoCall = () => (
  <Svg width="22" height="14" viewBox="0 0 22 14" fill="none">
    <Path
      fillRule="evenodd"
      clipRule="evenodd"
      d="M11.8929 12.9815H3.51387C2.19132 12.9815 1.11987 11.9348 1.11987 10.6429V3.36699C1.11987 2.075 2.19132 1.02832 3.51387 1.02832H11.8929C13.2154 1.02832 14.2869 2.075 14.2869 3.36699V10.6429C14.2869 11.9348 13.2154 12.9815 11.8929 12.9815Z"
      stroke="#989E9C"
      strokeWidth="1.5"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M14.2869 8.14511L18.3247 11.3195C19.1078 11.9358 20.2719 11.3912 20.2719 10.4089V3.60081C20.2719 2.61857 19.1078 2.07392 18.3247 2.69029L14.2869 5.86465"
      stroke="#989E9C"
      strokeWidth="1.5"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Search = () => (
  <Svg width="21" height="20" viewBox="0 0 21 20" fill="none">
    <Path
      d="M19.7309 18.3126L16.0209 14.6326C17.461 12.837 18.1584 10.5579 17.9697 8.26391C17.781 5.96991 16.7206 3.83539 15.0064 2.29925C13.2923 0.763116 11.0547 -0.0578805 8.75382 0.00507995C6.45294 0.0680404 4.26362 1.01017 2.63604 2.63775C1.00846 4.26533 0.0663314 6.45465 0.00337096 8.75553C-0.0595894 11.0564 0.761407 13.294 2.29754 15.0081C3.83368 16.7223 5.9682 17.7827 8.2622 17.9714C10.5562 18.1601 12.8353 17.4627 14.6309 16.0226L18.3109 19.7026C18.4039 19.7963 18.5145 19.8707 18.6363 19.9215C18.7582 19.9723 18.8889 19.9984 19.0209 19.9984C19.1529 19.9984 19.2836 19.9723 19.4055 19.9215C19.5273 19.8707 19.6379 19.7963 19.7309 19.7026C19.9111 19.5161 20.0119 19.2669 20.0119 19.0076C20.0119 18.7483 19.9111 18.4991 19.7309 18.3126ZM9.0209 16.0226C7.63643 16.0226 6.28305 15.6121 5.13191 14.8429C3.98076 14.0737 3.08356 12.9805 2.55374 11.7014C2.02393 10.4223 1.88531 9.01484 2.1554 7.65698C2.4255 6.29911 3.09219 5.05183 4.07115 4.07286C5.05012 3.09389 6.2974 2.42721 7.65527 2.15711C9.01314 1.88702 10.4206 2.02564 11.6997 2.55545C12.9788 3.08527 14.072 3.98247 14.8412 5.13362C15.6104 6.28476 16.0209 7.63814 16.0209 9.02261C16.0209 10.8791 15.2834 12.6596 13.9706 13.9724C12.6579 15.2851 10.8774 16.0226 9.0209 16.0226Z"
      fill="#FAFEFF"
    />
  </Svg>
);

export const Close = (color: any) => (
  <Svg width="36 " height="36" viewBox="0 0 24 24" fill="none">
    <Path
      fillRule="evenodd"
      clipRule="evenodd"
      d="M5.29289 5.29289C5.68342 4.90237 6.31658 4.90237 6.70711 5.29289L12 10.5858L17.2929 5.29289C17.6834 4.90237 18.3166 4.90237 18.7071 5.29289C19.0976 5.68342 19.0976 6.31658 18.7071 6.70711L13.4142 12L18.7071 17.2929C19.0976 17.6834 19.0976 18.3166 18.7071 18.7071C18.3166 19.0976 17.6834 19.0976 17.2929 18.7071L12 13.4142L6.70711 18.7071C6.31658 19.0976 5.68342 19.0976 5.29289 18.7071C4.90237 18.3166 4.90237 17.6834 5.29289 17.2929L10.5858 12L5.29289 6.70711C4.90237 6.31658 4.90237 5.68342 5.29289 5.29289Z"
      fill="#0F1729"
    />
  </Svg>
);

export const CloseWhite = (color: any) => (
  <Svg width="34" height="34" viewBox="0 0 24 24" fill="none">
    <Path
      fillRule="evenodd"
      clipRule="evenodd"
      d="M5.29289 5.29289C5.68342 4.90237 6.31658 4.90237 6.70711 5.29289L12 10.5858L17.2929 5.29289C17.6834 4.90237 18.3166 4.90237 18.7071 5.29289C19.0976 5.68342 19.0976 6.31658 18.7071 6.70711L13.4142 12L18.7071 17.2929C19.0976 17.6834 19.0976 18.3166 18.7071 18.7071C18.3166 19.0976 17.6834 19.0976 17.2929 18.7071L12 13.4142L6.70711 18.7071C6.31658 19.0976 5.68342 19.0976 5.29289 18.7071C4.90237 18.3166 4.90237 17.6834 5.29289 17.2929L10.5858 12L5.29289 6.70711C4.90237 6.31658 4.90237 5.68342 5.29289 5.29289Z"
      fill="white"
    />
  </Svg>
);

export const UpdatePhoto = () => (
  <Svg width="78" height="67" viewBox="0 0 78 67" fill="none">
    <Path
      d="M66.2383 10.103C62.6843 6.94225 58.4331 4.42113 53.7327 2.68674C49.0323 0.952354 43.9769 0.0394331 38.8613 0.0012495C33.7458 -0.0369341 28.6727 0.800384 23.9379 2.46435C19.2031 4.12831 14.9015 6.58559 11.2842 9.69282C7.66681 12.8 4.80609 16.495 2.86894 20.562C0.93179 24.6291 -0.042998 28.9868 0.00145464 33.3809C0.0459072 37.775 1.10871 42.1175 3.12785 46.155C5.14699 50.1926 8.08203 53.8442 11.7617 56.897C15.3157 60.0577 19.5669 62.5789 24.2673 64.3133C28.9677 66.0476 34.0231 66.9606 39.1386 66.9988C44.2542 67.0369 49.3273 66.1996 54.0621 64.5357C58.7969 62.8717 63.0985 60.4144 66.7158 57.3072C70.3332 54.2 73.1939 50.505 75.1311 46.438C77.0682 42.3709 78.043 38.0132 77.9985 33.6191C77.9541 29.225 76.8913 24.8825 74.8721 20.845C72.853 16.8074 69.918 13.1558 66.2383 10.103ZM63.0021 16.9533H41.928L50.9818 9.17639C55.6639 10.8923 59.7895 13.5614 63.0021 16.9533ZM27.442 9.01093C32.1697 7.38553 37.2867 6.77222 42.3518 7.22389L27.442 20.031V9.01093ZM19.7367 12.8828V30.9849L12.7634 24.995L10.683 23.208C12.6806 19.1861 15.7879 15.6424 19.7367 12.8828ZM10.4903 43.428C8.59355 39.3681 7.8794 34.9717 8.4099 30.6209L23.3197 43.428H10.4903ZM14.9979 50.0467H36.072L27.0182 57.8236C22.336 56.1077 18.2105 53.4386 14.9979 50.0467ZM50.558 57.9891C45.8311 59.6171 40.7133 60.2305 35.6482 59.7761L50.558 46.969V57.9891ZM50.558 37.6036L43.7773 43.428H34.1842L27.442 37.6036V29.3964L34.2227 23.572H43.7773L50.558 29.3964V37.6036ZM58.2633 54.1502V36.0151L67.317 43.792C65.3194 47.8139 62.212 51.3576 58.2633 54.1171V54.1502ZM54.6803 23.572H67.5097C69.4049 27.6323 70.119 32.0283 69.5901 36.3791L54.6803 23.572Z"
      fill="white"
    />
  </Svg>
);

export const SendMess = () => (
  <Svg width="78" height="67" viewBox="0 0 68 56" fill="none">
    <Path
      d="M50.6668 14.25H17.3334C16.4494 14.25 15.6015 14.5397 14.9764 15.0555C14.3513 15.5712 14.0001 16.2707 14.0001 17C14.0001 17.7293 14.3513 18.4288 14.9764 18.9445C15.6015 19.4603 16.4494 19.75 17.3334 19.75H50.6668C51.5508 19.75 52.3987 19.4603 53.0238 18.9445C53.6489 18.4288 54.0001 17.7293 54.0001 17C54.0001 16.2707 53.6489 15.5712 53.0238 15.0555C52.3987 14.5397 51.5508 14.25 50.6668 14.25ZM50.6668 25.25H17.3334C16.4494 25.25 15.6015 25.5397 14.9764 26.0555C14.3513 26.5712 14.0001 27.2707 14.0001 28C14.0001 28.7293 14.3513 29.4288 14.9764 29.9445C15.6015 30.4603 16.4494 30.75 17.3334 30.75H50.6668C51.5508 30.75 52.3987 30.4603 53.0238 29.9445C53.6489 29.4288 54.0001 28.7293 54.0001 28C54.0001 27.2707 53.6489 26.5712 53.0238 26.0555C52.3987 25.5397 51.5508 25.25 50.6668 25.25ZM57.3334 0.5H10.6667C8.01458 0.5 5.47104 1.36919 3.59568 2.91637C1.72032 4.46354 0.666748 6.56196 0.666748 8.75V36.25C0.666748 38.438 1.72032 40.5365 3.59568 42.0836C5.47104 43.6308 8.01458 44.5 10.6667 44.5H49.3001L61.6334 54.7025C61.9449 54.9574 62.3143 55.159 62.7204 55.2959C63.1265 55.4327 63.5614 55.5021 64.0001 55.5C64.4373 55.5093 64.8712 55.4339 65.2667 55.28C65.8755 55.0737 66.3966 54.7234 66.7643 54.2731C67.1321 53.8229 67.3301 53.2929 67.3334 52.75V8.75C67.3334 6.56196 66.2799 4.46354 64.4045 2.91637C62.5291 1.36919 59.9856 0.5 57.3334 0.5ZM60.6668 46.1225L53.0334 39.7975C52.7219 39.5426 52.3526 39.341 51.9464 39.2041C51.5403 39.0673 51.1054 38.9979 50.6668 39H10.6667C9.78269 39 8.93485 38.7103 8.30973 38.1945C7.68461 37.6788 7.33342 36.9793 7.33342 36.25V8.75C7.33342 8.02065 7.68461 7.32118 8.30973 6.80546C8.93485 6.28973 9.78269 6 10.6667 6H57.3334C58.2175 6 59.0653 6.28973 59.6904 6.80546C60.3156 7.32118 60.6668 8.02065 60.6668 8.75V46.1225Z"
      fill="white"
    />
  </Svg>
);

export const RetakePhoto = () => (
  <Svg width="28" height="26" viewBox="0 0 20 18" fill="none">
    <Path
      d="M18 2H14.83L13 0L7 0L5.17 2L2 2C1.46957 2 0.960859 2.21071 0.585786 2.58579C0.210714 2.96086 0 3.46957 0 4L0 16C0 16.5304 0.210714 17.0391 0.585786 17.4142C0.960859 17.7893 1.46957 18 2 18H18C18.5304 18 19.0391 17.7893 19.4142 17.4142C19.7893 17.0391 20 16.5304 20 16V4C20 3.46957 19.7893 2.96086 19.4142 2.58579C19.0391 2.21071 18.5304 2 18 2ZM18 16L2 16L2 4L6.05 4L7.88 2L12.12 2L14 4H18V16ZM10 15C8.92 15 7.86 14.65 7 14L8.44 12.56C8.91 12.85 9.45 13 10 13C10.7956 13 11.5587 12.6839 12.1213 12.1213C12.6839 11.5587 13 10.7956 13 10C13 9.20435 12.6839 8.44129 12.1213 7.87868C11.5587 7.31607 10.7956 7 10 7C8.74 7 7.6 7.8 7.18 9H9L6 12L3 9H5.1C5.23084 8.35627 5.48731 7.74466 5.85475 7.20015C6.22219 6.65564 6.69338 6.18892 7.24137 5.82669C7.78936 5.46446 8.40339 5.21382 9.04834 5.08913C9.69328 4.96444 10.3565 4.96813 11 5.1C12.2152 5.34674 13.2953 6.0362 14.0307 7.03453C14.7661 8.03285 15.1043 9.26882 14.9797 10.5025C14.8551 11.7362 14.2765 12.8795 13.3563 13.7106C12.4361 14.5417 11.24 15.0012 10 15Z"
      fill="white"
    />
  </Svg>
);

export const Send = () => (
  <Svg width="28" height="26" viewBox="0 0 22 22" fill="none">
    <Path
      d="M9.91337 12.0852C9.72226 11.8945 9.49449 11.7444 9.24381 11.644L1.31381 8.464C1.21912 8.42601 1.13833 8.35996 1.08226 8.27473C1.0262 8.18949 0.997552 8.08914 1.00016 7.98716C1.00278 7.88517 1.03652 7.78642 1.09688 7.70417C1.15723 7.62192 1.2413 7.56009 1.33781 7.527L20.3378 1.027C20.4264 0.994995 20.5223 0.988887 20.6143 1.00939C20.7062 1.02989 20.7904 1.07616 20.857 1.14278C20.9236 1.20939 20.9699 1.2936 20.9904 1.38555C21.0109 1.4775 21.0048 1.57339 20.9728 1.662L14.4728 20.662C14.4397 20.7585 14.3779 20.8426 14.2956 20.9029C14.2134 20.9633 14.1146 20.997 14.0126 20.9996C13.9107 21.0023 13.8103 20.9736 13.7251 20.9175C13.6398 20.8615 13.5738 20.7807 13.5358 20.686L10.3558 12.754C10.255 12.5035 10.1045 12.276 9.91337 12.0852ZM9.91337 12.0852L20.8538 1.147"
      stroke="#F2F2F2"
      strokeWidth="2"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Capture = () => (
  <Svg width="70" height="70" viewBox="0 0 70 70" fill="none">
    <Circle cx="34.9999" cy="35.0002" r="29.6154" fill="white" />
    <Circle cx="35" cy="35" r="33.5" stroke="white" strokeWidth="3" />
  </Svg>
);

export const FlipCamera = () => (
  <Svg width="48" height="48" viewBox="0 0 48 48" fill="none">
    <Circle cx="24" cy="24" r="24" fill="#C4C4C4" fillOpacity="0.2" />
    <G clipPath="url(#clip0_67_2661)">
      <Path
        d="M11.0073 13.0889C10.9426 12.5552 11.3145 12.0702 11.8481 12.0055C12.3818 11.9408 12.8668 12.3127 12.9315 12.8463L13.5137 17.3578C15.7128 14.0914 19.4319 12.0701 23.4421 12.0701C28.5519 12.0701 33.0957 15.3203 34.7612 20.139C34.9391 20.6403 34.6642 21.1901 34.1629 21.3679C34.0659 21.4003 33.9527 21.4164 33.8395 21.4164C33.4353 21.4164 33.0633 21.1577 32.9178 20.7696C31.5272 16.7271 27.7111 14.0105 23.4422 14.0105C19.9494 14.0105 16.6992 15.8539 14.8882 18.7969L19.7392 18.2471C20.2728 18.1824 20.7579 18.5705 20.8064 19.1041C20.8549 19.6378 20.483 20.1228 19.9494 20.1714L12.9639 20.9637C12.9315 20.9637 12.883 20.9637 12.8507 20.9637C12.3656 20.9637 11.9451 20.608 11.8966 20.1229L11.0073 13.0889ZM35.0361 26.0734L28.0506 26.8658C27.5169 26.9305 27.1289 27.3994 27.1935 27.933C27.2582 28.4667 27.7271 28.8547 28.2608 28.7901L32.4812 28.3211C30.8318 31.7977 27.3229 34.0453 23.4259 34.0453C19.0438 34.0453 15.0983 31.1186 13.837 26.9305C13.6753 26.4131 13.1417 26.122 12.6243 26.2837C12.1069 26.4453 11.8158 26.979 11.9774 27.4964C12.7051 29.9058 14.2251 32.0726 16.2302 33.5925C18.3161 35.161 20.8063 36.0019 23.4259 36.0019C28.2123 36.0019 32.4974 33.156 34.3892 28.8385L35.0684 34.2231C35.1331 34.7083 35.5535 35.064 36.0224 35.064C36.0709 35.064 36.1033 35.064 36.1518 35.064C36.6854 34.9993 37.0573 34.5142 36.9926 33.9806L36.0871 26.9466C36.0386 26.3969 35.5697 26.0249 35.0361 26.0734Z"
        fill="white"
      />
    </G>
    <Defs>
      <ClipPath id="clip0_67_2661">
        <Rect
          width="26"
          height="26"
          fill="white"
          transform="matrix(1 0 0 -1 11 37)"
        />
      </ClipPath>
    </Defs>
  </Svg>
);

export const FlashOn = () => (
  <Svg width="32" height="32" viewBox="0 0 32 32" fill="none">
    <Path
      d="M12.24 24.0534V27.3067C12.24 29.5467 13.4533 30.0001 14.9333 28.3201L25.0267 16.8534C26.2667 15.4534 25.7467 14.2934 23.8667 14.2934H22.6267"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M13.3067 7.94666L6.95999 15.16C5.71999 16.56 6.23999 17.72 8.11999 17.72H12.24V19.2933"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M19.76 11.7866V4.6933C19.76 2.4533 18.5466 1.99996 17.0667 3.67996"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M29.3334 2.66669L2.66675 29.3334"
      stroke="white"
      strokeWidth="1.5"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const FlashOff = () => (
  <Svg width="32" height="32" viewBox="0 0 32 32" fill="none">
    <Path
      d="M12.24 24.0534V27.3067C12.24 29.5467 13.4533 30.0001 14.9333 28.3201L25.0267 16.8534C26.2667 15.4534 25.7467 14.2934 23.8667 14.2934H22.6267"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M13.3067 7.94666L6.95999 15.16C5.71999 16.56 6.23999 17.72 8.11999 17.72H12.24V19.2933"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <Path
      d="M19.76 11.7866V4.6933C19.76 2.4533 18.5466 1.99996 17.0667 3.67996"
      stroke="white"
      strokeWidth="1.5"
      strokeMiterlimit="10"
      strokeLinecap="round"
      strokeLinejoin="round"
    />
  </Svg>
);

export const Background = () => (
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

export const Icons = {
  Incoming,
  Outgoing,
  Missed,
  VideoCall,
  Call,
  Search,
  Close,
  UpdatePhoto,
  SendMess,
  FlashOff,
  FlashOn,
  CloseWhite,
  FlipCamera,
  Capture,
  RetakePhoto,
  Send
};
