const UserConstants = {
    mongo: {
        url: 'mongodb://localhost:',
        port: 27017,
        db: 'userjwt',
        collections: {
            user: 'user',
            security: 'security',
            product: 'product',
            permission: 'permission'
        }
    },
    jwt: {
        key: 'thisisourjwtprivatekey',
        salt: '$2b$10$X4kv7j5ZcG39WgogSl16au'
    },
    smtp: {
        provider: 'gmail',
        address: 'ibmtechtraining007@gmail.com',
        password: 'India@786'
    }
}

module.exports = {
    UserConstants
}