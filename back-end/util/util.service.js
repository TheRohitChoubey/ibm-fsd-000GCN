const UserConstants = {
    mongo: {
        url: 'mongodb://localhost:',
        port: 27017,
        db: 'my-sample-db',
        collections: {
            user: 'user',
            transaction : 'transaction'
        }
    }
}

module.exports = {
    UserConstants
}