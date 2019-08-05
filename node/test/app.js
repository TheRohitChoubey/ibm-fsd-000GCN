const express = require('express');
const server = express();
const parser = require('body-parser');
const cors = require('cors');
const setContentHeader = require('./services/utils').setContentHeader;

const itemRoutes = require('./apis/items').itemRoutes;
const cartRoutes = require('./apis/cart').cartRoutes;

// apply json parser
server.use(parser.json());
// apply cors
server.use(cors());

server.get('/status', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        message: "Server is RUNNING"
    }));
});

// add routes to server
server.use('/items', itemRoutes);
server.use('/cart', cartRoutes);

// PORT Binding
server.listen(1269, () => {
    console.log('Server started at 1269');
});