import React, {Component} from "react";
import { ThemeProvider } from "styled-components";
import GlobasStyles from "../Styles/GlobasStyles";
import Theme from "../Styles/Theme";
import AppRouter from "./Router";
import firebase from "firebase"
import firebaseConfig from "../Firebase/firebase.config"

firebase.initializeApp(firebaseConfig)

// firebase.auth().signInWithEmailAndPassword("jss8882@naver.com", "wkdtkdtn100")
//         .then((user) =>{
//           console.log(user)
//         })
//         .catch(function(error) {
//       // Handle Errors here.
//       var errorCode = error.code;
//       var errorMessage = error.message;
//       if (errorCode === 'auth/wrong-password') {
//         alert('Wrong password.');
//       } else {
//         alert(errorMessage);
//       }
//       console.log(error);
//     });

export default () => (
  <ThemeProvider theme={Theme}>
    <>
      <GlobasStyles/>
      <AppRouter isLoggedIn={true}/>
    </>
  </ThemeProvider>
)