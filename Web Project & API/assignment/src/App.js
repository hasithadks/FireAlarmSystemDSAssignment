import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch , Route } from 'react-router-dom';

import Information from "./components/InformationView";

function App() {
  return (
    <div className="App">

      <header style={{marginTop:'2%'}}>
        <hr/>
        <h2>Web Application</h2>
        <hr/>
      </header>



        <Router>
            <Switch>
                <Route path="/info">


                    <Route path="/info" exact component={Information}/>
                </Route>
            </Switch>
        </Router>

    </div>
  );
}

export default App;
