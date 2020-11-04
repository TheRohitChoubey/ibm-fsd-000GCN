const express = require('express');
const server = express();
const parser = require('body-parser');
const cors = require('cors');

const userAPis = require('./apis/user.api').server;
const loginApi = require('./apis/login.api').server;

server.use(parser.json());
server.use(cors());

// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Server is Running'
    });
});


server.use('/', loginApi);
server.use('/users', userAPis);

const PORT = 8092;
server.listen(PORT, () => {
    console.log(`Server is Started at ${PORT}`);
});