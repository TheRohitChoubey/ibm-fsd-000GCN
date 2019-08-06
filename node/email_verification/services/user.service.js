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
                connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user)
                    .find({ email: _email }).toArray((err, response) => {
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

    update(email, callback) {

        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user)
                .updateOne({ email: email }, { $set: { status: "valid" } }, (err, response) => {
                    callback(err, response);
                });
        });
    }

    updatePassword(credentials, callback) {

        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user)
                .updateOne({ email: credentials.email, status: "valid" }, { $set: { password: credentials.password }, }, { upsert: true }, (err, response) => {
                    callback(err, response);
                });
        });
    }

    updateVarCode(details, callback) {

        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(UserConstants.mongo.db).collection(UserConstants.mongo.collections.user)
                .updateOne({ email: details.email }, { $set: { varcode: details.varcode, endTime: details.endTime }, }, { upsert: true }, (err, response) => {
                    callback(err, response);
                });
        });
    }

    email(user) {
        let userObj = {
            subject: "User Registration",
            body: `<div>Dear <b>${user.name}</b></div>
                <div><br> Your Verification Code is :http://localhost:46767/auth/otp?=${user.email}?=${user.varcode}</div>
                <div><br><a href="#">Click Here</a>
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