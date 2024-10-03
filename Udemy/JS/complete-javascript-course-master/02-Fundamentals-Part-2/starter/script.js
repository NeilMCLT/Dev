'use strict';
/*
let hasDriversLicense = false;
const passTest = true;
let result;

if (passTest && hasDriversLicense == true) {
    result = 'You can drive'
} else {
    result = "You can't drive"
}

console.log(result);

if (passTest) hasDriversLicense = true;
if (hasDriversLicense) console.log('U can drive');





//Function

function logger() {
    console.log('My name is Neil')
}

// Calling / running / invoking
logger();
logger();
logger();

function fruitProcessor(apples, oranges) {
    let appleWord = apples <= 1 ? 'apple' : 'apples';
    let orangeWord = oranges <= 1 ? 'orange' : 'oranges';
    let yourFruits = `You have ${apples} ${appleWord} and ${oranges} ${orangeWord}.`
    return yourFruits;
}

let result = fruitProcessor(5, 1);
console.log(result);

//Let's try another one.

let firstName, middleInitial, lastName
const nameRegex = /^[A-Za-z]+$/;
const middleRegex = /^[A-Za-z]$/

myDetails();
function myDetails() {
    firstName = prompt('What is your first name?');
    middleInitial = prompt('What is your middle initial?');
    lastName = prompt('What is your last name?');

    if (firstName && nameRegex.test(firstName) && middleInitial && middleRegex.test(middleInitial) && lastName && nameRegex.test(lastName)) {
        myInfo(firstName, middleInitial, lastName);
    } else {
        alert('You should put a correct details.');
        myDetails();
    }


}

function myInfo(firstName, middleInitial, lastName) {
    alert(`So, you are ${firstName} ${middleInitial}. ${lastName}?`);
}



//Fucntion declaration

function calAge1(birthyear) {
    return 2024 - birthyear;
}

console.log(calAge1(2001));



//Function Expression

const calAge2 = function (birthyear) {
    return 2024 - birthyear;
}

console.log(calAge2(2001));



//Arrow Function

const calAge3 = birthYear => 2024 - birthYear;
const age3 = calAge3(2001);
console.log(age3);

const yearsUntilRetirement = (birthYear, firstName) => {
    const age = 2024 - birthYear;
    const retirement = 60 - age;
    return `${firstName} retires in ${retirement}`;
}

console.log(yearsUntilRetirement(2001, 'Neil'));



// I try on my own
const currentAge = function (birthYear, firstName, lastName) {
    let age = 2024 - birthYear;
    let result = age >= 18 ? 'valid' : 'invalid';
    let yearWord = age >= 2 ? 'years' : 'year';
    let sentence = `Hi ${firstName} ${lastName}, you are ${result} bacause you are ${age} ${yearWord} old`
    return (sentence);
}

console.log(currentAge(2023, 'Neil', 'Miclat'));


const fruitPieces = function (fruit) {
    return fruit * 4;
}

const fruitProcessor = function (apples, oranges) {
    let cuttedApples = fruitPieces(apples);
    let cuttedOranges = fruitPieces(oranges);
    const juice = `Juice with ${cuttedApples} apples and ${cuttedOranges} oranges`;
    return juice;
}

console.log(fruitProcessor(1, 2));




const myAge = function (myBirthYear) {
    return 2024 - myBirthYear;
}

const yearsUntilRetirement = function (birthYear, firstName) {
    const age = myAge(birthYear);
    const retirement = 60 - age;

    if (retirement > 0) {
        console.log(`${firstName} has ${retirement} years to retire.`);
        return retirement;
    } else {
        console.log(`${firstName} is already retired.`);
        return -1;
    }

}

yearsUntilRetirement(2001, "Neil");
yearsUntilRetirement(1930, "pogi");



const friends = ['Michael', 'Steven', 'Peter'];
console.log(friends);

const year = new Array(2001, 2002, 2003, 2004);
console.log(year);

console.log(friends[0]);
console.log(friends[2]);

console.log(friends.length);
console.log(friends[friends.length - 1]);

friends[2] = 'Neil';
console.log(friends);


const firstName = 'Neil'

const neil = [firstName, 'Miclat', 2024 - 2001, 'Programmer', friends]
console.log(neil);

// Exercise

const calAge = function (birthYear) {
    return 2024 - birthYear;
}

const years = [2001, 2002, 2003, 2004];

const age1 = calAge(years[0]);
const age2 = calAge(years[1]);
const age3 = calAge(years[years.length - 1]);

console.log(age1, age2, age3);

const ages = [calAge(years[0]), calAge(years[1]), calAge(years[years.length - 1])];
console.log(ages);

const agess = year.map(calAge);

console.log(agess);

// I just want to recall the use of function

const myOrder = function (howManyApples, howManyOranges) {

    const wantApple = prompt('Do you like apple?');
    const wantOrange = prompt('Do you like orange?');

    if (wantApple == 'Yes' || wantApple == 'yes') {
        howManyApples = prompt('How many apples?');
    } else {
        howManyApples = 0
    }

    if (wantOrange == 'Yes' || wantOrange == 'yes') {
        howManyOranges = prompt('How many oranges?');
    } else {
        howManyOranges = 0
    }

    return fruitProcessor(howManyApples, howManyOranges);
}

const fruitProcessor = function (apples, oranges) {

    let appleWord, orangeWord;
    if (apples <= 1) {
        appleWord = 'apple';
    } else {
        appleWord = 'apples';
    }

    if (oranges <= 1) {
        orangeWord = 'orange';
    } else {
        orangeWord = 'oranges';
    }

    const myFruit = alert(`You have ordered ${apples} ${appleWord} and ${oranges} ${orangeWord}. Thank you!`);
    return myFruit;
}

myOrder();


// Basic Operations in Array

const friends = ['Michael', 'Steven', 'Peter'];

// Add Elements in Array
friends.push('Jay');
console.log(friends);

friends.unshift('John');
console.log(friends);

// Remove Array
friends.pop(); //It will remove the last part of the Array
console.log(friends);

friends.shift(); //It will remove the first part
console.log(friends);

console.log(friends.indexOf('Steven'));
console.log(friends.indexOf('Bob'));

console.log(friends.includes('Steven'));
console.log(friends.includes('Bob'));

if (friends.includes('Steven')) {
    console.log('You have a friend called Steven');
}



// Object

const neil = {
    firstName: 'Neil',
    lastName: 'Miclat',
    birthYear: 2001,
    job: 'Full Stack Developer',
    friends: ['Michael', 'Peter', 'Steven'],
    hasDriversLicense: true,


    // clacAge: function (birthYear) {
    //     return 2024 - birthYear;
    // }

    // clacAge: function () {
    //     return 2024 - this.birthYear;
    // }

    clacAge: function () {
        this.age = 2024 - this.birthYear;
        return this.age;
    },

    calcDL: function () {
        if (this.hasDriversLicense) {
            this.resultForDL = `He has a driver's license.`
        } else {
            this.resultForDL = `He don't have a driver's license.`
        }

        return this.resultForDL;
    },

    getSummary: function () {
        return `${this.firstName} is a ${this.clacAge()}-years old ${this.job}, and he has ${this.hasDriversLicense ? 'a' : 'no'} driver's license.`
    }


};

neil.getSummary();

console.log(neil.getSummary());



// Dots vs Brackets

// console.log(neil);

// console.log(neil.lastNAme); //Dots

// console.log(neil['firstName']); //Brackets

// const nameKey = 'Name';

// console.log(neil['first' + nameKey]);
// console.log(neil['last' + nameKey]);

// console.log(neil['first' + nameKey], neil['last' + nameKey]);


// // const interestedIn = prompt('What do you want to know about Neil? Choose between firstname, lastname, age, job, and friends.')

// // if (neil[interestedIn]) {
// //     console.log(neil[interestedIn]);
// // } else {
// //     console.log('Wrong request! Choose between firstname, lastname, age, job, and friends.');
// // }

neil.clacAge();
neil.calcDL();


// console.log(neil.age);

// Challenge
// console.log(`${neil.firstName} has ${neil['friends'].length} friends, and his best friend is called ${neil['friends'][0]}`);

// Another Challenge
// "Neil is a 23-years old Full Stack Developer, and he has a driver's license"

// console.log(`${neil.firstName} is a ${neil.age}-years old ${neil.job}, and ${neil.resultForDL}`);




// LOOPS

// For loop keeps running while the condition is true.
for (let rep = 1; rep <= 10; rep++) {
    console.log(`Lifting weights repitition ${rep}`);
}

const neilArray = [
    'Neil',
    'Miclat',
    2024 - 2001,
    'Developer',
    ['Michael', 'Peter', 'Steven'],
    true
];

const types = [];

for (let i = 0; i < neilArray.length; i++) {
    console.log(neilArray[i]);

    types.push(typeof neilArray[i]);

}

console.log(types);

const birthYear = [1991, 2007, 1969, 2020];
const ages = [];

for (let i = 0; i < birthYear.length; i++) {
    ages.push(2037 - birthYear[i])

}
console.log(ages);


// Continue and break.
console.log(`-- ONLY STRING --`);
for (let i = 0; i < neilArray.length; i++) {

    if (typeof neilArray[i] !== 'string') continue;
    console.log(neilArray[i]);

}

console.log(`-- BREAL WITH NUMBER --`);
for (let i = 0; i < neilArray.length; i++) {

    if (typeof neilArray[i] === 'number') break;
    console.log(neilArray[i]);

}


const neilArray = [
    'Neil',
    'Miclat',
    2024 - 2001,
    'Developer',
    ['Michael', 'Peter', 'Steven'],
    true
];

for (let i = neilArray.length - 1; i >= 0; i--) {
    console.log(neilArray[i]);
}

for (let exercise = 1; exercise < 4; exercise++) {
    console.log(`-- EXERCISE ${exercise} --`);

    for (let rep = 1; rep < 6; rep++) {
        console.log(`EXERCISE ${exercise}: Repition #${rep}!`);
    }
}




// let rep = 1;
// while (rep <= 10) {
//     console.log(`Repeat it! ${rep}`);
//     rep++;
// }

let dice = Math.trunc(Math.random() * 6) + 1;


while (dice !== 6) {
    console.log(`You rolled a ${dice}!`);
    dice = Math.trunc(Math.random() * 6) + 1;
    if (dice === 6) console.log(`YOU GOT THE NUMBER 6`)

}

*/