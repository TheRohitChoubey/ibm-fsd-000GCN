const setContentHeader = (res) => {
    res.setHeader('content-type', 'application/json');
};

const utils = {
    smtp: {
        provider: 'gmail',
        address: 'ibmtechtraining007@gmail.com',
        password: 'India@786'
    }
}

module.exports.setContentHeader = setContentHeader;
module.exports.utils = utils;