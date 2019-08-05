const Service = require('./user.service').Service;
const service = new Service();

const validate = (rq, rs, next) => {
    const token = rq.headers.token;
    if (token) {
        const isValid = service.validateToken(token);
        if (isValid) {
            next();
        } else {
            console.log("Rohit");
            rs.redirect('/unauthorize');
        }
    } else {
        console.log("Rohit");
        rs.redirect('/unauthorize');
    }
}

module.exports.validate = validate;