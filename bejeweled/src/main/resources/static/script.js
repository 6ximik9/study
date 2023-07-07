let selectedCell = null;
let data = null;
let user = null;
let startTime = 120; // Таймер на хвилину (60 секунд)
let timeLeft = startTime;
let score = 0;
let level = 1;

fetch('/api/bejeweled/player')
    .then(response => response.json())
    .then(player => {
        // alert();
        user = player.login;
        const scoreElement = document.getElementById('player');
        scoreElement.textContent = `🎮Player: ${user}`;
    })
    .catch(error => {
        console.error('Error:', error);
    });

// Оновлення таймера на сторінці
function updateTimer() {
    const timerElement = document.getElementById('timer');
    timerElement.textContent = `⏳Time: ${timeLeft}s`;
}

// Оновлення очків на сторінці
function updateScore() {
    const scoreElement = document.getElementById('score');
    scoreElement.textContent = `✨Score: ${score}`;
}


// Функція для початку гри
function startGame() {
    // Оновлюємо таймер та очки на сторінці
    setCommentsTable()
    setScoreTable();
    updateTimer();
    updateScore();
    generateBoard();
    const gameBoard = document.getElementById('game-board');
    gameBoard.classList.add('disabled');
    gameBoard.style.pointerEvents = "none";

}

startGame();

function getARating() {
    fetch('/api/bejeweled/ratingGame')
        .then(response => response.text())
        .then(rating => {
            // alert("Рейтинг гри: " + rating);
            const ratingInput = document.querySelector('#simple-rating_' + rating + '-show');
            ratingInput.checked = true; // встановлюємо атрибут checked в true
        });
}

function setScoreTable() {
    fetch('/api/bejeweled/score')
        .then(response => response.json())
        .then(scores => {
            const ratingTable = document.querySelector('#rating');
            // console.info(scores);

            ratingTable.innerHTML = '';

            // Створюємо рядок заголовків таблиці
            const headerRow1 = ratingTable.insertRow();
            const commentsHeader = headerRow1.insertCell();
            commentsHeader.innerText = '⭐️Best players⭐️';
            commentsHeader.colSpan = 3;
            commentsHeader.style.fontWeight = 'bold';

            const headerRow2 = ratingTable.insertRow();
            const userHeader = headerRow2.insertCell();
            userHeader.innerText = 'Player';
            const dateHeader = headerRow2.insertCell();
            dateHeader.innerText = 'Date';
            const scoreHeader = headerRow2.insertCell();
            scoreHeader.innerText = 'Score';
            // пройдемо по кожному рядку в масиві рекордів та додамо його до таблиці
            let i = 1;
            scores.forEach(score => {
                const row = ratingTable.insertRow();
                const userCell = row.insertCell();
                userCell.innerText = '🎖' + score.player;
                if(i===1) {
                    userCell.innerText = '🥇' + score.player;
                }
                else if(i === 2) {
                    userCell.innerText = '🥈' + score.player;
                }
                else if(i===3)
                {
                    userCell.innerText = '🥉' + score.player;
                }
                userCell.style.whiteSpace = 'nowrap';
                const dateCell = row.insertCell();
                const date = new Date(score.playedOn).toLocaleString().split(',')[0];
                dateCell.innerText = date;
                const scoreCell = row.insertCell();
                scoreCell.innerText = score.points;
                i++;
            });
        });
}

