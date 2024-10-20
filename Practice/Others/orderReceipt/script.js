'use strict';


const menu = {
    meals: [
        {
            name: 'Longganisa',
            price: 165.00,
        },
        {
            name: 'Beef Tapa',
            price: 165.00,
        },
        {
            name: 'Corned Beef',
            price: 165.00,
        },
        {
            name: 'Fried Chicken',
            price: 148.00,
        },
        {
            name: 'Burger Steak',
            price: 127.00,
        },
    ],
    drinks: [
        {
            name: 'Bottled Water',
            price: 30.00,
        },
        {
            name: 'Coke',
            price: 53.00,
        },
        {
            name: 'Sprite',
            price: 53.00,
        },
        {
            name: 'Soda Floats',
            price: 57.00,
        },
        {
            name: 'Pineapple Juice',
            price: 64.00,
        }
    ],
    dateTime: new Date().toLocaleString().replace('', ''),


    orderDelevery: function ({ orderedMeal, orderedDrinks, customerAddress }) {
        let reciept = alert(`
            ${this.dateTime}
            Your order:
                    ${this.meals[orderedMeal].name} .......... ${this.meals[orderedMeal].price}.00
                    ${this.drinks[orderedDrinks].name} .......... ${this.drinks[orderedDrinks].price}.00
             this will be deliver in ${customerAddress}`);
        return reciept;
    }

}

// menu.orderDelevery({
//     orderedMeal: 3,
//     orderedDrinks: 1,
//     customerAddress: 'Pampanga'
// })
