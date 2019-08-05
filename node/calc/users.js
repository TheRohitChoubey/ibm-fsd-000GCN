const router = require('express').Router();
const Service = require('./user.service').Service;
const service = new Service();


const validate = require('./security.service').validate;

// status api
router.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'User Service is running'
    });
});

// sign up 
router.post('/register', (rq, rs) => {
    service.register(rq.body);
    rs.status(200).json({
        message: 'User has been registered successfully'
    });
});

// show all users
router.get('/', (rq, rs) => {
    rs.status(200).json({
        message: 'Users',
        data: service.getAllUsers()
    });
});


// generate token to login
router.post('/login', (rq, rs) => {
    // generate token
    const userExists = service.isUser(rq.body.user, rq.body.pass);
    if (userExists) {
        const token = service.generateToken(userExists);
        rs.status(200).json({
            token: token
        })
    } else {
        console.log("Rohit");
        rs.redirect('/unauthorize');
    }
});

module.exports.useRoutes = router;