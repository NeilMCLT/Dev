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

*/

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