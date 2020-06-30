let fname = document.getElementById('fname').value;
let lname = document.getElementById('lname').value;
let email = document.getElementById('email').value;
let message = document.getElementById('message').value;
let message1 = document.getElementById('message1');

async function insertMessage() {
    let page = "Blog?todo=insert&fname=" + fname + "&lname=" + lname + "&email=" + email + "&message=" + message;
    console.log(message);
    // populate data to db
    let response = await fetch(page);
    let data = await response.json();
    message1.innerHTML = data.message;

}

function getNum() {
    console.log("js");
}