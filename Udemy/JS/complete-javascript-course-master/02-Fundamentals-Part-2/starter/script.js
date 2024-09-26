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

*/



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
