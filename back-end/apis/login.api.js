const server = require('express').Router();
const UService = require('../services/user.service').UserService;
const uService = new UService();


server.get('/status', (rq, rs) => {

    rs.status(200).json({
        message: 'Product Service is Running'
    });
});

server.get('/login/:email', (rq, rs) => {
    let email = rq.params.email;
    uService.login(email, (err, user) => {
        if (err) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            rs.status(200).json({
                user: user
            });
        }
    })
});

server.post('/signup', (rq, rs) => {
    let userData = rq.body;
    uService.login(userData.email, (err, user) => {
        if (err) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            console.log("User from login",user);
            if (isEmpty(user)) {
                uService.register(userData, (err, data) => {
                    if (err) {
                        rs.status(500).json({
                            message: 'Unable to process your request'
                        });
                    } else {
                        rs.status(200).json({
                            user: ""
                        });
                    }
                })
            }
            else{
                rs.status(200).json({
                    message: 'Data exist'
                });
            }
        }
    })

});

module.exports = {
    server
}

function isEmpty(obj) {
    for(var key in obj) {
        if(obj.hasOwnProperty(key))
            return false;
    }
    return true;
}