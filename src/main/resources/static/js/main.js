const ajaxsearch = document.getElementById("ajaxsearch");
const postlist = document.getElementById("postlist");
const post_id_delete = document.getElementById("post_id_delete");


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

async function deletePost(id) {
    // const url = "/posts/"+post_id_delete.value;
    const url = '/posts/' + id;
    console.log(url);
    await fetch(url, {
        method: 'DELETE',
        mode: 'cors', credentials: 'same-origin', redirect: 'follow'
    }).then(function (response) {
        console.log(response.url);
        response.url = "http://localhost:8080/"
        window.location.href = response.url;
        if (response.redirected) {
            // window.location.href = response.url;
        }
    });

    // const response = await fetch(url,{method:'GET'});
    // let data = await response.json();
    // console.log(data);
}