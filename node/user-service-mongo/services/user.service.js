const MongoClient = require('mongodb').MongoClient;
const UserConstants = require('../utils/utils').UserConstants;
class UserService {

    fetchUsers(callback) {
        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            conn.db(UserConstants.mongo.db).collection('users').find({}).toArray((error, users) => {
                if (!error) {
                    console.log(users);
                    callback(users);
                }
            });
        });
    }

    add(_user, callback) {
        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            conn.db(UserConstants.mongo.db).collection('users').insert(_user, (err, response) => {
                callback(err, response);
            });
        });
    }

    delete(_id, callback) {
        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            conn.db(UserConstants.mongo.db).collection('users').deleteMany(_id, (err, response) => {
                callback(err, response);
            });
        });
    }

    update(user, callback) {

        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            const id = user._id;
            delete user._id;
            console.log(user);
            conn.db(UserConstants.mongo.db).collection('users').updateOne({ _id: id }, { $set: user }, (err, response) => {
                callback(err, response);
            });
        });
    }
}

module.exports = {
    UserService
}