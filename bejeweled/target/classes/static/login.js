const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");

if(signupBtn!=null && loginBtn!=null && signupLink!=null) {
    const loginInputs =  document.querySelectorAll('input.loginT');
    const passInputs =  document.querySelectorAll('input.password');
    signupBtn.onclick = (() => {
        loginForm.style.marginLeft = "-50%";
        loginText.style.marginLeft = "-50%";
        loginInputs.forEach(loginInput => {
            loginInput.style.borderColor = '';
            loginInput.value = "";
        });
        passInputs.forEach(passInput => {
            passInput.style.borderColor = '';
            passInput.value = "";
        });
    });
    loginBtn.onclick = (() => {
        loginForm.style.marginLeft = "0%";
        loginText.style.marginLeft = "0%";
        loginInputs.forEach(loginInput => {
            loginInput.value = "";
            loginInput.style.borderColor = '';
        });
        passInputs.forEach(passInput => {
            passInput.style.borderColor = '';
            passInput.value = "";
        });
    });
    signupLink.onclick = (() => {
        signupBtn.click();
        return false;
    });
}

const playBtn = document.getElementById('play-btn');
if(playBtn!=null) {
    playBtn.addEventListener('click', () => {
        window.location.href = '/api/bejeweled';
    });
}

const exit = document.getElementById('logout-btn');
if(exit!=null) {
    exit.addEventListener('click', () => {
        window.location.href = '/api/logout';
    });
}


const loginInputs =  document.querySelectorAll('input.loginT');
const passInputs =  document.querySelectorAll('input.password');

passInputs.forEach(passInput => {
    passInput.addEventListener('input', passOnInput);
});

loginInputs.forEach(loginInput => {
    loginInput.addEventListener('input', onInput);
});

const LOGIN_REGEXP = /^(?![0-9]+$)[a-zA-Z0-9]{4,8}$/;

function onInput() {
    loginInputs.forEach(loginInput => {
        if (isEmailValid(loginInput.value)) {
            loginInput.style.borderColor = 'green';
        } else {
            loginInput.style.borderColor = 'red';
        }
    });

}
function passOnInput(){
    passInputs.forEach(passInput => {
        if (isEmailValid(passInput.value)) {
            passInput.style.borderColor = 'green';
        } else {
            passInput.style.borderColor = 'red';
        }
    });
}
function isEmailValid(value) {
    return LOGIN_REGEXP.test(value);
}


const logBtn = document.querySelector('input.loginBtn'); // отримуємо кнопку з класом 'loginBtn'
const regBtn = document.querySelector('input.regBtn'); // отримуємо кнопку з класом 'regBtn'

const loginInput = document.querySelector('input.loginT');
const passwordInput = document.querySelector('input.password');

logBtn.addEventListener('click', () => {
    if(loginInput.style.borderColor==='red' || loginInput.value.length===0)
    {
        alert('Check your login');
        return;
    }

    if(passwordInput.style.borderColor==='red' || passwordInput.value.length===0)
    {
        alert('Check your password');
        return;
    }

    const data = {
        login: loginInput.value,
        password: passwordInput.value
    };

    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            alert('Successful login');
            window.location.replace("/api/bejeweled");
            // виконуємо дії з отриманими даними
        })
        .catch(error => {
            alert('Invalid login or password');
        });

});

const loginInputR = document.querySelector("input.loginT[name='loginR']");
const passwordInputR = document.querySelector("input.password[name='passR']");
const confirmPasswordInput = document.querySelector("input.password[name='passConf']");

regBtn.addEventListener('click', () => {
    if(loginInputR.style.borderColor==='red' || loginInputR.value.length===0)
    {
        alert('Check your login');
        return;
    }

    if(passwordInputR.style.borderColor==='red' || passwordInputR.value.length===0)
    {
        alert('Check your password');
        return;
    }

    if (passwordInputR.value !== confirmPasswordInput.value) {
        alert('Passwords don\'t match');
    }

    const data = {
        login: loginInputR.value,
        password: passwordInputR.value
    };

    fetch('/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            alert('Successful registration');
            window.location.replace("/api/bejeweled");
            // виконуємо дії з отриманими даними
        })
        .catch(error => {
            alert('The user exists');
        });

});

document.addEventListener('keydown', function(event) {
    if (event.key === 'Tab') {
        event.preventDefault();
    }
});