function setCommentsTable() {
    getARating();
    fetch('/api/bejeweled/comments')
        .then(response => response.json())
        .then(comments => {

            // Отримуємо елементи з DOM
            var modal = document.getElementById("myModal");
            var btn = document.getElementById("modal-review");
            var span = document.getElementsByClassName("close")[0];

            // Додаємо подію кліку на кнопку
            btn.onclick = function () {
                modal.style.display = "block";
            }

            // Додаємо подію кліку на хрестик закриття
            span.onclick = function () {
                modal.style.display = "none";
            }

            // Додаємо подію кліку на затемнену область
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }

            const commentsTable = document.getElementById('sendData');

            commentsTable.addEventListener('click', function (event) {
                const commentInput = document.getElementById('textComment');
                const comment = commentInput.value;
                const radioButtons = document.getElementsByName("simple-rating");
                let selectedValue = "";
                for (let i = 0; i < radioButtons.length; i++) {
                    if (radioButtons[i].checked) {
                        selectedValue = radioButtons[i].value;
                        break;
                    }
                }
                if (selectedValue !== "") {
                    fetch("/api/bejeweled/setRating", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify({rating: selectedValue})
                    }).then(response => {
                        if (!response.ok) {
                            throw new Error("Network response was not ok");
                        }
                    });
                    if (comment.trim() === "") {
                        alert("Successful");
                        modal.style.display = "none";
                    }
                    getARating();
                    const radioButtons = document.querySelectorAll('.simple-rating_item');
                    radioButtons.forEach(button => button.checked = false);
                } else {
                    alert("Choose a rating");
                    return;
                }

                if (comment.trim() === "") {
                    // alert("Текстове поле порожнє! Будь ласка, введіть текст.");
                } else {
                    fetch("/api/bejeweled/addComment", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify({comment: comment})
                    })
                        .then(response => {
                            if (!response.ok) {
                                throw new Error("Network response was not ok");
                            }
                            const commentsTable = document.getElementById("comments");
                            const newRow = commentsTable.insertRow(-1);
                            const cell1 = newRow.insertCell(0);
                            const cell2 = newRow.insertCell(1);
                            const cell3 = newRow.insertCell(2);
                            cell1.innerHTML = user;

                            const currentDate = new Date();
                            const day = String(currentDate.getDate()).padStart(2, '0');
                            const month = String(currentDate.getMonth() + 1).padStart(2, '0');
                            const year = currentDate.getFullYear();
                            const formattedDate = `${day}.${month}.${year}`;
                            cell2.innerHTML = formattedDate;
                            cell3.innerHTML = comment;
                            commentInput.value = "";
                            alert('Successful');
                            modal.style.display = "none";
                        });
                }

            });

            // console.info(comments);
            const table = document.querySelector('#comments');

            // console.info(comments);

            // Очищаємо таблицю перед додаванням нових даних
            table.innerHTML = '';

            // Створюємо рядок заголовків таблиці
            const headerRow1 = table.insertRow();
            const commentsHeader = headerRow1.insertCell();
            commentsHeader.innerText = '📨Comments📨';
            commentsHeader.colSpan = 3;
            commentsHeader.style.fontWeight = 'bold';

            const headerRow2 = table.insertRow();
            const userHeader = headerRow2.insertCell();
            userHeader.innerText = 'Player';
            const dateHeader = headerRow2.insertCell();
            dateHeader.innerText = 'Date';
            const scoreHeader = headerRow2.insertCell();
            scoreHeader.innerText = 'Comment';

            comments.forEach(comment => {
                const row = table.insertRow();
                const playerCell = row.insertCell();
                playerCell.innerText = comment.player;
                const dateCell = row.insertCell();
                dateCell.innerText = new Date(comment.commentedon).toLocaleString().split(',')[0];
                const commentCell = row.insertCell();
                commentCell.innerText = comment.comment;
            });
        });
}

function generateBoard() {
    fetch('/api/bejeweled/board')
        .then(response => response.json())
        .then(boardData => {
            data = boardData; // зберігаємо дані у змінну
            const table = document.getElementById('game-board');
            for (let i = 0; i < data.length; i++) {
                const row = table.insertRow();
                for (let j = 0; j < data[i].length; j++) {
                    const cell = row.insertCell();
                    cell.classList.add(`cell-${data[i][j]}`);
                    cell.addEventListener('click', handleCellClick);
                }
            }
            console.info(data);
            updateGameBoard();
        })
        .catch(error => console.error(error));
}





// Функція для обміну елементів місцями в масиві даних
function swapElementsInArray(arr, i1, j1, i2, j2) {
    const temp = arr[i1][j1];
    arr[i1][j1] = arr[i2][j2];
    arr[i2][j2] = temp;
    // console.info('swap');
    // console.info(data);
}
// Функція для перевірки того, чи є дві клітинки сусідніми
function isAdjacent(i1, j1, i2, j2) {
    return (Math.abs(i1 - i2) + Math.abs(j1 - j2)) === 1;
}


