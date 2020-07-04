const ajaxsearch = document.getElementById("ajaxsearch");
const postlist = document.getElementById("postlist");

ajaxsearch.addEventListener("keyup", () => {
    showSearchResults("/posts/search/" + ajaxsearch.value);
    console.log(ajaxsearch.value);
});

async function showSearchResults(page) {
    let response = await fetch(page);
    let data = await response.json();
    showResults(data);
}

function showResults(data) {
    console.log(data);
    postlist.innerHTML = "";
    for (let item of data) {
        postlist.innerHTML += `<div class="card">
                                <h2>${item.title}</h2>
                                <h5>${item.postdate}</h5>
                                <p id="postContent"> ${item.content}</p>
                                </div>`;
    }
}