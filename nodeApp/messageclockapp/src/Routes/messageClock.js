import { authService, fbDatabase } from "Firebase/firebaseAuth";
import React, {useState, useEffect} from "react"

// const messageClock = ()=> "messageClock"

const onLogOutClick = () => authService.signOut()

const MessageClock = () => {
    const [alarms, setAlarms] = useState([]);

    const getAlarms = async () =>{
        var userID = authService.currentUser.uid;
        // console.log(fbDatabase.ref('/alarms/'))

//         var userId = firebase.auth().currentUser.uid;
// return firebase.database().ref('/users/' + userId).once('value').then((snapshot) => {
//   var username = (snapshot.val() && snapshot.val().username) || 'Anonymous';
//   // ...
// });

    }
    useEffect(()=>{
        getAlarms();

    },[]);

    return (

        "messageClock"
    )
}

export default MessageClock