// Функція-слухач події кліку на комірці таблиці
async function handleCellClick(event) {
    const cell = event.target;
    const i = cell.parentElement.rowIndex;
    const j = cell.cellIndex;

    if (selectedCell) {
        const prevI = selectedCell.parentElement.rowIndex;
        const prevJ = selectedCell.cellIndex;
        if (isAdjacent(i, j, prevI, prevJ)) {
            const distanceX = (j - prevJ) * cell.clientWidth;
            const distanceY = (i - prevI) * cell.clientHeight;

            // Змінюємо класи перед переміщенням
            const prevCellClass = selectedCell.className;
            selectedCell.className = cell.className;
            cell.className = prevCellClass;

            cell.style.transform = `translate(${-distanceX}px, ${-distanceY}px)`;
            selectedCell.style.transform = `translate(${distanceX}px, ${distanceY}px)`;

            // Застосовуємо анімацію
            cell.classList.add("cell-moving");
            selectedCell.classList.add("cell-moving");

            // Чекаємо кінець анімації переміщення
            await new Promise((resolve) => requestAnimationFrame(resolve));

            cell.style.transform = "";
            selectedCell.style.transform = "";

            // Закінчуємо анімацію
            await new Promise((resolve) => requestAnimationFrame(resolve));

            if (data !== null) {
                swapElementsInArray(data, i, j, prevI, prevJ);
                const matchesFound = removeMatches();
                if (!matchesFound) {
                    await new Promise((resolve) => requestAnimationFrame(resolve));
                    cell.classList.remove("cell-moving");
                    selectedCell.classList.remove("cell-moving");
                    const tempClass = selectedCell.className;
                    selectedCell.className = cell.className;
                    cell.className = tempClass;

                    cell.style.transform = `translate(${-distanceX}px, ${-distanceY}px)`;
                    selectedCell.style.transform = `translate(${distanceX}px, ${distanceY}px)`;

                    // Застосовуємо анімацію
                    cell.classList.add("cell-moving");
                    selectedCell.classList.add("cell-moving");

                    // Чекаємо кінець анімації переміщення
                    await new Promise((resolve) => requestAnimationFrame(resolve));

                    cell.style.transform = "";
                    selectedCell.style.transform = "";

                    // Закінчуємо анімацію
                    await new Promise((resolve) => requestAnimationFrame(resolve));
                    cell.classList.remove("cell-moving");
                    selectedCell.classList.remove("cell-moving");
                    swapElementsInArray(data, i, j, prevI, prevJ);
                    if(level===2 && score>=25)
                    {
                        score = score - 25;
                    }
                    else if(level===2 && score<25)
                    {
                        score = 0;
                    }
                    else if(level===3 && score>=50)
                    {
                        score = score - 50;
                    }
                    else if(level===3 && score<50)
                    {
                        score = 0;
                    }
                    updateScore();
                    // console.info(data);
                } else {
                    console.info(data);
                }
            }
            // Зняття виділення з обраної комірки
            selectedCell.classList.remove("selected");
            selectedCell = null;
        } else {
            // Зняття виділення з обраної комірки
            selectedCell.classList.remove("selected");
            selectedCell = null;
            // Виділення обраної комірки
            selectedCell = cell;
            cell.classList.add("selected");
        }
    } else {
        // Виділення обраної комірки
        selectedCell = cell;
        cell.classList.add("selected");
    }
}


function removeMatches() {
    const table = document.getElementById('game-board');
    const cellsToAnimate = [];
    let matchesCount = 0;
    let matchesFound = false;

    let numRow = 1;
    // Перевірка горизонтальних ліній
    for (let i = 0; i < data.length; i++) {
        let j = 0;
        while (j < data[i].length - 2) {
            if (data[i][j] !== null && data[i][j] === data[i][j + 1] && data[i][j] === data[i][j + 2]) {
                let k = j + 2;
                while (k < data[i].length && data[i][k] === data[i][j]) {
                    k++;
                }
                for (let l = j; l < k; l++) {
                    numRow = data[i][l]+1;
                    data[i][l] = null;
                    matchesCount++;
                    matchesFound = true;
                }
                j = k;
            } else {
                j++;
            }
        }
    }
    let numCol = 1;
    // Перевірка вертикальних ліній
    for (let j = 0; j < data[0].length; j++) {
        let i = 0;
        while (i < data.length - 2) {
            if (data[i][j] !== null && data[i][j] === data[i + 1][j] && data[i][j] === data[i + 2][j]) {
                let k = i + 2;
                while (k < data.length && data[k][j] === data[i][j]) {
                    k++;
                }
                for (let l = i; l < k; l++) {
                    numCol = data[l][j]+1;
                    data[l][j] = null;
                    matchesCount++;
                    matchesFound = true;
                }
                i = k;
            } else {
                i++;
            }
        }
    }


    // alert(matchesCount * numCol * numRow);
    score += matchesCount * numCol * numRow * level;

    updateScore();
    for (let i = 0; i < data.length; i++) {
        for (let j = 0; j < data[i].length; j++) {
            if (data[i][j] === null) {
                cellsToAnimate.push(table.rows[i].cells[j]);
            }
        }
    }

    if (matchesFound) {
        // removeMatches();
        animateRemovedCells(cellsToAnimate, () => {
            generateNewElements();
            updateGameBoard();
            animateNewCells(() => {
                resetRemovedCellsOpacity();
            });
        });
    }

    const combinations = findCombinations(data);
    if (Object.keys(combinations).length === 0) {
        alert('No combinations are available. The field has been updated.');
        const table = document.getElementById('game-board');
        table.innerHTML = '';
        generateBoard();
    }

    return matchesFound;
}

