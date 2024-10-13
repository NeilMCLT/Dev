'use strict';

//Selector
const todoInput = document.querySelector('.todo-input');
const todoButton = document.querySelector('.todo-button');
const todoList = document.querySelector('.todo-list');

// Event Listeners
todoButton.addEventListener('click', addTodo);

// Functions
function addTodo(event) {

    //Prevent form from submitting
    event.preventDefault();

    //This will create a new div
    const todoDiv = document.createElement("div");
    todoDiv.classList.add("todo");

    // This will create a LI inside the new div
    const newTodo = document.createElement('li');
    newTodo.innerText = 'hey';
    newTodo.classList.add('todo-item');
    todoDiv.appendChild(newTodo)

    //This will create a check button inside of each LI
    const completedButton = document.createElement('button');
    completedButton.innerHTML = '<i class="fas fa-check"></i>'
    completedButton.classList.add('complete-btn');
    todoDiv.appendChild(completedButton);

    //This will create a trash button inside of each LI
    const trashButton = document.createElement('button');
    trashButton.innerHTML = '<i class="fas fa-trash"></i>'
    trashButton.classList.add('trash-btn');
    todoDiv.appendChild(trashButton);

    // This will append as a child of .todo-list
    todoList.appendChild(todoDiv);
}