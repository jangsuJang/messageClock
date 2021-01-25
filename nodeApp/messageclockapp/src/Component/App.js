import React,{useState,Component} from "react";
import { ThemeProvider } from "styled-components";
import GlobasStyles from "../Styles/GlobasStyles";
import Theme from "../Styles/Theme";
import AppRouter from "./Router";
import firebaseAuth, { authService } from "../Firebase/firebaseAuth"

// firebase.initializeApp(firebaseConfig)
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(authService.currentUser);
  return (
    <ThemeProvider theme={Theme}>
      <>
        <GlobasStyles/>
        <AppRouter isLoggedIn={isLoggedIn}/>
        <footer>&copy; messageClock {new Date().getFullYear()}</footer>
      </>
    </ThemeProvider>
  )
}


export default App;
