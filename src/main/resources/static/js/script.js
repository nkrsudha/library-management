function updateBook(id) {
    const book = {
        title: document.getElementById('title-' + id).value,
        author: document.getElementById('author-' + id).value,
        isbn: document.getElementById('isbn-' + id).value,
        publishedYear: parseInt(document.getElementById('year-' + id).value),
        info: document.getElementById('info-' + id).value,
        available: document.getElementById('available-' + id).value === 'true'
    };

    fetch('/books/' + id, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(book)
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
