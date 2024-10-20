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


// DONE Destructure Objects

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

// DONE The Spread Operator (...)

const arr = [7, 8, 9];
const badNewArr = [1, 2, arr[0], arr[1], arr[2]];
console.log(badNewArr);

// Spread Operator "..."
const newArr = [1, 2, ...arr];
console.log(newArr);

console.log(...newArr); // Individual array

const newMenu = [...restaurant.mainMenu, 'Pansit'];
console.log(newMenu);

// Copy array
const mainMenuCopy = [...restaurant.mainMenu];

// Join 2 arrays
const menu = [...restaurant.mainMenu, ...restaurant.starterMenu]
console.log(menu);

// Iterables: arrays, strings, maps, sets. NOT objects
const str = 'Neil';
const letters = [...str, '', 's']
console.log(letters);
console.log(...str);

// Real world used
function orderPasta(ing1, ing2, ing3) {
  console.log(`Here is your delicious Pasta, with ${ing1}, ${ing2} and ${ing3}.`);
};

const ingredients = [
  // prompt('What is the first ingredient?'),
  // prompt('How about the second one?'),
  // prompt('The third one?')
]

orderPasta(...ingredients);

// Objects 
const newRestaurant = { foundedIn: 1999, ...restaurant, founder: 'Neil pogi' }
console.log(newRestaurant);

const restaurantCopy = { ...restaurant };
restaurantCopy.name = 'Neil Restobar';
console.log(restaurantCopy.name);
console.log(restaurant.name);
*/


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


  orderPizza: function (mainIng, ...otherIng) {
    console.log(mainIng);
    console.log(otherIng);
  },

  // order: function (starterIndex, mainIndex) {

  //   return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]];

  // },

  // orderDelivery: function ({ starterIndex, mainIndex, address, time }) {
  //   console.log(`Order Reciept:
  //     You have ordered ${this.starterMenu[starterIndex]} and ${this.mainMenu[mainIndex]}, 
  //     at ${time} in ${address}`);
  // },
};

restaurant.orderPizza('Mushrooms', 'Onion', 'Olives', 'Spinach');

// restaurant.orderDelivery({
//   starterIndex: 2,
//   mainIndex: 2,
//   time: '11:00am',
//   address: 'Pampanga',
// });

// 1. Destructuring

// Rest Pattern and Parameters

// Spread operator is always on the right side of the assignment
const arr = [1, 2, ...[3, 4]];
console.log(arr);

// Rest operator is always on the left side of the assignment
const [a, b, ...others] = [1, 2, 3, 4, 5];
console.log(a, b, others);

const [pizza, risotto, ...otherFood] = [...restaurant.mainMenu, ...restaurant.starterMenu]
console.log(pizza, risotto, otherFood);

// Objects
const { sat, ...weekdays } = restaurant.openingHours;
console.log(weekdays);

// 2. Functions
const add = function (...numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++)
    sum += numbers[i];
  console.log(sum);
}


add(2, 3);
add(5, 3, 7, 2);
add(8, 2, 5, 3, 2, 1, 4);


