const server = require('express').Router();
const PService = require('../services/product.service').ProductService;
const pService = new PService();

const SecurityService = require('../services/security.service').SecurityService;
const securityService = new SecurityService();

const client = require('mongodb').MongoClient;
const UserConstants = require('../services/util.service').UserConstants;

// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Product Service is Running'
    });
});

server.get('/', (rq, rs) => {
    pService.fetchProducts((err, products) => {
        if (err) {
            rs.status(500).json({
                message: 'Unable to process your request'
            });
        } else {
            rs.status(200).json({
                products: products
            });
        }
    })
});

server.post('/add', (rq, rs) => {
    const _token = rq.headers.token;
    const _user = securityService.verifyToken(_token);
    if (_user) {
        securityService.fetchTokenDetails(_token, _user.email, (err, data) => {
            if (err) {
                rs.status(403).json({
                    message: 'Token expired or Invalid'
                });
            } else {
                console.log(data);
                console.log(rq.path);
                if (data[0].permission == rq.path) {
                    client.connect(UserConstants.mongo.url + UserConstants.mongo.port, (err, conn) => {
                        conn.db(UserConstants.mongo.db)
                            .collection(UserConstants.mongo.collections.permission)
                            .find({ email: data.email })
                            .toArray((error, data) => {
                                //callback(error, data);
                                if (error) {
                                    rs.status(403).json({
                                        message: error
                                    });
                                } else {
                                    pService.addProduct(rq.body, (err, res) => {
                                        if (err) {
                                            rs.status(402).json({
                                                message: 'Unable to proceess the request',
                                                trace: err
                                            });
                                        } else {
                                            rs.status(200).json({
                                                message: 'Product added successfully',
                                                products: res
                                            });
                                        }
                                    });
                                }
                            });
                    });
                } else {
                    rs.status(403).json({
                        message: 'Not permitted'
                    });
                }


            }
        });
    }

});

module.exports = {
    server
}