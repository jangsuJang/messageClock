import { authService, fbDatabase } from "Firebase/firebaseAuth";
import React, {useRef, useState, useEffect} from "react"
import { useCanvas } from "./CanvasContext";

// const messageClock = ()=> "messageClock"

const onLogOutClick = () => authService.signOut()

const MessageClock = ({userObj}) => {
    const [alarms, setAlarms] = useState([]);
    const canvasRef = useRef(null)
    // //비실시간방식 
    // const getAlarms = async () =>{
    //     // console.log(userObj);
    //     var userID = authService.currentUser.uid;
    //     const dbAlarms = await fbDatabase.collection("alarms").get();
    //     dbAlarms.forEach((myDocument)=>{
    //         const alarmsObject = {
    //             ...myDocument.data(),
    //             id: myDocument.id
    //         };
    //         setAlarms((prev) =>[alarmsObject, ...prev]);
    //     })
    // }
    const drawClock = (ctx) =>{
        ctx.beginPath()
        ctx.fillStyle = '#000000'
        ctx.arc(50, 100, 20, 0, 2*Math.PI)
        ctx.fill()

    }

    useEffect(()=>{
        // getAlarms();
        fbDatabase.collection("alarms").onSnapshot((snapshop)=>{
            const alarmsArray = snapshop.docs.map((doc)=>({
                id : doc.id,
                ...doc.data()
            }));
            setAlarms(alarmsArray);
        });

        const canvas = canvasRef.current
        const context = canvas.getContext('2d')
        drawClock(context)
    },[]);
    console.log(alarms);

    // const canvasRef = useRef<HTMLCanvasElement>(null);
    return (

        <div className="clockCanvas">
            "messageClock",
            <canvas ref={canvasRef} height={5000} width={5000} className="canvas"/>
        </div>
    )

}

export default MessageClock