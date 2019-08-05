const routes = require('express').Router();
const UserService = require('../services/user.service').UserService;
const userService = new UserService();
const UserConstants = require('../utils/utils').UserConstants;

routes.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: UserConstants.messages.userServiceStatus
    });
});

routes.get('/', (rq, rs) => {
    userService.fetchUsers((entries) => {
        rs.status(200).json({
            entries: entries
        })
    });
});

routes.post('/update', (rq, rs) => {

    userService.update(rq.body, (err, result) => {
        if (err) {
            rs.status(400).json({
                message: 'Unable to process the request',
                err
            });
        } else {
            rs.status(200).json({
                message: "Record Updated",
                result: result
            });
        }
    })
})

routes.post('/updatePlayer', (rq, rs) => {
    userService.updatePlayer(rq.body, (err, result) => {
        if (err) {
            rs.status(400).json({
                message: 'Unable to process the request',
                err
            });
        } else {
            rs.status(200).json({
                message: "Record Updated",
                result: result
            });
        }
    })
})

routes.post('/updateTable', (rq, rs) => {
    const ids = rq.body._id;
    const v = rq.body.v;
    for (i = 0; i < 10; i++) {
        userService.updateTable(ids[i], v[i]);
    }

    rs.status(200).json({
        message: 'Record Updated'
    });

})

module.exports = {
    userRoutes: routes
}