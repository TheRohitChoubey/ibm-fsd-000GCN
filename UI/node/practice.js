const EventEmitter = require('events').EventEmitter;
const emitter = new EventEmitter();

class CalListener {
    _execute(request) {
        if (request != "2")
            console.log("Animal");
        else
            console.log("Human");

    }
}

const calcListner = new CalListener();

emitter.addListener('calcListener', calcListner._execute);
module.exports = {
    calcEmitter: emitter
}