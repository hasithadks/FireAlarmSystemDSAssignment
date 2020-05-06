const express = require('express');
const  cors = require('cors');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');


require('dotenv').config();

const app = express();
const port = process.env.PORT || 5000;

app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: true }));

const uri = process.env.ATLAS_URI;
mongoose.connect(uri,{useNewUrlParser:true, useUnifiedTopology: true, useCreateIndex:true, useFindAndModify: false }
);
const connection= mongoose.connection;
connection.once('open', ()=>{
    console.log("MongoDB database connection established successfully");
});

const infosRouter = require('./routes/infos');
const sensorRouter = require('./routes/sensor');
app.use('/infos',infosRouter);
app.use('/sensor',sensorRouter);

app.listen(port, () => {
    console.log(`Server is running on port: ${port}`);
});
