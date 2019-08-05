const MongoClient = require('mongodb').MongoClient;
const UserConstants = require('../utils/utils').UserConstants;
class UserService {

    fetchUsers(callback) {
        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            conn.db(UserConstants.mongo.db).collection('tictactoe').find({}).toArray((error, entries) => {
                if (!error) {
                    callback(entries);
                }
            });
        });
    }


    update(tic, callback) {

        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            const id = tic._id;
            delete tic._id;
            conn.db(UserConstants.mongo.db).collection('tictactoe').updateOne({ _id: id }, { $set: tic }, (err, response) => {
                callback(err, response);
            });
        });
    }

    updatePlayer(tic, callback) {

        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            const id = tic._id;
            delete tic._id;
            conn.db(UserConstants.mongo.db).collection('tictactoe').updateOne({ _id: "9" }, { $set: tic }, (err, response) => {
                callback(err, response);
            });
        });
    }

    updateTable(id, val) {

        MongoClient.connect(UserConstants.mongo.url, (err, conn) => {
            //console.log(tic);
            conn.db(UserConstants.mongo.db).collection('tictactoe').updateOne({ _id: id }, { $set: { v: val } }, (err, response) => {
                //callback(err, response);
            });
            conn.close();
        });
    }
}

module.exports = {
    UserService
}