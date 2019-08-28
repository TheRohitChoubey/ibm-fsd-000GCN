const server = require('express').Router();

const Service = require('../services/user.service').Service;
const uService = new Service();

server.post('/register', (rq, rs) => {
    user = rq.body.user;
    console.log(user);
    for (i = 0; i < user.length; i++) {
        uService.addUserBySubject(user[i]);
    }

    for (i = 10; i <= 12; i++) {
        uService.addUserByTime(i, user[0].name);
    }
    rs.status(200).json({
        message: "User Created"
    })
})

module.exports = {
    server
}