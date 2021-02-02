import React,{useState,Component, useEffect} from "react";
import { ThemeProvider } from "styled-components";
import GlobasStyles from "../Styles/GlobasStyles";
import Theme from "../Styles/Theme";
import AppRouter from "./Router";
import firebaseAuth, { authService } from "../Firebase/firebaseAuth"

// firebase.initializeApp(firebaseConfig)
function App() {
  const [init, setInit] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userObj, setUserObj] = useState(null)
  useEffect(()=>{
    authService.onAuthStateChanged((user) =>{
      if (user){
        setIsLoggedIn(true);
        setUserObj(user)
      } else {
        setIsLoggedIn(false);
      }
      setInit(true);
    })
  },[])
  // setInterval(()=>{
    
  // })
  return (
    <ThemeProvider theme={Theme}>
      <>
        <GlobasStyles/>
        {init ? <AppRouter isLoggedIn={isLoggedIn} userObj = {userObj}/> : "Initializing..."}
        <footer>&copy; messageClock {new Date().getFullYear()}</footer>
      </>
    </ThemeProvider>
  )
}


export default App;
