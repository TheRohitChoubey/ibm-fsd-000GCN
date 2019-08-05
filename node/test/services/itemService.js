const items = require('../db/items').items;
class ItemService {
    items = [];
    constructor() {
        this.items = items;
    }
    _all() {
        return this.items;
    }
    _add(item) {
        this.items.push(item);
        return this.items;
    }

    _addQuan(item) {
        let ind = -1;
        const findItem = this.items.find((i, index) => {
            ind = index;
            return i.id == item.id;
        })

        this.items[ind].quantity = item.quantity;
        return this.items;
    }

    _nextId() {
        return this.items.length + 1;
    }
}

module.exports.ItemService = ItemService;