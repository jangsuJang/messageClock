import firebase from "firebase/app"
import "firebase/auth"
import firebaseConfig from "../Firebase/firebase.config"

firebase.initializeApp(firebaseConfig)
firebase.database().ref('/alarms')

// firebase.auth().signInWithEmailAndPassword("jss8882@naver.com", "wkdtkdtn100")
//           .then((user) =>{
//             console.log(user)
//           })
//           .catch(function(error) {
//         // Handle Errors here.
//         var errorCode = error.code;
//         var errorMessage = error.message;
//         if (errorCode === 'auth/wrong-password') {
//           alert('Wrong password.');
//         } else {
//           alert(errorMessage);
//         }
//         console.log(error);
//       });

export const authService = firebase.auth();

// export const fbDatabase = firebase.database().ref('/alarms');


