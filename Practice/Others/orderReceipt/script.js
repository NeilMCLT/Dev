'use strict';

const menu = {
    meals: ['Longganisa', 'Beef Tapa', 'Corned Beef', 'Fried Chicken', 'Burger Steak'],
    drinks: ['Water', 'Coke', 'Sprite', 'Iced tea', 'Orange Juice'],
    dateTime: new Date().toLocaleString().replace('', ''),

    orderDelevery: function ({ orderedMeal, orderedDrinks, customerAddress }) {
        let reciept = alert(`
            ${this.dateTime}
            Your order:
                    ${this.meals[orderedMeal]}
                    ${this.drinks[orderedDrinks]}
             this will be deliver in ${customerAddress}`);
        return reciept;
    }
}

menu.orderDelevery({
    orderedMeal: 0,
    orderedDrinks: 1,
    customerAddress: 'Pampanga'
})