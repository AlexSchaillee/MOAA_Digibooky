/**
 * ------------------
 * --- TEST-DATA
 * ------------------
 */

const ISBNS = ["978-1-891830-75-4",
    "978-1-60309-050-6",
    "978-1-60309-266-1",
    "978-1-891830-71-6",
    "978-1-60309-025-4",
    "978-1-60309-047-6",
    "978-1-60309-322-4",
    "978-1-891830-85-3",
    "978-1-60309-016-2",
    "978-1-60309-265-4",
    "978-1-60309-077-3",
    "978-1-60309-369-9",
    "978-1-60309-069-8",
    "978-1-60309-042-1",
    "978-1-60309-026-1"];

const TITLES = [
    "Writing bugs",
    "How to become filthy rich",
    "Dad, are we there yet?",
    "How aliens catnapped my kid",
    "How aliens kidnapped my cat",
    "Thanks Obama",
    "The reason behind reasoning",
    "Dear brother and sister, a story by a mother who became a father.",
    "How to BBQ without fire",
    "My cat is trying to kill me",
    "The story of a man killed by his cat",
    "Why I killed my owner, a story by cat",
    "Clouds are not real",
    "How I traveled around the globe and can know scientifically proof that it's flat!",
    "How crashing my bike became a valuable life lesson",
];

const AUTHOR_FIRSTNAMES = [
    "James",
    "John",
    "Jin",
    "Jun",
    "Jon",
    "Jeremiah",
    "Joseph",
    "Jarred",
    "Jerrad",
    "Jamal",
    "Jumro",
    "Jeff",
    "Jana",
    "Josephina",
    "Jaelle",
];

const AUTHOR_LASTNAMES = [
    "Thomson",
    "Tefferson",
    "Tiko",
    "Trump",
    "Tron",
    "Tremers",
    "Tinkel",
    "Tiange",
    "Twinkel",
    "Twain",
    "Turrimo",
    "Top",
    "Tebone",
    "Tutu",
    "Taberlo",
];

/**
 * CONSTANTS
 */
const BOOKS_RESOURCE = "http://localhost:9123/books";

/**
 * ------------------
 * --- MAIN METHOD
 * ------------------
 */
$(document).ready(function () {
    showBooks();
    searchForIsbn();
    addARandomBook();
});

/**
 * ------------------
 * --- METHODS
 * ------------------
 */
function searchForIsbn() {
    $("#isbn-search-button").click(function () {
        alert("(not yet implemented) You want to search for a book with ISBN: " + $("#isbn-search-input").val());
    });
}

function addARandomBook() {
    $("#add-random-book-button").click(function () {
        $.ajax({
            type: 'POST',
            url: BOOKS_RESOURCE,
            data: getRandomBookDto(),
            success: function () {
                showBooks();
            },
            error: function () {
                alert("It didn't work!!");
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });
}

function showBooks() {
    console.log("Calling backend!");
    $.getJSON(BOOKS_RESOURCE, function (data) {
        console.log("--> Great success!");
        console.log(data);
        if (data.length > 0) {
            $("#injectable").empty();
            data.forEach(function (item) {
                $("#injectable").append(VIEW.renderSingleItem(item), null);
            });
        } else {
            $("#injectable").append("<p>There are no books... Please add some books!</p>", null);
        }
    })
        .done(function () {
            console.log("--> I'm done (successfully)");
        })
        .fail(function () {
            console.log("--> error!");
        })
        .always(function () {
            console.log("--> finalized...");
        });
}

function getRandomBookDto() {
    return `{
        "isbn": "${ISBNS[Math.floor(Math.random() * 15)]}", 
        "title": "${TITLES[Math.floor(Math.random() * 15)]}",
        "authorDto": {
            "firstName": "${AUTHOR_FIRSTNAMES[Math.floor(Math.random() * 15)]}", 
            "lastName": "${AUTHOR_LASTNAMES[Math.floor(Math.random() * 15)]}"
        }
    }`;
}

/**
 * ------------------
 * --- VIEW
 * ------------------
 */
const VIEW = {
    renderSingleItem: (function (book) {
        return `<div class="col-lg-3">
                    <div class="card">
                      <img class="card-img-top img-fluid" src="static/img/cats/cat${Math.floor(Math.random() * 10)}.jpg" alt="${book.title}">
                      <div class="card-body">
                        <h4 class="card-title">${book.title}</h4>
                        <h5 class="card-subtitle mb-2 text-muted">${book.authorDto.firstName} ${book.authorDto.lastName}</h5>
                        <p class="card-text">ISBN: ${book.isbn}</p>
                      </div>
                    </div>
                </div>
            `
    })
};