interface CallItemProps {
    id: string;
    name: string;
    avatar: string;
    time: string;
    callType: 'incoming' | 'outgoing' | 'missed';
    videoCall: boolean;
  }
  
  const callsData: CallItemProps[] = [
    {
      id: '1',
      name: 'Jhon Abraham',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?size=626&ext=jpg',
      time: 'Today, 07:30 AM',
      callType: 'incoming',
      videoCall: true,
    },
    {
      id: '2',
      name: 'Sabila Sayma',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-business-man-with-glasses_23-2149436194.jpg?size=626&ext=jpg',
      time: 'Yesterday, 07:35 PM',
      callType: 'missed',
      videoCall: false,
    },
    {
      id: '3',
      name: 'Alex Linderson',
      avatar: 'https://img.freepik.com/free-psd/3d-rendering-avatar_23-2150833554.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'outgoing',
      videoCall: true,
    },
    {
      id: '4',
      name: 'Jhon Abraham',
      avatar: 'https://img.freepik.com/premium-vector/flat-vector-illustration-animator_1033579-62857.jpg?size=626&ext=jpg',
      time: '03/07/22, 07:30 AM',
      callType: 'outgoing',
      videoCall: false,
    },
    {
      id: '5',
      name: 'John Borino',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436191.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'incoming',
      videoCall: true,
    },
    {
      id: '6',
      name: 'John Borino',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436191.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'incoming',
      videoCall: true,
    },{
      id: '7',
      name: 'John Borino',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436191.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'incoming',
      videoCall: true,
    },{
      id: '8',
      name: 'John Borino',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436191.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'incoming',
      videoCall: true,
    },
    {
      id: '9',
      name: 'John Borino',
      avatar: 'https://img.freepik.com/free-psd/3d-illustration-person-with-glasses_23-2149436191.jpg?size=626&ext=jpg',
      time: 'Monday, 09:30 AM',
      callType: 'incoming',
      videoCall: true,
    },
  ];
  
  export default callsData;
  