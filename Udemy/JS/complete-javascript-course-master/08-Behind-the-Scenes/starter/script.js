'use strict';

// console.log(me);
// console.log(job);
// console.log(year);

// var me = 'Jonas';
// let job = 'teacher';
// const year = 1991;

// Functions

// console.log(addDecl(1, 2));
// console.log(addExpr(1, 2));
// console.log(addArrow(1, 2));

// function addDecl(a, b) {
//     return a + b;
// }

// const addExpr = function (a, b) {
//     return a + b;
// }

// var addArrow = (a, b) => a + b;

// // This Keyword

// const calcAge = function (birthyear) {
//     console.log(2037 - birthyear);
//     console.log(this);
// }

// calcAge(1991);

// const myFirstName = prompt(`What is your first name?`);
// const myLastName = prompt(`What is your last name?`);
// const myGender = prompt(`What is your gender?`)
// const uSingle = prompt(`Are you single or married?`);
// const partnerFName = prompt(`What is the first name of your partner?`);
// const partnerLName = prompt(`What is the last name of your partner?`);

// if (uSingle === `Married` && myGender === `Female`) {
//     alert(`So you are ${myFirstName} ${partnerLName}, because you are married to ${partnerFName} ${partnerLName}.`)

// } else {
//     alert(`Sadly, your partner is crying right now.💔`)
// }


// Regular function vs Arrow Function

// const jonas = {
//     firstname: 'Neil',
//     year: 1991,
//     calcAge: function () {
//         console.log(this);
//         console.log(2037 - this.year);
//     },

//     greet: () => console.log(`Hey ${this.firstname}`),
// };

// jonas.greet();
// console.log(this.firstname);



// let age = 30;
// let oldAge = age;
// age = 31;
// console.log(age);
// console.log(oldAge);

// const me = {
//     name: 'Neil',
//     age: 23
// };

// const friend = me;
// friend.age = 27;

// console.log(me);
// console.log(friend);

// Primitive types
let lastName = 'Williams';
let oldLastName = lastName;

lastName = 'Davis';
console.log(lastName, oldLastName);

// Reference types
const jessica = {
    firstname: 'jessica',
    lastName: 'Williams',
    age: 27
};
const marriedJessica = jessica;
marriedJessica.lastName = 'Davis';

console.log('Before', jessica);
console.log('After', marriedJessica);

// Copying objects
const jessica2 = {
    firstname: 'jessica',
    lastName: 'Williams',
    age: 27,
    family: ['Alice', 'Bob'],
};

const jessicaCopy = Object.assign({}, jessica2);
jessicaCopy.lastName = 'Davis';

jessicaCopy.family.push('Mary');
jessicaCopy.family.push('John');

console.log('Before', jessica2);
console.log('After', jessicaCopy);
