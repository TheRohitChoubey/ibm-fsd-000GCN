const client = require('mongodb').MongoClient;
const UserConstants = require('../util/util.service').UserConstants;

class Service {

    login(email,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.user)
                .find({ email: email})
                .toArray((error, response) => {
                    callback(error, response);
                });
        });
    }

    fetchEmployee(email,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.user)
                .find({ email: email})
                .toArray((error, response) => {
                    callback(error, response);
                });
        });
    }

    transactionAmount(details,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.user)
                .update({ email: details.email},{$set: {amount: details.amount}})
                
        });
    }

    transactionSelf(email,amount,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.user)
                .update({ email: email},{$set: {amount: amount}})
                
        });
    }

    transactionTable(details,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.transaction)
                .insert(details, (err, response) => {
                    callback(err, response);
                });
        });
    }

    register(userData,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.user)
                .insert(userData, (err, response) => {
                    callback(err, response);
                });
        });
    }

    fetchHistory(email,callback) {
        const _url = UserConstants.mongo.url + UserConstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection
                .db(UserConstants.mongo.db)
                .collection(UserConstants.mongo.collections.transaction)
                .find({$or:[{to:email},{from:email}]})
                .toArray((error, response) => {
                    callback(error, response);
                });
        });
    }
}

module.exports = {
    UserService: Service
}