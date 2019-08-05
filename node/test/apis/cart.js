const server = require('express').Router();
const setContentHeader = require('../services/utils').setContentHeader;

const CService = require('../services/cartService').CartService;
const cartService = new CService();


// get all users
server.get('/', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        cart: cartService._all()
    }));
});

// add a new user
server.post('/add', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        cart: cartService._add(req.body)
    }));
});

server.post('/removeId', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        cart: cartService._removeId(req.body)
    }));
});

server.post('/addQuan', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        cart: cartService._addQuan(req.body)
    }));
});

server.get('/length', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        length: cartService._length()
    }));
});

server.post('/email', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        cart: cartService.email(req.body)
    }));
});

module.exports.cartRoutes = server;