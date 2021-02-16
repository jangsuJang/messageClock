
import {messageClockContext} from "./MessageClock"
import {useContext} from "react"

const Sketch = (p) =>{

  let rotation = 0;
  const alarmData =  useContext(messageClockContext)

  p.setup = function () {
    p.createCanvas(600, 400, p.WEBGL);
  };

  p.myCustomRedrawAccordingToNewPropsHandler = function (props) {
    if (props.rotation !== null){
      rotation = props.rotation * Math.PI / 180;
    }
  };

  p.draw = function () {
    console.log(alarmData)
    p.background(100);
    p.normalMaterial();
    p.noStroke();
    p.push();
    p.rotateY(rotation);
    p.box(100);
    p.pop();
  };
};

// P5Clock.propTypes = {
//     isLoggedIn : PropTypes.bool.isRequired
// };

export default Sketch;