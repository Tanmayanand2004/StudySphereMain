const form = document.getElementById('form');
const firstname_input = document.getElementById('firstname-input');
const email_input = document.getElementById('email-input');
const password_input = document.getElementById('password-input');
const repeat_password_input = document.getElementById('repeat-password-input');
const error_message = document.getElementById('error-message');

// Retrieve stored users from localStorage, if available
const getStoredUsers = () => JSON.parse(localStorage.getItem('users')) || [];

// Store users in localStorage
const storeUsers = (users) => {
  localStorage.setItem('users', JSON.stringify(users));
};

form.addEventListener('submit', (e) => {
  let errors = [];

  // If we have a firstname input, it's the signup form
  if (firstname_input) {
    // Validate signup form
    errors = getSignupFormErrors(firstname_input.value, email_input.value, password_input.value, repeat_password_input.value);
  } else {
    // If not, it's the login form
    errors = getLoginFormErrors(email_input.value, password_input.value);
  }

  if (errors.length > 0) {
    // If there are errors, prevent form submission and display errors
    e.preventDefault();
    error_message.innerText = errors.join(". ");
  } else if (firstname_input) {
    // For signup, check if the email is already registered
    const users = getStoredUsers();

    if (users.some(user => user.email === email_input.value)) {
      e.preventDefault();
      errors.push('This email is already registered. Please use another email.');
      error_message.innerText = errors.join(". ");
    } else {
      // If the email is not registered, add the new user to the "database"
      const newUser = {
        firstname: firstname_input.value,
        email: email_input.value,
        password: password_input.value // In real applications, don't store plain passwords
      };

      users.push(newUser); // Add new user to the array
      storeUsers(users); // Save the updated users list to localStorage

      // Redirect after successful signup
      window.location.href = 'homepagehtml.html'; // Redirect to homepage or any page
    }
  } else {
    // If it's the login form, check for the email and password
    const users = getStoredUsers();
    const user = users.find(user => user.email === email_input.value && user.password === password_input.value);

    if (user) {
      // If the user is found and credentials match, redirect to the homepage
      window.location.href = 'homepagehtml.html'; // Redirect to homepage or any page
    } else {
      // If login fails
      e.preventDefault();
      errors.push('Invalid email or password');
      error_message.innerText = errors.join(". ");
    }
  }
});

// Validate the signup form
function getSignupFormErrors(firstname, email, password, repeatPassword) {
  let errors = [];

  if (firstname === '' || firstname == null) {
    errors.push('Firstname is required');
    firstname_input.parentElement.classList.add('incorrect');
  }
  
  if (email === '' || email == null) {
    errors.push('Email is required');
    email_input.parentElement.classList.add('incorrect');
  }

  if (password === '' || password == null) {
    errors.push('Password is required');
    password_input.parentElement.classList.add('incorrect');
  }

  if (password.length < 8) {
    errors.push('Password must have at least 8 characters');
    password_input.parentElement.classList.add('incorrect');
  }

  if (password !== repeatPassword) {
    errors.push('Password does not match repeated password');
    password_input.parentElement.classList.add('incorrect');
    repeat_password_input.parentElement.classList.add('incorrect');
  }

  return errors;
}

// Validate the login form
function getLoginFormErrors(email, password) {
  let errors = [];

  if (email === '' || email == null) {
    errors.push('Email is required');
    email_input.parentElement.classList.add('incorrect');
  }

  if (password === '' || password == null) {
    errors.push('Password is required');
    password_input.parentElement.classList.add('incorrect');
  }

  return errors;
}

// Event listener to remove error styling once the user starts typing
const allInputs = [firstname_input, email_input, password_input, repeat_password_input].filter(input => input != null);

allInputs.forEach(input => {
  input.addEventListener('input', () => {
    if (input.parentElement.classList.contains('incorrect')) {
      input.parentElement.classList.remove('incorrect');
      error_message.innerText = ''; // Clear error message
    }
  });
});
