'use strict';

/*
console.log(document.querySelector('.message').textContent);

document.querySelector('.message').textContent = 'Correct Number!'

console.log(document.querySelector('.message').textContent);

document.querySelector('.number').textContent = 13;
document.querySelector('.score').textContent = 10;

document.querySelector('.guess').value = 23;

console.log(document.querySelector('.guess').value);
*/

let secretNumber = Math.trunc(Math.random() * 20) + 1;
let score = 20;
console.log(secretNumber);
let highScore = 0;

// Display the message of start guessing, no number, too low, too high
const displayMessage = function (message) {
    document.querySelector('.message').textContent = message;
}

// Changing the background color of the body
const changeBackgroundColor = function (theColor) {
    document.querySelector('body').style.backgroundColor = theColor;
}

document.querySelector('.check').addEventListener('click',
    function () {
        const guess = Number(document.querySelector('.guess').value);
        console.log(typeof guess, guess);

        // When there is no input
        if (!guess) {
            displayMessage('No Number!');

            // When you got the correct number
        } else if (guess === secretNumber) {
            displayMessage('Correct Number!');
            changeBackgroundColor('#60b347');
            document.querySelector('.number').style.width = '30rem';
            document.querySelector('.number').textContent = secretNumber;

            if (score > highScore) {
                highScore = score;
                document.querySelector('.highscore').textContent = highScore;
            }

            // When the guess number is wrong
        } else if (guess !== secretNumber) {

            if (score > 1) {
                displayMessage(guess > secretNumber ? 'Too High!' : 'Too Low!');
                score--;
                document.querySelector('.score').textContent = score;

            } else {
                displayMessage('You lost the game!');
                document.querySelector('.score').textContent = 0;
                changeBackgroundColor('#ff6633');
            }


            // When the number is higher
            // } else if (guess > secretNumber) {

            //     if (score > 1) {
            //         document.querySelector('.message').textContent = 'Too High!';
            //         score--;
            //         document.querySelector('.score').textContent = score;
            //     } else {
            //         document.querySelector('.message').textContent = 'You lost the game!';
            //         document.querySelector('.score').textContent = 0;
            //     }

            //     // When the number is lower
            // } else if (guess < secretNumber) {

            //     if (score > 1) {
            //         document.querySelector('.message').textContent = 'Too Low!';
            //         score--;
            //         document.querySelector('.score').textContent = score;
            //     } else {
            //         document.querySelector('.message').textContent = 'You lost the game!';
            //         document.querySelector('.score').textContent = 0;
            //     }
        }
    }
)

document.querySelector('.again').addEventListener('click', function () {
    score = 20;
    displayMessage('Start guessing...');
    document.querySelector('.score').textContent = score;
    changeBackgroundColor('#222');
    document.querySelector('.number').style.width = '15rem';
    document.querySelector('.guess').value = '';
    document.querySelector('.number').textContent = '?';
    secretNumber = Math.trunc(Math.random() * 20) + 1;
    console.log(secretNumber);

})