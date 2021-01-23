import React from "react";
import PropTypes from "prop-types"
import {HashRouter as Router, Route, Switch} from "react-router-dom";
import Auth from "../Routes/Auth";
import messageClock from "../Routes/messageClock";


const LoggedInRoutes = () => <><Route exact path="/" component={messageClock}/></>;
const LoggedOutRoutes = () => <><Route exact path="/" component={Auth}/></>;


const AppRouter = ({isLoggedIn}) => (
    <Router>
        <Switch>{isLoggedIn ? <LoggedInRoutes/> : <LoggedOutRoutes/>}
        </Switch>
    </Router>
);

Router.propTypes = {
    isLoggedIn : PropTypes.bool.isRequired
};

export default AppRouter