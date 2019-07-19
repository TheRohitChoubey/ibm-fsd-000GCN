const express = require('express');
const server = express();
const parser = require('body-parser');
const cors = require('cors');
// inject parser in express server
server.use(parser.json());
server.use(cors());
// status api

// calculate api

/*
server.get('/calculator/:operand/:num1/:num2', (req, res) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('content-type', 'application/json');
    
    res.end(JSON.stringify({
        result: parseInt(req.params.num1) + parseInt(req.params.num2)
    }));
});
*/

server.post('/calculator', (req, res) => {
    res.setHeader('content-type', 'application/json');
    console.log(req.body.numo + "---" + req.body.numt);
    const opr = req.body.opro;
    if (opr == '+') {
        res.end(JSON.stringify({
            opr: parseInt(req.body.numo) + parseInt(req.body.numt)
        }));
    }
});
// PORT Binding
const PORT = 1224;
server.listen(PORT, () => {
    console.log(`Server Started at ${PORT}`);
});