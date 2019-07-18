const emitter = require('./practice').calcEmitter;

//const obj = new Calc();
// process object to access arguments
//process.argv


let _legs = parseInt(process.argv[2]);
//console.log(obj._add(_first,_next));
/*
emitter.emit('calcListener', JSON.stringify({
    method: _method,
    first: _first,
    next: _next
}));
*/

emitter.emit('calcListener', JSON.stringify(_legs));