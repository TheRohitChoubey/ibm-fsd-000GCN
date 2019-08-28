const express = require('express');
const server = express();
const parser = require('body-parser');
const cors = require('cors');

const userAPI = require('./apis/user.api').server
const userService = require('./services/user.service').server;

server.use(parser.json());
server.use(cors());

server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: "Service is Running"
    });
});

server.use('/users', userAPI);

const PORT = 1234;

server.listen(PORT, () => {
    console.log('Server has started on port ' + PORT);
});