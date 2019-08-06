interface Automobile{
    id : number;
}

interface Car extends Automobile{
    brand : string;
    mileage : number;
}

interface Bus extends Automobile{
    capacity : number;
    volvo : boolean;
}

const detail ={
    car: {
            brand:"Ferrari",
            mileage : 4
    },
    bus: {
        capacity : 40,
        volvo : false
    }
};

class Vehicle<T extends Automobile>{
    vehicle : T;

    constructor(vehicle:T){
        this.vehicle = vehicle;
    }

    getVehicle():T{
        return this.vehicle;
    }
}

const car = new Vehicle<Car>({id:1, brand: detail.car.brand, mileage : detail.car.mileage });
const bus = new Vehicle<Bus>({id:2, capacity: detail.bus.capacity,volvo : detail.bus.volvo });

console.log(car.getVehicle());
console.log(bus.getVehicle());