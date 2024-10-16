'use strict';




/*

// DONE Destructuring Arrays

const arr = [2, 3, 4];
// Hard Coded
const a = arr[0];
const b = arr[1];
const c = arr[2];

const [x, y, z] = arr;
console.log(x, y, z);



// let [main, , secondary] = restaurant.categories;
// console.log(main, secondary);

// Switching variables of the array
// [main, secondary] = [secondary, main];
// console.log(main, secondary);

// console.log(restaurant.order(2, 0));

// Recieve 2 return values from the oder function in the restaurant object
const [starter, mainCourse] = restaurant.order(2, 0)
console.log(starter, mainCourse);

// Nested Destructuring
const nested = [2, 4, [5, 6]];
// const [i, , j] = nested;
// console.log(i, j);

const [i, , [j, k]] = nested;
console.log(i, j, k);

// Default Values
const [p = 1, q = 1, r = 1] = [8, 9];
console.log(p, q, r);



// Data needed for a later exercise
const flights =
  '_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30';

// Data needed for first part of the section
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  openingHours: {
    thu: {
      open: 12,
      close: 22,
    },
    fri: {
      open: 11,
      close: 23,
    },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },

  order: function (starterIndex, mainIndex) {

    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];

  },

  orderDelivery: function ({ starterIndex, mainIndex, address, time }) {
    console.log(`Order Reciept:
      You have ordered ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]}, 
      at ${time} in ${address}`);
  },
};

restaurant.orderDelivery({
  starterIndex: 2,
  mainIndex: 2,
  time: '11:00am',
  address: 'Pampanga',
});

// TODO Destructure Objects

const { name, openingHours, categories } = restaurant;
console.log(name, openingHours, categories);

const { name: restaurantName, openingHours: hours, categories: tags } = restaurant;
console.log(restaurantName, hours, tags);

// Set default " = [] "
const { menu = [], starterMenu: starters = [] } = restaurant
console.log(menu, starters);

// Mutating variables
let a = 111;
let b = 999;
const obj = { a: 23, b: 7, c: 14 };
({ a, b } = obj);
console.log(a, b);

// Nested Object
const { fri: { open: o, close: c } } = openingHours
console.log(o, c);
*/