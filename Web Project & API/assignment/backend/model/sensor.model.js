const mongoose = require('mongoose');
const  Schema = mongoose.Schema;

const sensorSchema = new Schema({
    status:{type:String,required:true},
    floorNo:{type: Number,required: true},
    roomNo:{type: Number,required: true},
});

const sensor = mongoose.model('sensor', sensorSchema);

module.exports=sensor;
