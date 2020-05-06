const router = require('express').Router();
let Info = require('../model/info.model');

let data=[];

router.route('/').get((req,res) => {
    Info.find()
        .then(infos => res.json(infos))
        .catch(err => res.status(400).json('Error: ' + err));
    //res.json(data);
   // console.log(data);
});

router.route('/add').post((req,res) => {
    console.log(req.body.activity);
    console.log(req.body.co2Level);
    console.log(req.body.smokeLevel);
    console.log(req.body.floorNo);
    console.log(req.body.roomNo);
   // res.send({status:200,message:"Details Added Successfully"})
    const activity= req.body.activity;
    const co2Level= req.body.co2Level;
    const smokeLevel= req.body.smokeLevel;
    const floorNo= req.body.floorNo;
    const roomNo= req.body.roomNo;

    let postData ={
        activity,
        co2Level,
        smokeLevel,
        floorNo,
        roomNo
    }

    if (data.lenght == 0){
        data.push(postData);

    }else {
        data.map((data,index)=>{
            if(data.floorNo.equals(floorNo) && data.roomNo.equals(roomNo)){
                data.activity = activity
                data.co2Level = co2Level
                data.smokeLevel = smokeLevel
            }
        });
    }

    const newInfo = new Info({
        activity,
        co2Level,
        smokeLevel,
        floorNo,
        roomNo,
    });

    newInfo.save()
        .then(() => res.json('Info Added'))
        .catch(err => res.status(400).json('Error: ' + err));

});

router.route('/:id').get((req,res) => {
    Info.findById(req.params.id)
        .then(info => res.json(info))
        .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').delete((req,res) => {
    Info.findByIdAndDelete(req.params.id)
        .then(()=> res.json('Infomation deleted'))
        .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/update/:id').post((req,res) => {
    Info.findById(req.params.id)
        .then(info => {
            info.activity = req.body.activity;
            info.co2Level = req.body.co2Level;
            info.smokeLevel = req.body.smokeLevel;
            info.floorNo = req.body.floorNo;
            info.roomNo = req.body.roomNo;

            info.save()
                .then(() => res.json('Information updated'))
                .catch(err => res.status(400).json('Error: ' + err));
        })
        .catch(err => res.status(400).json('Errpr: ' + err));
});

module.exports = router;
