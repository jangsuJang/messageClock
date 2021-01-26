import { authService } from "Firebase/firebaseAuth";
import React from "react";

const messageClock = ()=> "messageClock"

const onLogOutClick = () => authService.signOut()

export default messageClock