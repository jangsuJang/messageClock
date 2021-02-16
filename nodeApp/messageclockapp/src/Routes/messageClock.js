import { authService, fbDatabase } from "Firebase/firebaseAuth";
import React, {useRef,useContext,createContext ,useState, useEffect} from "react";
import P5Wrapper from "react-p5-wrapper";

// const messageClock = ()=> "messageClock"

export const messageClockContext = createContext()

const onLogOutClick = () => authService.signOut()

const MessageClock = ({userObj}) => {
    const [alarms, setAlarms] = useState([]);
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

    useEffect(()=>{
        // getAlarms();
        fbDatabase.collection("alarms").onSnapshot((snapshop)=>{
            const alarmsArray = snapshop.docs.map((doc)=>({
                id : doc.id,
                ...doc.data()
            }));
            setAlarms(alarmsArray);
        });

    },[]);
    // console.log(alarms);

    const Sketch = (p) =>{

        let rotation = 0;

        p.setup = function () {
            p.createCanvas(800, 800, p.WEBGL);
        };

        p.myCustomRedrawAccordingToNewPropsHandler = function (props) {
            if (props.rotation !== null){
            rotation = props.rotation * Math.PI / 180;
            }
        };

        p.draw = function () {
            p.background(255,255,0);
            // printAlarm(alarms)
            // p.normalMaterial();
            // p.noStroke();
            // p.push();
            // p.rotateY(rotation);
            // p.box(100);
            // p.pop();
        };

        const printAlarm = (alarmsList)  =>{
            console.log(...alarmsList)

        }

        //리스트에 있는 알람 시간과 현재시간을 비교 
        //지금보여주어야하는 알람 선택
        //지금 보여주어야하는 알람 표시
        //몇시에 보여질 알람이 있다는것 보여주기
        //두개이상의 알람이겹치면?

    };

    // const canvasRef = useRef<HTMLCanvasElement>(null);
    return (
        <messageClockContext.Provider value={alarms}>
            <div className="clockCanvas">
                "messageClock",
                <P5Wrapper sketch={Sketch}/>
            </div>
        </messageClockContext.Provider>
    )

}

export default MessageClock