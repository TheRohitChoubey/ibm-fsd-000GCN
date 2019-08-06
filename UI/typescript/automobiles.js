var detail = {
    car: {
        brand: "Ferrari",
        mileage: 4
    },
    bus: {
        capacity: 40,
        volvo: false
    }
};
var Vehicle = /** @class */ (function () {
    function Vehicle(vehicle) {
        this.vehicle = vehicle;
    }
    Vehicle.prototype.getVehicle = function () {
        return this.vehicle;
    };
    return Vehicle;
}());
var car = new Vehicle({ id: 1, brand: detail.car.brand, mileage: detail.car.mileage });
var bus = new Vehicle({ id: 2, capacity: detail.bus.capacity, volvo: detail.bus.volvo });
console.log(car.getVehicle());
console.log(bus.getVehicle());
