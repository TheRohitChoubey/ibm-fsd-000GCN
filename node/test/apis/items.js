const server = require('express').Router();
const setContentHeader = require('../services/utils').setContentHeader;

const IService = require('../services/itemService').ItemService;
const itemService = new IService();


// get all users
server.get('/', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        items: itemService._all()
    }));
});

// add a new user
server.post('/add', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        items: itemService._add(req.body)
    }));
});

server.post('/addQuan', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        items: itemService._addQuan(req.body)
    }));
});

server.get('/nextId', (req, res) => {
    setContentHeader(res);
    res.end(
        JSON.stringify({
            nextId: itemService._nextId()
        })
    );
})
module.exports.itemRoutes = server;