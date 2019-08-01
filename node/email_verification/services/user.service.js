const client = require('mongodb').MongoClient;
const UserConstants = require('./util.service').UserConstants;
const bcrypt = require('bcrypt');
const nodemailer = require('nodemailer');
const Email = require('./email.service').Email;
const emailService = new Email();

class Service {
    // verify user
    fetchUser(_email, callback) {
            const _url = UserConstants.mongo.url + UserConstants.mongo.port;
            client.connect(_url, (err, connection) => {
                connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user).find({ email: _email }).toArray((err, response) => {
                    callback(err, response);
                });
            });
        }
        // generate hash
    generateHash(_pass) {
        return bcrypt.hashSync(_pass, UserConstants.jwt.salt);
    }

    addUser(_user, callback) {
            // update password
            //_user.password = this.generateHash(_user.password);
            const _url = UserConstants.mongo.url + UserConstants.mongo.port;
            client.connect(_url, (err, connection) => {
                connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user).insert(_user, (err, response) => {
                    callback(err, response);
                });
            });
        } // end of add user

    email(user) {
        let userObj = {
            subject: "User Registration",
            body: `<div>Dear <b>${user.name}</b></div>
                <div><br> Your Verification Code is : #${user.name[0]+'@'+user.email[0]}!</div>
                        <div><br>Thank you for registering</div>`,
            from: null,
            to: user.email
        }
        console.log(userObj);
        emailService.email(userObj);
    }

    // get all users
    fetchUsers(callback) {
            const _url = UserConstants.mongo.url + UserConstants.mongo.port;
            client.connect(_url, (err, connection) => {
                connection
                    .db(UserConstants.mongo.db)
                    .collection(UserConstants.mongo.collections.user)
                    .find()
                    .toArray((err, response) => {
                        callback(error, response);
                    });
            });
        } // end of fetch user
}

module.exports = {
    UserService: Service
}