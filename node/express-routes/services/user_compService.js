const user_comp = require('../db/user_comp').user_comp;
class User_compService {
    user_comp = [];
    constructor() {
        this.user_comp = user_comp;
    }
    _all() {
        return this.user_comp;
    }
    _add(user_comp) {
        this.user_comp.push(user_comp);
        return this.user_comp;
    }
}

module.exports.User_compService = User_compService;