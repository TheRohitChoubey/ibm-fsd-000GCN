const client = require('mongodb').MongoClient;
const Userconstants = require('./util.service').Userconstants;

class Service {
    //addUser

    addUserBySubject(_user) {
        const _url = Userconstants.mongo.url + Userconstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(Userconstants.mongo.db).collection(Userconstants.mongo.collection.user)
                .updateOne({ _id: _user.subject }, { $push: { name: _user.name } }, { upsert: true }, (err, response) => {});
        });
    }

    addUserByTime(time, name) {
        const _url = Userconstants.mongo.url + Userconstants.mongo.port;
        client.connect(_url, (err, connection) => {
            connection.db(Userconstants.mongo.db).collection(Userconstants.mongo.collection.user)
                .updateOne({ _id: time }, { $push: { name: name } }, { upsert: true }, (err, response) => {});
        });
    }
}

module.exports = {
    Service
}