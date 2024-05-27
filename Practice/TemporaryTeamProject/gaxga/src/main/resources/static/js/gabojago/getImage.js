function getImage() {
    fetch('')
        .then(response => response.json())
        .then(data => {
            const imagePath = data.imagePath;
            document.getElementById('image').src = imagePath;
        });
}