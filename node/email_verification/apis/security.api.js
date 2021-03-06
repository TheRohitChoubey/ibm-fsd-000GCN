const server = require('express').Router();
const UserService = require('../services/user.service').UserService;
const userService = new UserService();
const SecurityService = require('../services/security.service').SecurityService;
const securityService = new SecurityService();
// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Security Service is Running'
    });
});
// sign up

server.post('/register', (rq, rs) => {
    let _user = rq.body;

    let date = new Date();
    let end_Time = date.getTime() + 300000;

    let endTime = {
        endTime: end_Time
    }

    let code = _user.name[0] + '!' + _user.email[0] + '@' + Math.floor(Math.random() * Math.floor(100)) + '$';

    let varCode = {
        varcode: code
    }

    let status = {
        status: "invalid"
    }

    _user = Object.assign(_user, endTime, varCode, status);
    console.log(_user);

    userService.addUser(_user, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {
            userService.email(_user);
            rs.status(200).json({
                message: 'User created successfully',
                users: res
            });
        }
    });

});


// generate new password
server.get('/otp/:email/:name/:code', (rq, rs) => {
    let email = rq.params.email;
    let code = rq.params.code;
    let name = rq.params.name;
    console.log(email, "VarCodeURL=" + code);
    userService.fetchUser(email, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {
            let date = new Date();
            let currtim = date.getTime();
            console.log("VarcodeDB=" + res[0].varcode);
            console.log(currtim);
            if (res[0].varcode == code) {
                if (parseInt(res[0].endTime) >= parseInt(currtim)) {
                    userService.update(res[0].email, (err, response) => {
                        rs.redirect('D:\\ibm-fsd-000GCN\\node\\email_verification\\services\\passwordSet.html');

                    });
                } else {
                    let _user = {
                        email: rq.params.email,
                        name: name
                    }
                    let date = new Date();
                    let end_Time = date.getTime() + 300000;

                    let endTime = {
                        endTime: end_Time
                    }

                    let code = _user.name[0] + '!' + _user.email[0] + '@' + Math.floor(Math.random() * Math.floor(100)) + '$';

                    let varCode = {
                        varcode: code
                    }

                    let status = {
                        status: "invalid"
                    }

                    _user = Object.assign(_user, endTime, varCode, status);
                    userService.email(_user);
                    userService.updateVarCode(_user, (err, res) => {
                        if (err) {
                            rs.status(402).json({
                                message: 'Unable to proceess the request',
                                trace: err
                            });
                        } else {
                            userService.email(_user);
                            rs.status(200).json({
                                message: 'Unable to proceess the request.. Time Limit Expired New Opt Sent'
                            });
                        }
                    });
                }
            } else {
                rs.status(402).json({
                    message: 'Unable to proceess the request Wrong OTP'
                });
            }
        }
    });
});

//set the password
server.post('/password', (rq, rs) => {
    userService.updatePassword(rq.body, (err, response) => {
        rs.status(200).json({
            message: 'Password set successfull',
            users: response
        })
    });
});


server.post('/token', (rq, rs) => {
    if (rq.body.email == undefined || rq.body.password == undefined) {
        rs.status(401).json({
            message: 'Please specify valid credentials'
        });
    } else {
        userService.fetchUser(rq.body.email, rq.body.password, (err, res) => {
            if (err) {
                rs.status(401).json({
                    message: 'Please specify valid credentials'
                });
            } else {
                if (res) {
                    // generate jwt token
                    const _token = securityService.generateToken(rq.body.email);
                    const _user = {
                        id: 1,
                        token: _token,
                        email: rq.body.email,
                        permission: rq.body.permission
                    }
                    securityService.saveToken(_user, (err, data) => {
                        if (err) {
                            rs.status(401).json({
                                message: 'Unable to process your request'
                            });
                        } else {
                            rs.status(200).json({
                                message: 'Token Generated Successfully',
                                token: _token
                            });
                        }
                    });
                } else {
                    rs.status(401).json({
                        message: 'Please specify valid credentials'
                    });
                }
            }
        });
    }
});

server.post('/token/refresh', (rq, rs) => {
    if (rq.body.token == undefined) {
        rs.status(401).json({
            message: 'Please specify a valid token'
        });
    } else {
        securityService.refreshToken(rq.body.token, (err, data) => {
            if (err) {
                rs.status(403).json({
                    message: 'Token expired or Invalid'
                });
            } else {
                // generate jwt token
                const _token = securityService.generateToken(data.email);
                const _user = {
                    id: 1,
                    token: _token,
                    email: data.email
                }
                securityService.saveToken(_user, (err, data) => {
                    if (err) {
                        rs.status(401).json({
                            message: 'Unable to process your request'
                        });
                    } else {
                        rs.status(200).json({
                            message: 'Token refreshed Successfully',
                            refreshToken: _token
                        });
                    }
                });
            }
        });
    }
});
// redirect in case of invalid / no access
server.get('/unauthorize', (rq, rs) => {
    rs.status(403).json({
        message: 'Unauthorize Access'
    });
});

module.exports = {
    server
}