// Функція для генерації нових елементів
function isValidNewElement(row, col, value) {
    // Перевірка горизонтальних співпадінь
    if (col >= 2 && data[row][col - 1] === value && data[row][col - 2] === value) {
        return false;
    }
    // Перевірка вертикальних співпадінь
    if (row >= 2 && data[row - 1][col] === value && data[row - 2][col] === value) {
        return false;
    }

    return true;
}

function generateNewElements() {
    for (let j = 0; j < data[0].length; j++) {
        let i = data.length - 1;
        while (i >= 0) {
            if (data[i][j] === null) {
                let newValue;
                do {
                    newValue = Math.floor(Math.random() * 7) + 1; // Генеруємо випадкове число від 1 до 7
                } while (!isValidNewElement(i, j, newValue));

                data[i][j] = newValue;
            }
            i--;
        }
    }
}


function animateRemovedCells(cells, callback) {
    let animatedCount = 0;

    cells.forEach(cell => {
        cell.style.transition = 'opacity 0.5s';
        cell.style.opacity = 0;
        cell.addEventListener('transitionend', () => {
            animatedCount++;

            if (animatedCount === cells.length) {
                callback();
            }
        }, {once: true});
    });
}


function resetRemovedCellsOpacity() {
    const table = document.getElementById('game-board');
    for (let i = 0; i < data.length; i++) {
        for (let j = 0; j < data[i].length; j++) {
            const cell = table.rows[i].cells[j];
            cell.style.opacity = 1;
            cell.style.transition = '';
        }
    }
}

function updateGameBoard() {
    const table = document.getElementById('game-board');

    table.innerHTML = '';
    for (let i = 0; i < data.length; i++) {
        const row = table.insertRow();
        for (let j = 0; j < data[i].length; j++) {
            const cell = row.insertCell();
            cell.classList.add(`cell-${data[i][j]}`);
            cell.addEventListener('click', handleCellClick);
        }
    }
}

function animateNewCells(callback) {
    const table = document.getElementById('game-board');
    const newCells = [];

    for (let i = 0; i < data.length; i++) {
        for (let j = 0; j < data[i].length; j++) {
            const cell = table.rows[i].cells[j];
            if (cell.style.opacity === '0') {
                newCells.push(cell);
            }
        }
    }

    let animatedCount = 0;

    newCells.forEach(cell => {
        cell.style.transition = 'transform 0.5s, opacity 0.8s';
        cell.style.transform = 'translateY(-100%)';
        cell.style.opacity = '0';
        setTimeout(() => {
            cell.style.transform = 'translateY(0)';
            cell.style.opacity = '1';
            cell.addEventListener('transitionend', () => {
                animatedCount++;

                if (animatedCount === newCells.length) {
                    newCells.forEach(c => c.style.transition = '');
                    callback();
                }
            }, {once: true});
        }, 0);
    });
}

setInterval(function() {
    removeMatches();
}, 1500);


const startBtn = document.getElementById('start-btn');
const logBtn = document.getElementById('log-btn');

let timerInterval;
let isTimerRunning = false;

const gameBoard = document.getElementById('game-board');

startBtn.addEventListener('click', () => {
    if (startBtn.innerText === 'Start over') {
        // location.reload();
        score = 0;
        timeLeft = 120;
        updateTimer();
        updateScore();
        generateBoard();
        setScoreTable();
        setCommentsTable();
        startBtn.innerText = 'Start';
        clearInterval(timerInterval);
        isTimerRunning = false;
        fullscreenDiv.style.display = "flex";
    } else if (!isTimerRunning) {
        // запускаємо таймер, якщо він не запущений
        startBtn.innerText = 'Pause';
        // startGame();
        gameBoard.classList.remove('disabled');
        gameBoard.style.pointerEvents = "auto";
        timerInterval = setInterval(() => {
            timeLeft--;
            updateTimer();
            if (timeLeft <= 0) {
                clearInterval(timerInterval);
                fetch("/api/bejeweled/addScore", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({points: score})
                }).then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                });
                const restart = confirm("Time's up! You have " + score + " points.\n\nWant to start over?");
                if (restart) {
                    // location.reload();
                    setScoreTable();
                    setCommentsTable();
                    score = 0;
                    timeLeft = 120;
                    startBtn.innerText = 'Start';
                    clearInterval(timerInterval);
                    isTimerRunning = false;
                    startGame();
                } else {
                    const gameBoard = document.getElementById('game-board');
                    gameBoard.classList.add('disabled');
                    gameBoard.style.pointerEvents = "none";
                    startBtn.innerText = 'Start over';
                }

            }
        }, 1000);
        isTimerRunning = true;
    } else {
        // призупиняємо таймер, якщо він запущений
        startBtn.innerText = 'Start';
        clearInterval(timerInterval);
        isTimerRunning = false;
        gameBoard.classList.add('disabled');
        gameBoard.style.pointerEvents = "none";
    }
});



