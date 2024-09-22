/*
let js = "amazing";
console.log(40 + 8 + 23 - 10);

let firstName = "Neil";
console.log(firstName);

let myFirstJob = "Programmer";
let myCurrentJob = "Unemployed";

console.log(myCurrentJob);


let javascriptIsFun = true;
console.log(javascriptIsFun);

console.log(typeof true);
console.log(typeof javascriptIsFun);
console.log(typeof 99);
console.log(typeof 'jason');

const birthYear = 2001;
console.log(birthYear);



// Math Operators
const now = "2024"
const ageNeil = now - 2001;
const ageBea = now - 2000;
console.log(ageNeil, ageBea);

console.log(ageNeil * 2, ageNeil / 2, ageNeil + 2, 2 ** 3)
// 2 ** 3 means, 2 to the power of 3, which is 2 x 2 = 4 x 2 = 8.

const firstName = "Neil";
const lastName = "Miclat";

console.log(firstName + " " + lastName);

// Assignment Operators
let x = 10 + 5; // 15
x += 10; // x = x(15) + 10 = 25
x *= 4; // x = x(25) * 4 = 100
x++; // x = x(100) + 1 = 101
x--; // x = x(101) - 1 = 100

console.log(x);

// Comparison Operators
console.log(ageNeil > ageBea); //Neil(23) is older than Bea(24)? False.
console.log(ageNeil < ageBea); //Neil(23) is younger than Bea(24)? True.

const ageLimit = 21;
console.log(ageNeil >= ageLimit); //Neil is older or Equal to the age limit? True

const ageDeiDei = 16;
console.log(ageDeiDei >= ageLimit); //Deidei is passed the age limit? False



const now = "2024"
const ageNeil = now - 2001;
const ageBea = now - 2000;

console.log(now - 1991 > now - 2018);

let x, y;
x = y = 25 - 10 - 5; // x = y = 10
console.log(x, y);

const averageAge = (ageNeil + ageBea) / 2;
console.log(averageAge);



const firstName = "Neil Joshua";
const middleName = "P.";
const lastName = "Miclat";
const job = "Full Stack Developer";
const birthYear = "2001";
const nowYear = "2024";

const myInfo = "My Name is " + firstName + " " + middleName + " " + lastName + ", " + "I'm a " + (nowYear - birthYear) + " years old " + job;
console.log(myInfo);

const myNewInfo = `My name is ${firstName} ${middleName} ${lastName}, I'm ${(nowYear - birthYear)} years old ${job}.`;
console.log(myNewInfo);

console.log('String \n\
with \n\
multiple \n\
lines');

console.log(`This
is
the
best
way
to
use
multiple
lines.`);



// If else
const myName = "Neil";
let age = "16";
let yearsLeft = 18 - age;
let years;

if (yearsLeft >= 2) {
    years = "years"
} else {
    years = "year"
}

if (age >= 18) {
    console.log(`Hi ${myName}, you are valid to have a driving license.`)

} else {
    console.log(`We're sorry ${myName}, but you have still ${yearsLeft} ${years} to be vilid on having a driver's license.`);
}



let yearNow = "1400";

if (yearNow >= 2000) {
    console.log('20 Century');
} else if (yearNow >= 1900) {
    console.log('19 Century');
} else if (yearNow >= 1800) {
    console.log('18 Century');
} else if (yearNow >= 1700) {
    console.log('17 Century');
} else if (yearNow >= 1600) {
    console.log('16 Century');
} else if (yearNow >= 1500) {
    console.log('15 Century');
} else if (yearNow >= 1400) {
    console.log('14 Century');
} else if (yearNow <= 1399) {
    console.log('Below 13 Century is Invalid');
}


// Type Conversion
const inputYear = "2024"; // The input year is a String

console.log(inputYear + 1); // 2024(string) + 1 = 2025
console.log(Number(inputYear) + 1); // I change the data type to number
console.log(String(24), 24);

// Type Coercion
console.log('I am ' + 23 + ' years old');
console.log('23' + '10' + 3);
console.log('23' - '10' - 3);
console.log('23' * '2');
console.log('23' / '2');

let n = '1' + 1; // 11
n = n - 1; // 10
console.log(n);



//Truely and Falsy
//There are 5 Falsy values = 0, '', undefined, null, NaN.

console.log(Boolean(0));
console.log(Boolean(undefined));
console.log(Boolean("Jonas"));
console.log(Boolean({}));
console.log(Boolean(""));

const money = 0;
if (money) {
    console.log("Dont spend it all");
} else {
    console.log("GET A JOB!");
}

let height;
if (height) {
    console.log("height is defined");
} else {
    console.log("height is undefined");
}



//Equality operator == vs ===

let age = '23';

if (age == 23) console.log("You are 23. (loose)");
if (age === 23) console.log("You are 23. (strict)");

const yourNumber = prompt("What is your favorite number?") // The number will you input to the prompt will be string.

if (yourNumber == "23") {
    console.log(yourNumber, typeof yourNumber);
}

const yourNumber2 = Number(prompt("What is your favorite number?"))  // This is the best way to make the input number into a number data type

if (yourNumber2 === 23) {
    console.log(yourNumber2, typeof yourNumber2);
}

*/

let answer = prompt(`What is the name of Neil's girlfriend?
    A. Beatrice
    B. Allaine`);

if (answer == "B") {
    console.log("You got it right! Beatrice, is the correct answer!");
} else if (answer == "A") {
    console.log("You got it right! Allaine, is the correct answer!");
} else {
    console.log("A and B are just both correct, but still you did not choose from two? NOOB!");
}