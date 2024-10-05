// Remember, we're gonna use strict mode in all scripts now!
'use strict';

// const x = 24;
// if (x === 24) console.log(23);

// const calAge = birthYear => 2024 - birthYear;

// Problem 1

/*
const temperature = [3, -2, -6, -1, 'error', 9, 13, 17, 15, 14, 9, 5];


const calcTempAplitude = function (temps) {
    let max = temps[0];
    let min = temps[0];


    for (let i = 0; i < temps.length; i++) {
        const curTemp = temps[i];
        if (typeof curTemp !== 'number') continue;
        if (curTemp > max) max = curTemp;
        if (curTemp < min) min = curTemp;
    }
    console.log(min, max);
    return max - min;
}

const amplitude = calcTempAplitude(temperature);

console.log(amplitude);

//Problem 2


const temperature1 = [3, -2, -6, -1, 'error', 9, 13, 17, 15, 14, 9, 5];
const temperature2 = [13, 51, 34, 76, 14, 75, 18, 3, 56, 7, 21];
const temperature3 = temperature1.concat(temperature2);



const calcTempAplitudeNew = function (temps) {
    let max = temps[0];
    let min = temps[0];


    for (let i = 0; i < temps.length; i++) {
        const curTemp = temps[i];
        if (typeof curTemp !== 'number') continue;
        if (curTemp > max) max = curTemp;
        if (curTemp < min) min = curTemp;
    }
    console.log(min, max);
    return max - min;
}

const amplitudeNew = calcTempAplitudeNew(temperature3);

console.log(amplitudeNew);


const measureKelvin = function () {
    const measurement = {
        type: 'temp',
        unit: 'celsius',
        value: Number(prompt('Degrees celsius')),
    };

    const kelvin = measurement.value + 273
    return kelvin;
}

console.log(measureKelvin());
*/

// Challenge 1


const data1 = [17, 21, 23];
const data2 = [12, 5, -5, 0, 4];

const printForcast = function (arr) {

    let str = '';
    let day;
    for (let i = 0; i < arr.length; i++) {
        if (i == 0 ? day = 'day' : day = 'days')
            str = str + `${arr[i]}C in ${i + 1} ${day} ... `
    }
    console.log('... ' + str);
}
printForcast(data2);