logBtn.addEventListener('click', () => {
    window.location.href = '/api/logout';
});


function findCombinations(board) {
    const combinations = [];

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            const cell = board[i][j];

            // Перевіряємо можливі сусідні клітинки
            const neighbors = [                [i - 1, j], // верхня клітина
                [i + 1, j], // нижня клітина
                [i, j - 1], // ліва клітина
                [i, j + 1], // права клітина
            ];

            for (let n = 0; n < neighbors.length; n++) {
                const [ni, nj] = neighbors[n];

                // Перевіряємо, щоб клітина не виходила за межі дошки
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[i].length) {
                    const neighbor = board[ni][nj];

                    // Перевіряємо, щоб сусідня клітина не була поточним елементом
                    if (neighbor !== cell) {
                        // Робимо копію дошки та переміщуємо елемент
                        const newBoard = board.map(row => [...row]);
                        newBoard[i][j] = neighbor;
                        newBoard[ni][nj] = cell;

                        // Перевіряємо, чи утворилася комбінація на новій дошці
                        const newCombinations = findCombinationsOnBoard(newBoard);
                        if (newCombinations.length > 0) {
                            combinations.push([i, j, ni, nj]);
                        }
                    }
                }
            }
        }
    }

    return combinations;
}

function findCombinationsOnBoard(board) {
    const combinations = [];

    // Перебираємо кожну клітинку та її сусідів
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            const cell = board[i][j];

            // Перевіряємо можливі комбінації
            const neighbors = [
                [i, j - 1], // лівий сусід
                [i, j + 1], // правий сусід
                [i - 1, j], // верхній сусід
                [i + 1, j], // нижній сусід
            ];

            for (let n = 0; n < neighbors.length; n++) {
                const [ni, nj] = neighbors[n];

                // Перевіряємо, щоб клітина не виходила за межі дошки
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[i].length) {
                    const neighbor = board[ni][nj];

                    // Перевіряємо, щоб сусідня клітина не була поточним елементом
                    if (neighbor !== cell) {
                        // Перевіряємо можливу комбінацію на знайдених сусідах
                        if (j > 1 && board[i][j - 2] === cell && board[i][j - 1] === cell) {
                            combinations.push([i, j - 2, i, j - 1, i, j]);
                        } else if (j < board[i].length - 2 && board[i][j + 1] === cell && board[i][j + 2] === cell) {
                            combinations.push([i, j, i, j + 1, i, j + 2]);
                        } else if (i > 1 && board[i - 2][j] === cell && board[i - 1][j] === cell) {
                            combinations.push([i - 2, j, i - 1, j, i, j]);
                        } else if (i < board.length - 2 && board[i + 1][j] === cell && board[i + 2][j] === cell) {
                            combinations.push([i, j, i + 1, j, i + 2, j]);
                        }
                    }
                }
            }
        }
    }

    return combinations;
}


const easyBtn = document.getElementById("easy-btn");
const normalBtn = document.getElementById("normal-btn");
const hardBtn = document.getElementById("hard-btn");
const fullscreenDiv =  document.querySelector('.lock');

easyBtn.addEventListener('touchstart', () => {
    fullscreenDiv.style.display = "none";
    level = 1;
});

normalBtn.addEventListener('touchstart', () => {
    fullscreenDiv.style.display = "none";
    level = 2;
});

hardBtn.addEventListener('touchstart', () => {
    fullscreenDiv.style.display = "none";
    level = 3;
});

easyBtn.addEventListener("click", () => {
    fullscreenDiv.style.display = "none";
    level = 1;
});

normalBtn.addEventListener("click", () => {
    fullscreenDiv.style.display = "none";
    level = 2;
});

hardBtn.addEventListener("click", () => {
    fullscreenDiv.style.display = "none";
    level = 3;
});









