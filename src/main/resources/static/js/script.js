function updateBook(id) {
    const book = {
        title: document.getElementById('title-' + id).value,
        author: document.getElementById('author-' + id).value,
        isbn: document.getElementById('isbn-' + id).value,
        publishedYear: parseInt(document.getElementById('year-' + id).value),
        info: document.getElementById('info-' + id).value,
        available: document.getElementById('available-' + id).value === 'true'
    };

    fetch('/update-book/' + id, {   
        method: 'POST',             
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `title=${book.title}&author=${book.author}&isbn=${book.isbn}&publishedYear=${book.publishedYear}&info=${book.info}&available=${book.available}`
    })
    .then(response => {
        if (response.ok) {
            alert('Book updated successfully!');
        } else {
            alert('Failed to update book.');
        }
    })
    .catch(error => {
        alert('Error: ' + error);
    });
}
