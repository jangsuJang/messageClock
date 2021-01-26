import { authService } from "Firebase/firebaseAuth";
import React,{useState} from "react";

const Auth = () => {
    const [email,setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [newAccount, setNewAccount] = useState(false);
    const [error,setError] = useState("")
    const onChange = (event) =>{
        console.log(event.target.name);
        const {target: {name, value}} = event;
        if(name==="email"){
            setEmail(value);
            console.log(email)
        }else if(name === "password"){
            setPassword(value);

        }
    };
    const onSubmit = async (event) =>{
        event.preventDefault()
        try{
            let data;
            if (newAccount){
                data = await authService.createUserWithEmailAndPassword(
                    email, password
                );
            }else{
                data= await authService.signInWithEmailAndPassword(
                    email,password
                );
            }
            console.log(data);
        }
        catch (error){
            setError(error.message)
        }
    }
    const toggleAccount = () => setNewAccount((prev)=> !prev);
    return (
        <div>
            <form onSubmit={onSubmit}>
                <input name="email" type="text" placeholder="email" onChange={onChange} required/>
                <input name="password" type="password" placeholder="password"onChange={onChange}  required/>
                <input type="submit" value={newAccount ? "Create Account" : "Log In"}/>
                {error}
            </form>
            <span onClick={toggleAccount}>{newAccount ? "Log In": "Create Account"}</span>
            <div>
                <button>Continue with Google</button>
                <button>Continue with Github</button>
            </div>
        </div>
    )
}

export default Auth