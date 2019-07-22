const server = require('express').Router();
const setContentHeader = require('../services/utils').setContentHeader;

const PService = require('../services/user_compService').User_compService;
const user_compService = new PService();

// get all projects
server.get('/', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        user_comp: user_compService._all()
    }));
});


server.post('/add', (req, res) => {
    setContentHeader(res);
    res.end(JSON.stringify({
        user_comp: user_compService._add(req.body)
    }));
});

module.exports.projects_usersRoutes = server;