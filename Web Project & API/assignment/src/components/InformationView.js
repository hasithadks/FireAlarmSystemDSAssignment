import React, { Component } from 'react'
import axios from 'axios';


const  Info = props =>(
    <div>
        {props.info.smokeLevel > 5 || props.info.co2Level > 5
            ? ( <div>
                    <br/>
                    <div className="card" style={{padding:"12px", backgroundColor: "#a52b2a",  color: "white" ,width:"50%",marginLeft:"25%",borderRadius:"15px"}}>
                        <br/>
                        <h5><b>Active : </b>{props.info.activity}</h5>
                        <br/>
                        <h5 className="text-warning"><b>Co2 Level : </b>{props.info.co2Level}</h5>
                        <br/>
                        <h5 className="text-warning"><b>Smoke Level : </b>{props.info.smokeLevel}</h5>
                        <br/>
                        <h5><b>Floor No : </b>{props.info.floorNo}</h5>
                        <br/>
                        <h5><b>Room No    : </b>{props.info.roomNo}</h5>
                        <br/>
                    </div>
                </div>
            )
            :(<div>
                <br/>
                <div className="card" style={{padding:"12px", backgroundColor: "#008001",  color: "white", width:"50%",marginLeft:"25%",borderRadius:"15px"}}>
                    <h5><b>Active : </b>{props.info.activity}</h5>
                    <br/>
                    <h5 ><b>Co2 Level : </b>{props.info.co2Level}</h5>
                    <br/>
                    <h5 ><b>Smoke Level : </b>{props.info.smokeLevel}</h5>
                    <br/>
                    <h5><b>Floor No : </b>{props.info.floorNo}</h5>
                    <br/>
                    <h5><b>Room No    : </b>{props.info.roomNo}</h5>
                    <br/>
                </div>
            </div>)
        }

    </div>
);



export default class InformationView extends Component {
    constructor(props) {
        super(props);

        this.state ={
            infoArray: []};

        this.infoList = this.infoList.bind(this);

    }

    componentDidMount() {
        axios.get('http://localhost:5000/infos/')
            .then(response =>{
                this.setState({infoArray:response.data});
            })
            .catch((error) => {
                console.log(error);
            })
    }

    componentDidUpdate() {
        axios.get('http://localhost:5000/infos/')
            .then(response =>{
                this.setState({infoArray:response.data});
            })
            .catch((error) => {
                console.log(error);
            })
    }
    infoList(){
        return this.state.infoArray.map(function (currentinfo,i) {
            return <Info info = {currentinfo} key={i}/>
        });
    }

    render() {
        return (
            <div className="App">
                <br/>
                <div className="container">
                    <div>{this.infoList()}</div>
                </div>
            </div>
        )
    }
}
