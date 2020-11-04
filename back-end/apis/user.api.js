const server = require('express').Router();
const UService = require('../services/user.service').UserService;
const uService = new UService();


server.get('/status', (rq, rs) => {

    rs.status(200).json({
        message: 'User Service is Running'
    });
});

server.post('/search', (rq, rs) => {
    let email = rq.body;
    uService.fetchEmployee(email.email, (err, employee) => {
        if (err) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            rs.status(200).json({
                employee: employee
            });
        }
    })
});

server.post('/deposit', (rq, rs) => {
    let details = rq.body.details;
    let amount = rq.body.amount;
    details.amount += amount;
    let date = new Date();
    transactionDetails = {
        to : details.email,
        from : details.email,
        date : date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear(),
        amount : amount
    }
    console.log(transactionDetails);
    uService.transactionAmount(details, (err, response) => {})
    uService.transactionTable(transactionDetails,(err, result) => {
        if (err) {
            rs.status(400).json({
                message: 'Unable to process the request'
            });
        } else {
            rs.status(200).json({
                result: result
            });
        }
    });
});

server.post('/depositOther', (rq, rs) => {
    let details = rq.body.details;
    let amount = rq.body.amount;
    let otherEmail = rq.body.email;
    let date = new Date();
    transactionDetails = {
        to : otherEmail,
        from : details.email,
        date : date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear(),
        amount : amount
    }
    uService.fetchEmployee(otherEmail, (er, res) => {
        if (er) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            otherDetails = res[0];
            otherDetails.amount += amount;
            details.amount -= amount;
            uService.transactionSelf(details.email,details.amount, (err, response) => { });
            uService.transactionAmount(otherDetails, (eror, re) => { });
            uService.transactionTable(transactionDetails,(err, result) => {
                if (err) {
                    rs.status(400).json({
                        message: 'Unable to process the request'
                    });
                } else {
                    rs.status(200).json({
                        result: result
                    });
                }
            });
            
        }
    })
});

server.post('/withdraw', (rq, rs) => {
    let details = rq.body.details;
    let amount = rq.body.amount;
    let date = new Date();
    details.amount -= amount;
    console.log(details);
    transactionDetails = {
        to : details.email,
        from : details.email,
        date : date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear(),
        amount : -amount
    }
    uService.transactionAmount(details, (err, response) => {})
    uService.transactionTable(transactionDetails,(err, result) => {
        if (err) {
            rs.status(400).json({
                message: 'Unable to process the request'
            });
        } else {
            rs.status(200).json({
                result: result
            });
        }
    });
});


server.get('/history/:email', (rq, rs) => {
    let email = rq.params.email;
    uService.fetchHistory(email, (er, res) => {
        if (er) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            rs.status(200).json({
                history : res
            });       
        }
    })
});

module.exports = {
    server
}