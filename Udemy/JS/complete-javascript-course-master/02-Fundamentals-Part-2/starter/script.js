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

*/

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