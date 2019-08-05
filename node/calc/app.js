const express = require('express');
const server = express();
const parser = require('body-parser');
const useRoutes = require('./users').useRoutes;
const calcRoutes = require('./calculator').calcRoutes;
const cors = require('cors');

server.use(cors());

server.use(parser.json());

server.get('/status', (rq, rs) => {
    emailService.send();
    rs.status(200).json({
        message: 'Service is running'
    });
});


server.use('/unauthorize', (rq, rs) => {
    rs.end(JSON.stringify({
        opr: "unauthorize"
    }));
});
// map user routes
server.use('/users', useRoutes);
server.use('/calculator', calcRoutes);

//PORT
const PORT = 1234;

server.listen(PORT, () => {
    console.log(`Server Started at ${PORT}`);
});