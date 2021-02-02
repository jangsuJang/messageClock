import React from "react";
import PropTypes from "prop-types"
import {HashRouter as Router, Route, Switch} from "react-router-dom";
import Auth from "../Routes/Auth";
import MessageClock from "../Routes/MessageClock";


// const LoggedInRoutes = () => <><Route exact path="/" render={()=><MessageClock userObj={userObj}/>} /></>
const LoggedOutRoutes = () => <><Route exact path="/" component={Auth}/></>;

// <Route
//   path='/education'
//   render={() => <Education education={data} />}/>


const AppRouter = ({isLoggedIn,userObj}) => (
    <Router>
        <Switch>
            {isLoggedIn ? (
                <>
                <Route exact path="/" render={()=> <MessageClock userObj={userObj}/>} />
                </>
            ): <LoggedOutRoutes/> }
        </Switch>
    </Router>
);
// {isLoggedIn ? <LoggedInRoutes/> : <LoggedOutRoutes/>}
/* <Switch>{isLoggedIn ?(
    <>
        <Route exact path="/">
            <MessageClock userObj={userObj}/>
        </Route>
    </>
): 
    LoggedOutRoutes
 }
</Switch> */
Router.propTypes = {
    isLoggedIn : PropTypes.bool.isRequired
};

export default AppRouter
