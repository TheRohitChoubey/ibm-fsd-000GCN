const server = require('express').Router();
const parser = require('body-parser');
const cors = require('cors');

const validate = require('./security.service').validate;

// inject parser in express server
server.use(parser.json());
server.use(cors());

server.use('/calc', (rq, rs, next) => {
    validate(rq, rs, next);
});

server.post('/calc', (req, res) => {
    res.setHeader('content-type', 'application/json');
    const opr = req.body.opro;
    if (opr == '+') {
        res.end(JSON.stringify({
            opr: parseInt(req.body.numo) + parseInt(req.body.numt)
        }));
    } else if (opr == '-') {
        res.end(JSON.stringify({
            opr: parseInt(req.body.numo) - parseInt(req.body.numt)
        }));
    } else if (opr == '*') {
        res.end(JSON.stringify({
            opr: parseInt(req.body.numo) * parseInt(req.body.numt)
        }));
    } else if (opr == '/') {
        res.end(JSON.stringify({
            opr: parseInt(req.body.numo) / parseInt(req.body.numt)
        }));
    } else if (opr == '^') {
        console.log(opr);
        res.end(JSON.stringify({

            opr: Math.pow(parseInt(req.body.numo), parseInt(req.body.numt))
        }));
    } else if (opr == 'sqrt') {
        res.end(JSON.stringify({
            opr: Math.sqrt(parseInt(req.body.numo))
        }));
    }
});



module.exports.calcRoutes = server;