let firstName = pm.variables.replaceIn("{{$randomFirstName}}");
let lastName = pm.variables.replaceIn("{{$randomLastName}}");
let email = `${firstName.toLowerCase()}.${lastName.toLowerCase()}@email.com`;

// Generate random age within a range
let minAge = 18;
let maxAge = 22;
let minDay = 1
let maxDay = 28
let minMonth = 1;
let maxMonth = 12;

let age = Math.floor(Math.random() * (maxAge - minAge + 1)) + minAge;
let birthMonth = Math.floor(Math.random() * (maxMonth - minMonth + 1)) + minMonth;
let birthDay = Math.floor(Math.random() * (maxDay - minDay + 1)) + minDay;

// Calculate birth year
let currentDate = new Date();
let birthYear = currentDate.getFullYear() - age;

// Format to DDMMYYYY
let formattedDate = `${String(birthDay).padStart(2, '0')}-${String(birthMonth).padStart(2, '0')}-${birthYear}`;

// Log and save to environment variable
console.log(`Generated Date: ${formattedDate}`);
// pm.environment.set("birthDate", formattedDate);

// Save generated data to environment variables
pm.globals.set("envTestFirstName", firstName);
pm.globals.set("envTestLastName", lastName);
pm.globals.set("envTestDOB", formattedDate);
pm.globals.set("envTestEmail", email);
pm.globals.set("envTestAge", age);

console.log({ firstName, lastName, email, age, formattedDate });