const router = require('express').Router();
let Sensor = require('../model/sensor.model');

router.route('/').get((req,res) => {
    Sensor.find()
        .then(infos => res.json(infos))
        .catch(err => res.status(400).json('Error: ' + err));
});


router.route('/add').post((req,res) => {
    const status= req.body.status;
    const floorNo= req.body.floorNo;
    const roomNo= req.body.roomNo;

    const sensor = new Sensor({
        status,
        floorNo,
        roomNo,
    });

    sensor.save()
        .then(() => res.json('Info Added'))
        .catch(err => res.status(400).json('Error: ' + err));
});

module.exports = router;
