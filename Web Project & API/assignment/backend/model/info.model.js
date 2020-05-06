const mongoose = require('mongoose');
const  Schema = mongoose.Schema;

const infoSchema = new Schema({
    activity:{type:String,required:true},
    co2Level:{type: Number,required: true},
    smokeLevel:{type: Number,required: true},
    floorNo:{type: Number,required: true},
    roomNo:{type: Number,required: true},
},{
    timeStamp:true,
});

const Info = mongoose.model('Info', infoSchema);

module.exports=Info;