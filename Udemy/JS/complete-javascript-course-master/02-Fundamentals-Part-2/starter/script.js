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

*/

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

